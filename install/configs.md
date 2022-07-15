## VERSION : 3.1.5
### [CIV-5517] Add View/Print PDF button
    regime {
        allowAllRegimes = false
        allowedExtendedProcedureCodes = ["1000", "3000", "4000"]
        allowedGeneralProcedureCodes = ["1", "3", "4"]
        allowPreviousProcedureCodes = true
        allowedGenProcOnManualVerification = ["3"]
        allowedPreviousProcedureCodes = ["22", "52", "92"]
        vehicleRegime=[ '4000', '4079']
        allowedVehicleCustomsOfc = ['CINOE', 'CIPGO', 'CITKK', 'CIU59']
        vehicleMgtEnabled = true
        atme {
            pattern = "51"
        }
    }
    
##[CIV-5067] - [DOC VIEWER] Update of accounts 
    com{
    	webbfontaine{
    		swviewer{
    			urlws = "http://<host>/sad-ws"
    			gucews = false
    			isBasicAuth = true
    			basicAuth{
    				user = "wf"
    				password = "12345678"
    			}
    		}
    	}
    }
