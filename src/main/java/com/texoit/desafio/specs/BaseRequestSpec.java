package com.texoit.desafio.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequestSpec {

    public static RequestSpecification baseRequestSpecs(){
        return new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                setContentType(ContentType.JSON).
                build();
    }
}
