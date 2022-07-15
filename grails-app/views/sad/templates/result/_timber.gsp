<g:if test="${resultList?.size() > 0}">
    <ul class="thumbnails nobullet" id="hover-cap-4col">
            <g:each in="${resultList?.flatten()}" var="result">
                <g:if test="${result?.id}">
                    <g:render template="/sad/templates/result/content"
                              model="[result: result, status: result?.status, appName: appName, reference : result?.reference]"/>
                </g:if>

            </g:each>
    </ul>
</g:if>
<g:else>
    <p>Aucune données trouvées</p>
</g:else>