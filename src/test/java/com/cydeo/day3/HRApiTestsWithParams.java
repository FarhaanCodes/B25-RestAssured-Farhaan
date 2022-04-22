package com.cydeo.day3;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HRApiTestsWithParams extends HrTestBase {



    @Test
    public void test1(){

        Response response = get("/regions");

        response.prettyPrint();


    }

/*

        Given Accept type is Json
        Parameters: q = {"region_id":2}
        When users send a GET request to "/countries"
        Then status code is 200
        Content Type is application/json
        Payload should contain "United States of America"


 */

    @Test
    public void test2(){


            Response response = given().log().all()
                                .accept(ContentType.JSON)
                                .and().queryParam("q", "{\"region_id\":2}")
                                .when().get("/countries");


            response.prettyPrint();

            assertEquals(200 , response.statusCode());
            assertEquals("application/json", response.contentType());
            assertTrue(response.body().asString().contains("United States of America"));

    }

    /*

            Send GET request to employees and get only employees who work as a IT_PROG
     */


    @Test
    public void test3(){


        Response response = given()
                            .accept("application/json")
                                .and().queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                            .when().get("/employees/");


        response.prettyPrint();
    }
}
