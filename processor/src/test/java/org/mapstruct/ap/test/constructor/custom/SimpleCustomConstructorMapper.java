/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.constructor.custom;

import org.mapstruct.Mapper;
import org.mapstruct.ap.test.constructor.Person;
import org.mapstruct.ap.test.constructor.PersonDto;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SimpleCustomConstructorMapper {

    SimpleCustomConstructorMapper INSTANCE = Mappers.getMapper( SimpleCustomConstructorMapper.class );

    PersonWithCustomConstructor mapWithCustomConstructor(PersonDto dto);

    Person mapWithoutCustomConstructor(PersonDto dto);
}
