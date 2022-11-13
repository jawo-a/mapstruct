/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.spi;

import org.mapstruct.util.Experimental;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * A service provider interface that can override the rules for determining which constructor will be used
 * to create an instance of a mapping target type.
 *
 * @author Jakub Wójcik
 * @since 1.6
 */
@Experimental( "This interface may change in future revisions" )
public interface CustomConstructorProvider {

    /**
     * Find a constructor to instantiate the given mapping target type.
     * <p>
     * If no custom constructor is found, the documented rules determine
     * which constructor will be used to create an instance of the mapping target type.
     * </p>
     *
     * @param targetType the mapping target type, to find the custom constructor for
     * @return the custom constructor, or {@code null}
     */
    ExecutableElement findConstructor(TypeElement targetType);
}
