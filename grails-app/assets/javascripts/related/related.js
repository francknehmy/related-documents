$(document).ready(function(){
    makeAjaxAutocomplete('officeOfDispatchExportCode',
        'HT_CUO',
        "code,description",
        'code,description',
        "code,description", labelSetter, '110');
    initLoadTimberDocuments()
});

function initLoadTimberDocuments() {
    let clearanceOfficeCode = $("#officeCode").val()
    let declarationSerial = $("#declarationSerial").val()
    let declarationNumber = $("#declarationNumber").val()
    let declarationDate = $("#declarationDate").val()

    const url = $("#retrieveTimberUrl").val();
    console.log(url)
    return $.ajax({
        type: 'POST',
        url: url,
        data : {
            clearanceOfficeCode : clearanceOfficeCode,
            clearanceDeclarationSerial : declarationSerial,
            clearanceDeclarationNumber : declarationNumber,
            clearanceDeclarationDate : declarationDate
        },
        error: function (error) {

        },
        success: function (data) {
            if(data.template){
                $("#timberTemplate").html(data.template)
                // if(!(data.template.includes('licensePdfImg') || data.template.includes('insurancePdfImg')
                //     || data.template.includes('cocPdfImg') || data.template.includes('bscPdfImg'))){
                //     $("#preClearanceSection").addClass("hideRelatedDocumentSection");
                // }
            }
            initThumbnails();
            // initRelatedDocumentTabTooltips();
        }
    });
}

function initThumbnails() {
    $("[rel='tooltip']").tooltip();

    $('#hover-cap-4col .thumbnail').hover(
        function(){
            $(this).find('.caption').fadeIn(250); //.fadeIn(250)
        },
        function(){
            $(this).find('.caption').fadeOut(250); //.fadeOut(205)
        }
    );
}

function labelSetter(sourceId, item) {
    var val = $('#' + sourceId).val();
    if (val && item || !val && !item) {
        const itemPropertyToSet = ['name', 'description', 'nameI18n', 'exo_nam'];

        let value = '';
        let addressValue = '';

        if (item) {
            for (let it in itemPropertyToSet) {
                let prop = itemPropertyToSet[it];
                value = item[prop];
                if (value) {
                    break;
                }
            }

            if (item['address1']) {
                addressValue = item['address1']
            }
        }
        let targetId = sourceId + 'Name';
        let addressField = sourceId + 'Address';

        if (targetId.indexOf('Code') > -1) {
            targetId = sourceId.toString().replace("Code", "") + 'Name';
            addressField = sourceId.toString().replace("Code", "") + 'Address';
        }

        if (sourceId.indexOf('docType_') > -1) {
            targetId = "docTypeName_" + sourceId.charAt(sourceId.length - 1)
        }
        if (targetId) {
            $('#' + targetId).val(value);
            $('#' + targetId).html(value);
        }
        if (addressField) {
            $('#' + addressField).val(addressValue);
        }
    }
}