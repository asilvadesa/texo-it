package com.texoit.desafio.comments;

import com.texoit.desafio.base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.texoit.desafio.specs.BaseRequestSpec.baseRequestSpecs;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

@DisplayName("Teste Funcional para o edpoint /comments")
public class CommentsTest extends BaseTest {

    @Test
    @DisplayName("Valida buscar comments")
    void validaBuscaComments(){
        given().
            spec(baseRequestSpecs()).
            basePath(PATH_COMMENTS).
            queryParam("name", "alias odio sit").
        expect().
            statusCode(HttpStatus.SC_OK).
            body("email", contains("Lew@alysha.tv")).
        when()
            .get();
    }
}
