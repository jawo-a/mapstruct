/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.constructor.custom;

import java.util.List;

public class PersonWithCustomConstructor {

    private String name;
    private int age;
    private String job;
    private String city;
    private String address;
    private List<String> children;

    public PersonWithCustomConstructor() {
    }

    @Custom
    public PersonWithCustomConstructor(String name, int age, String job, String city, List<String> children) {
        this( name, age, job, city, null, children );
    }

    public PersonWithCustomConstructor(String name, int age, String job, String city, String address,
                                       List<String> children) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.city = city;
        this.address = address;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getChildren() {
        return children;
    }
}
