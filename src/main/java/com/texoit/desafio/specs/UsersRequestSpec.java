package com.texoit.desafio.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UsersRequestSpec {

    public static RequestSpecification usersRequestSpecs(){
        return new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                setContentType(ContentType.JSON).
                build();
    }
}
