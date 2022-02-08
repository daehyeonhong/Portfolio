package com.project.portfolio.mapper.config;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface GenericMapper<Dto, Entity> {

    Dto toDTO(Entity entity);

    Entity toEntity(Dto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(Dto dto, @MappingTarget Entity entity);

}
