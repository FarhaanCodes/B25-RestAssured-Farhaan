package com.cydeo.utillities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrTestBase {

    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://54.226.233.106:1000/ords/hr";
    }
}
