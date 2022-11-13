/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.internal.model;

import org.mapstruct.ap.spi.CustomConstructorProvider;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * The default implementation of the {@link CustomConstructorProvider} SPI
 * that never finds a custom constructor.
 */
public class NoOpCustomConstructorProvider implements CustomConstructorProvider {

    @Override
    public ExecutableElement findConstructor(TypeElement targetType) {
        return null;
    }
}
