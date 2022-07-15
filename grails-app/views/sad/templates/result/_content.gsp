<g:set var="status" value="${status}" scope="request"/>
    <li class="span3 list-img"
        style="margin: 0 10px !important; width: 160px !important;">
        <div class="thumbnail">
            <h6 style="background-color:green" class="badge badge-default thmb_Bdg">
                    <g:message code="module.${appName}.${status}" default="${status}"/>
            </h6>
            <div class="caption">
                <div class="thumbnail-btns">
                    <a href="javascript:void(0)" class="btn actionBtns" rel="tooltip"
                       >
                        <g:message code="related.document.open"/>
                    </a>
                </div>
            </div>
            <img id="thumbnailImg" src="${createLinkTo(dir: 'images', file: "${appName}PdfImg.png")}"
                 alt="Grails"/>
        </div>
        <div class="referenceDetails">
            <p class="relatedDocumentReference"><b>${reference}</b></p>
        </div>
    </li>