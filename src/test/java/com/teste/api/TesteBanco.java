package com.teste.api;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class TesteBanco {
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void aTesteDeExistenciaDeUsuarioFalho(){
        given().contentType(ContentType.JSON).
                when().get("/user/1").
                        then().statusCode(404);
    }
    @Test
    public void bTesteInclusaoDeUsuario(){
        given().contentType(ContentType.JSON).body("{\n" +
                "  \"balance\":\"400000.0\",\n" +
                "  \"password\":\"12345678\",\n" +
                "  \"email\":\"a.santos@gmail.com\",\n" +
                "  \"username\":\"Jose Augusto\"\n" +
                "}").
                when().post("/user").
                        then().statusCode(201);
    }
    @Test
    public void cTesteDeListagemDeUsuario(){
        given().contentType(ContentType.JSON).
                when().get("/user/1").
                        then().statusCode(200);
    }
    @Test
    public void dTesteRemoverUsuario(){
        given().contentType(ContentType.JSON).
                when().delete("/user/1").
                        then().statusCode(204);


    }
}
