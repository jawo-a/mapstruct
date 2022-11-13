/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.constructor.custom;

import org.mapstruct.ap.spi.CustomConstructorProvider;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import java.util.List;

/**
 * Test implementation of the {@link CustomConstructorProvider} SPI
 * that designates the first constructor annotated with {@link Custom}
 * as the custom constructor.
 *
 * @author Jakub Wójcik
 */
public class TestCustomConstructorProvider implements CustomConstructorProvider {

    @Override
    public ExecutableElement findConstructor(TypeElement targetType) {
        final List<ExecutableElement> constructors = ElementFilter.constructorsIn( targetType.getEnclosedElements() );

        for (ExecutableElement constructor : constructors) {
            if (constructor.getAnnotation( Custom.class ) != null) {
                return constructor;
            }
        }

        return null;
    }
}
