package com.texoit.desafio.users;

import com.texoit.desafio.base.BaseTest;
import com.texoit.desafio.domain.Address;
import com.texoit.desafio.domain.Geo;
import com.texoit.desafio.domain.User;
import com.texoit.desafio.factory.UserDataFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.texoit.desafio.specs.BaseRequestSpec.baseRequestSpecs;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@DisplayName("Teste Funcional para o edpoint /users")
public class UsersTest extends BaseTest {

    @Test
    @DisplayName("Valida Cadastrar um usuario com sucesso")
    void validaCadastrarUsuario(){
        given().
            spec(baseRequestSpecs()).
            basePath(PATH_USERS).
            body(UserDataFactory.newUser()).
        expect().
            statusCode(HttpStatus.SC_CREATED).
            body("id", notNullValue()).
        when().
            post().
        then().
        extract().
                response().
            as(User.class);
    }

    @Test
    @DisplayName("Valida alterar dados do usuario com sucesso")
    void validaAlterarDadosDoUsuarioComSucesso(){

        User user =  given().
            spec(baseRequestSpecs()).
            basePath(PATH_USERS).
        expect().
            statusCode(HttpStatus.SC_OK).
        when().
            get("5")
        .then()
            .extract().response().as(User.class);

        user.setEmail("fakerEmail@mock.com");
        Geo geo = user.getAddress().getGeo();
        geo.setLat("-38.1234");
        geo.setLng("82.1234");

        Address address = user.getAddress();
        address.setGeo(geo);

        user.setAddress(address);

        given().
            spec(baseRequestSpecs()).
            basePath(PATH_USERS).
            body(user).
        expect().
            statusCode(HttpStatus.SC_OK).
            body("email", is(user.getEmail())).
            body("address.geo.lat", is(user.getAddress().getGeo().getLat())).
            body("address.geo.lng", is(user.getAddress().getGeo().getLng())).
        when().
            put("5");
    }
}
