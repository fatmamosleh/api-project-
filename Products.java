package com.fakestore.TestCases;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
public class
Products {static RequestSpecification request;
    @BeforeClass
    public static void beforeClass(){
        request = given()
                .baseUri("https://fakestoreapi.com").log().all();

    }
    @Test
    public void getAllProducts(){

        given()
                .spec(request)
                .when()
                .get("/products")
                .then().log().all().assertThat().statusCode(200)
                .body("[0].id",equalTo(1));
    }
    @Test
    public void singleProducts(){
        given()
                .spec(request)
                .when()
                .get("/products/1")
                .then().log().all().assertThat().statusCode(200)
                .body("id",equalTo(1));
    }
    @Test
    public void getlimitResults(){
        given()
                .spec(request)
                .when()
                .get("/products?limit=5")
                .then().log().all().assertThat().statusCode(200)
                .body("[1].id",equalTo(2));
    }









    }

