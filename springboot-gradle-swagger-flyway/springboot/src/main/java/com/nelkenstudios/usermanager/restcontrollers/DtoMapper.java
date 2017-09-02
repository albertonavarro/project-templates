package com.nelkenstudios.usermanager.restcontrollers;

import com.navid.codegen.recordserver.model.ListOrganizationsResponse;
import com.nelkenstudios.usermanager.domain.Org;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoMapper {

    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    ListOrganizationsResponse sourceToTarget(Org source);

    @InheritInverseConfiguration
    Org targetToSource(ListOrganizationsResponse target);
}
