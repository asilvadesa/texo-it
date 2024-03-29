package com.texoit.desafio.base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {


    protected static final String PATH_USERS = "/users";
    protected static final String PATH_COMMENTS = "/comments";

    @BeforeAll
    public static void setup(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
