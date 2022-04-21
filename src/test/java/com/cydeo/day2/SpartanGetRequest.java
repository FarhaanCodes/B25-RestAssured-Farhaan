package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {

    String url = "http://54.226.233.106:8000";

    /*

    Given Accept type is application/json
    When user send GET request to /api/spartans end point
    Then status ode must be 200
    And response content type must be application/json

     */
    @DisplayName("GET Request for /api/spartans")
    @Test
    public void test1(){

        Response response =
        RestAssured.
                given().accept(ContentType.JSON).when().get(url + "/api/spartans");

        // Print Status Code
        System.out.println("response.statusCode() = " + response.statusCode());

        // Print Content Type
        System.out.println("response.contentType() = " + response.contentType());

        //how to test api?
        //verify status code is 200

        Assertions.assertEquals(200, response.statusCode());

        //verify content type is application json
        Assertions.assertEquals("application/json" , response.contentType());

    }

    /*

        Given Accept header is application/json
        When users send a get request to /api/spartans/3
        Then status code must be 200
        and Content type must be application/json
        and json body should contain 'Fidole

     */
    @DisplayName("GET Individual Spartan")
    @Test
    public void test2(){
        Response response =

                RestAssured.given().accept(ContentType.JSON).get(url+ "/api/spartans/3");


        // Print Status Code
        System.out.println("response.statusCode() = " + response.statusCode());

        // Print Content Type
        System.out.println("response.contentType() = " + response.contentType());

        // verify status code is 200
        Assertions.assertEquals(200,response.statusCode() );

        // verify content type is JSON
        Assertions.assertEquals("application/json" , response.contentType());

        //verify Fidole exist in json body
        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }

    /*
            Given no headers provided
            When Users send GET request to /api/hello
            Then response status code should be 200
            And Content Type header should be "text/plain;charset=UTF-8"
            and Header should contain date
            and Content-Length should be 17
            and body should be "Hello from Sparta"
     */

    @DisplayName("GET Request to /api/hello endpoint")
    @Test
    public void test3(){

            Response response = RestAssured.when().get(url + "/api/hello");

            response.prettyPrint();

            //verify status code
            Assertions.assertEquals(200 , response.statusCode());

            //verify content type
            Assertions.assertEquals("text/plain;charset=UTF-8" , response.contentType());

            //verify date header exists in Response headers
            // we use hasHeaderWithName method to verify header exists or not - it returns boolean
            Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

            // to get header value we use header method which accepts header name as paramenter and returns value as string
            System.out.println("response.headers(\"Content-Length\") = " + response.header("Content-Length"));
            System.out.println("response.header(\"Connection\") = " + response.header("Connection"));


            //verify content is 17
            Assertions.assertEquals("17", response.header("Content-Length"));

            //verify body is "hello from sparta"

            Assertions.assertEquals("Hello from Sparta", response.body().asString());

    }


}
