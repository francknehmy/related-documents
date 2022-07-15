package com.webbfontaine.related.sad

import com.webbfontaine.grails.plugins.search.QueryBuilder
import com.webbfontaine.related.sad.command.SearchCommand
import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.api.Criteria
import org.hibernate.transform.AliasToBeanResultTransformer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.StopWatch
import javax.annotation.PreDestroy
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

@Transactional
class SadSearchService{
    static transactional = false
    private static final Logger LOGGER = LoggerFactory.getLogger(SadSearchService.class)

    def searchService
    def sadSecurityService
    private final ExecutorService searchThreadPool = Executors.newFixedThreadPool(20);

    private volatile static Collection<String> allResultFields;


    def getSearchResults(searchCommand, params) {
        QueryBuilder queryBuilder = new QueryBuilder(searchCommand)


        Future total = searchThreadPool.submit(
                new TotalCountResolver(SecurityContextHolder.context, searchCommand, queryBuilder)
        )
        Future results = searchThreadPool.submit(
                new ResultResolver(SecurityContextHolder.context, searchCommand, queryBuilder, params)
        )

        def totalCount
        def resultList

        try {
            totalCount = total.get()
            resultList = totalCount ? results.get() : Collections.emptyList()

        } catch (InterruptedException | ExecutionException e) {
            totalCount = 0
            resultList = Collections.emptyList()
            LOGGER.error("Error in fetching Sad result:{}", e.message)
        }


        totalCount = totalCount > 5000 ? 5000 : totalCount
        def searchResultMessage = searchService.getSearchResultMessage(resultList?.size(), totalCount)

        return [actionsTemplatePlugin: 'wf-workflow',
                actionsTemplate      : '/common/templates/finderOperations',
                searchCommand          : searchCommand,
                max                    : searchService.searchMax,
                resultList             : resultList,
                totalCount             : totalCount,
                paramForUniqueOperation: true,
                searchResultMessage    : searchResultMessage,
                resultFieldStyles: [:]]
    }

    private getSearchResult(QueryBuilder queryBuilder, SearchCommand searchCommand, params) {
        def listCriteria = Sad.createCriteria()
        StopWatch watch = new StopWatch()
        watch.start()
        def max = params.long('max') ?: searchService.searchMax
        def resultList = listCriteria.list(max:max, offset: searchService.getSearchOffset(params)) {
            queryBuilder.initListCriteria(listCriteria, false)
            applyOrder(listCriteria, params)
            resultTransformer(new AliasToBeanResultTransformer(Sad.class))
            projections {
                resultFields.each {
                    if (!it.equals("company"))
                        property(it, it)
                }
                property("consigneeCode", "consigneeCode")
                property("exporterCode", "exporterCode")
            }
        }

        logActivity("GetSearchResult", resultList.size(), watch)
        LOGGER.debug("Got ${resultList.size()} result(s)")
        return resultList
    }

    private static Collection<String> getResultFields() {
        if (!allResultFields) {
            synchronized (SadSearchService.class) {
                if (allResultFields == null) {
                    allResultFields = SearchCommand.resultFields.collect { it.getName() } + ['id']
                }
            }
        }
        return allResultFields
    }

    private getTotalCount(SearchCommand searchCommand, QueryBuilder queryBuilder) {
        Criteria countCriteria = Sad.createCriteria()
        StopWatch watch = new StopWatch()
        watch.start()

        def countResult =  countCriteria.get {
            queryBuilder.initCountCriteria(countCriteria)
            projections { count() }
        }

        logActivity("GetTotalCount", countResult, watch)
        return countResult
    }


    class TotalCountResolver implements Callable {
        SecurityContext securityContext
        QueryBuilder queryBuilder
        SearchCommand searchCommand

        TotalCountResolver(SecurityContext securityContext,SearchCommand searchCommand, QueryBuilder queryBuilder) {
            this.securityContext = securityContext
            this.queryBuilder = queryBuilder
            this.searchCommand = searchCommand
        }

        @Override
        Object call() throws Exception {
            def result = null
            try {
                SecurityContextHolder.setContext(securityContext);
                result = getTotalCount(searchCommand, queryBuilder)
            } finally {
                SecurityContextHolder.clearContext();
            }
            return result
        }
    }

    @PreDestroy
    void cleanUp() throws Exception {
        searchThreadPool.shutdown()
    }

    class ResultResolver implements Callable {
        SecurityContext securityContext
        SearchCommand searchCommand
        QueryBuilder queryBuilder
        Map params

        ResultResolver(SecurityContext securityContext, SearchCommand searchCommand, QueryBuilder queryBuilder, Map params) {
            this.securityContext = securityContext
            this.searchCommand = searchCommand
            this.queryBuilder = queryBuilder
            this.params = params
        }

        @Override
        Object call() throws Exception {
            def resultList = null
            try {
                SecurityContextHolder.setContext(securityContext);
                resultList = getSearchResult(queryBuilder, searchCommand, params)
            } finally {
                SecurityContextHolder.clearContext();
            }
            return resultList
        }
    }

    private static void applyOrder(Criteria criteria, Map<String, String> params) {
        if (params.sort) {
            criteria.order(params.sort, params.order)
        } else {
            criteria.order("id", "desc")
        }
    }

    private logActivity(String process, def result, StopWatch watch){
        watch.stop()
        String user = sadSecurityService.getUsername()
        def time = watch.getTotalTimeMillis()
        LOGGER.debug("{} Method: [user: {}, result: {}, execute time: {} ms]", process , user, result, time)

    }
}
