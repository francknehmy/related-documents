package com.webbfontaine.related

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class BootStrap {
    private static final Logger LOG = LoggerFactory.getLogger(BootStrap.class);

    def init = { servletContext ->
        LOG.debug("--------------------------SW-FINDER.Bootstrap--------------------------")

        environments {
            development {
            }
        }
    }
    def destroy = {
    }

}
