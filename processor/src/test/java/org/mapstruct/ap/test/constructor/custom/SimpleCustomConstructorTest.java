/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.constructor.custom;

import org.mapstruct.ap.test.constructor.Person;
import org.mapstruct.ap.test.constructor.PersonDto;
import org.mapstruct.ap.testutil.ProcessorTest;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.WithServiceImplementation;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jakub Wójcik
 */
@WithClasses({
        Custom.class,
        Person.class,
        PersonDto.class,
        PersonWithCustomConstructor.class,
        SimpleCustomConstructorMapper.class
})
@WithServiceImplementation(TestCustomConstructorProvider.class)
public class SimpleCustomConstructorTest {

    @ProcessorTest
    public void mapUsingCustomConstructor() {
        PersonDto source = new PersonDto();
        source.setName( "Bob" );
        source.setAge( 30 );
        source.setJob( "Software Engineer" );
        source.setCity( "Zurich" );
        source.setAddress( "Plaza 1" );
        source.setChildren( Arrays.asList( "Alice", "Tom" ) );

        PersonWithCustomConstructor target = SimpleCustomConstructorMapper.INSTANCE.mapWithCustomConstructor( source );

        assertThat( target.getName() ).isEqualTo( "Bob" );
        assertThat( target.getAge() ).isEqualTo( 30 );
        assertThat( target.getJob() ).isEqualTo( "Software Engineer" );
        assertThat( target.getCity() ).isEqualTo( "Zurich" );
        assertThat( target.getAddress() ).isEqualTo( null );
        assertThat( target.getChildren() ).containsExactly( "Alice", "Tom" );
    }

    @ProcessorTest
    public void mapWithoutUsingCustomConstructor() {
        PersonDto source = new PersonDto();
        source.setName( "Bob" );
        source.setAge( 30 );
        source.setJob( "Software Engineer" );
        source.setCity( "Zurich" );
        source.setAddress( "Plaza 1" );
        source.setChildren( Arrays.asList( "Alice", "Tom" ) );

        Person target = SimpleCustomConstructorMapper.INSTANCE.mapWithoutCustomConstructor( source );

        assertThat( target.getName() ).isEqualTo( "Bob" );
        assertThat( target.getAge() ).isEqualTo( 30 );
        assertThat( target.getJob() ).isEqualTo( "Software Engineer" );
        assertThat( target.getCity() ).isEqualTo( "Zurich" );
        assertThat( target.getAddress() ).isEqualTo( "Plaza 1" );
        assertThat( target.getChildren() ).containsExactly( "Alice", "Tom" );
    }
}
