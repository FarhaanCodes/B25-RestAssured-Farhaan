package com.cydeo.day3;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpartanTestsWithParameters extends SpartanTestBase {

    /*
        Given Accept type is JSON
        and ID parameter value is 5
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 200
        and response Content-type: application/json
        and "Blythe" should be in response payload
     */

    @DisplayName("GET Request to /api/spartans/{id} with ID 5")
    @Test
    public void test1(){

       Response response =

               given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id", 5)
                .when()
                .get("/api/spartans/{id}");

        //verify status code
        assertEquals(404, response.statusCode());

        //verify content type
        assertEquals("application/json" , response.contentType());

        //verify "Blythe" inside the payload
        assertTrue( response.body().asString().contains("Blythe"));

        response.prettyPrint();
    }

        /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */

    @DisplayName("GET request with ID 500")
    @Test
    public void test2() {

      Response response  =
              given()
                    .accept(ContentType.JSON)
                    .and()
                    .pathParam("id", 500)
                    .when()
                    .get("/api/spartans/{id}");

            assertEquals(404 , response.statusCode());

            assertEquals("application/json", response.contentType());

            assertTrue(response.body().asString().contains("Not Found"));

            response.prettyPrint();

    }


        /*
        Given Accept type is Json
        And query parameter values are:
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search
        Then response status code should be 200
        And response content-type: application/json
        And "Female" should be in response payload
        And "Janette" should be in response payload
     */


    @DisplayName("GET request to /api/spartans/search with query parameter")
    @Test
    public void test3(){

        Response response =
                             given().log().all()
                                     .accept(ContentType.JSON)
                                     .and().queryParam("gender" , "Female")
                                     .and().queryParam("nameContains" , "e")
                                     .when().get("/api/spartans/search");


        // Verifies Status Code
        assertEquals(200, response.statusCode());

        //Verifies Content Type
        assertEquals("application/json", response.contentType());

        //Verifies if payload contains Female
        assertTrue(response.body().asString().contains("Female"));

        //Verified if payload contains Janette
        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();
    }


    @DisplayName("GET request to /api/spartans/search with Query Param (MAP)")
    @Test
    public void test4(){
        //Create a map and store query params information

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("gender" , "Female");
        queryMap.put("nameContains", "e");


        Response response =

                given().log().all()
                        .accept(ContentType.JSON)
                        .queryParams(queryMap)
                        .when().get("/api/spartans/search");


        // Verifies Status Code
        assertEquals(200, response.statusCode());

        //Verifies Content Type
        assertEquals("application/json", response.contentType());

        //Verifies if payload contains Female
        assertTrue(response.body().asString().contains("Female"));

        //Verified if payload contains Janette
        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();


    }





}
