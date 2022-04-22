package com.cydeo.day3;
import com.cydeo.utillities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cydeo.utillities.SpartanTestBase;

public class SpartanTestWithJsonPath extends SpartanTestBase {
    /*
        Given accept type is json
        And path param id is 10
        When user sends a get request to "api/spartans/{id}"
        Then status code is 200
        And content-type is "application/json"
        And response payload values match the following:
             id is 10,
             name is "Lorenza",
             gender is "Female",
             phone is 3312820936
      */

    @DisplayName("GET one spartan with JsonPath")
    @Test
    public void test1(){

        Response response = given()
                                .accept(ContentType.JSON)
                                .pathParam("id" , 10)
                                .when().get("/api/spartans/{id}");


        assertEquals(200, response.statusCode());
        assertEquals("application/json" , response.contentType());


        //print the name

        System.out.println(response.path("name").toString());

        //save jsonpath object from response

        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("name");
        System.out.println("name = " + name);

        //save into variables


        int id = jsonPath.getInt("id");
        System.out.println("id = " + id);

        String name1 = jsonPath.getString("name");

        String gender = jsonPath.getString("gender");
        System.out.println("gender = " + gender);

        long phone = jsonPath.getLong("phone");
        System.out.println("phone = " + phone);


        //assertions
        assertEquals(10,id);
        assertEquals("Lorenza", name);
        assertEquals("Female",gender);
        assertEquals("3312820936", phone);


    }

}

