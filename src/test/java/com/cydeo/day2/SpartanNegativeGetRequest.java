package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpartanNegativeGetRequest {

    //beforeAll is the same thing with beforeClass in testing
    @BeforeAll
    public static void init()  {
        RestAssured.baseURI = "http://54.226.233.106:8000";
    }

    @DisplayName("GET Request for /api/spartans")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).when().get("/api/spartans");

        // Print Status Code
        System.out.println("response.statusCode() = " + response.statusCode());

        // Print Content Type
        System.out.println("response.contentType() = " + response.contentType());

        //how to test api?
        //verify status code is 200

        assertEquals(200, response.statusCode());

        //verify content type is application json
        assertEquals("application/json" , response.contentType());

    }

    /*
            Given Accept type application/xml
            When user send GET Request to /api/spartans/10 end point
            Then status code must be 406
            And response Content Type must be application/xml;charset=UTF-8;

     */

    @Test
    public void test2(){

        Response response = given().accept(ContentType.XML).when().get("/api/spartans/10");

        response.prettyPrint();

        // Shows the status code and verifies it
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(406, response.statusCode());


        // Shows what content type it is and verifies it as well
        System.out.println("response.contentType() = " + response.contentType());
        assertEquals("application/xml;charset=UTF-8" , response.contentType());



    }
}
