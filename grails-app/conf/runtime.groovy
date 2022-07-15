com {
    webbfontaine {
        grails {
            plugins {
                utils {
                    dateTimeConverter {
                        localDate = ["dd/MM/yyyy", "yyyy-MM-dd"]
                        dateTime = ["dd/MM/yyyy HH:mm:ss"]
                    }
                }
                security {
                    active = true
                    auth = true
                    config = "Requestmap"
                    users {
                        admin {
                            roles = ['related_admin']
                        }
                    }
                    paths {
                        sad {
                            roles = ['related_admin']
                        }
                    }
                    ignore = ['/actuator/**']
                }
            }
        }
    }
}