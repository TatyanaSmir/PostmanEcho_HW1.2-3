package ru.netology.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnSomeData1(){
        given()
                .baseUri("https://postman-echo.com")
                .body("Surname Kuznetsov")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Surname Kuznetsov"))
        ;
    }
    @Test
    void shouldReturnSomeData2(){
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Фамилия Кузнецов")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",equalTo("Фамилия Кузнецов"))
        ;
    }
}
