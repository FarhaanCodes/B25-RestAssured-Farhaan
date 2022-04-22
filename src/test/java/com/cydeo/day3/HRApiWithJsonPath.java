package com.cydeo.day3;

import com.cydeo.utillities.HrTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cydeo.utillities.HrTestBase;

public class HRApiWithJsonPath extends HrTestBase {


    @Test
    public void test1(){


        Response response = get("/countries");

        //items[3].country_name

        //we want to use JsonPath to get that value
        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("items[3].country_name");
        System.out.println(name);


        //get all country_name
        //items.country_name

        List<String> names = jsonPath.getList("items.country_name");

        System.out.println("names = " + names);

        //print countries one by one

        for (String each : names){
            System.out.println(each);
        }

        //get me all country names where their region id is 2
        List<Object> countrylistwith2 = jsonPath.getList("items.findAll {it.region_id==2}.country_id");
        System.out.println("countrylistwith2 = " + countrylistwith2);
    }

}
