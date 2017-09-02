package com.nelkenstudios.usermanager.controllers

class LoginControllerTest extends spock.lang.Specification {
    def "Welcome"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }
}
