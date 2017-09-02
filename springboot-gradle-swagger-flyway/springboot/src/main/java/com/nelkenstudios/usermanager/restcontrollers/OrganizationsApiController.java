package com.nelkenstudios.usermanager.restcontrollers;

import com.navid.codegen.recordserver.api.OrganizationsApi;
import com.navid.codegen.recordserver.model.ListOrganizationsResponse;
import com.nelkenstudios.usermanager.domain.Org;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrganizationsApiController implements OrganizationsApi {

    @RequestMapping(value = "/organizations",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<ListOrganizationsResponse> getOrganizations(
            @RequestHeader(value="correlationId", required=false) String correlationId) {
        // do some magic!
        return new ResponseEntity<>(DtoMapper.INSTANCE.sourceToTarget(new Org()), HttpStatus.OK);
    }

}
