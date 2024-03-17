package com.texoit.desafio.users;

import com.texoit.desafio.base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.texoit.desafio.specs.UsersRequestSpec.usersRequestSpecs;
import static io.restassured.RestAssured.given;

@Tag("funcional")
@DisplayName("Teste Funcional para o edpoint /users")
public class UsersTest extends BaseTest {


    @Test
    void validaConsultaDeUsuarios(){

        given().
            spec(usersRequestSpecs()).
            basePath(URI_USERS).
        expect().
            statusCode(HttpStatus.SC_OK).
        when().
            get();
    }

}
