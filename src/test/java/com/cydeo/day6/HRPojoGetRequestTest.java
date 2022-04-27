package com.cydeo.day6;
import com.cydeo.pojo.Employee;
import com.cydeo.pojo.Region;
import com.cydeo.utilities.HrTestBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class HRPojoGetRequestTest extends HrTestBase{

    @Test
    public void test1(){

        JsonPath jsonPath = get("/regions").then().statusCode(200).log().body().extract().jsonPath();


        //we want to store second region under items in Region class object
        Region region2 = jsonPath.getObject("items[1]", Region.class);

        System.out.println("region2.getRegionId() = " + region2.getRegionId());
        System.out.println("region2.getRegionName() = " + region2.getRegionName());
        System.out.println(region2.getLinks().get(0).getHref());


    }

    @Test
    public void test2(){

        JsonPath jsonPath = get("/employees").then().statusCode(200).extract().jsonPath();

        Employee employee = jsonPath.getObject("items[0]",Employee.class);

        System.out.println("employee.getJob_Id() = " + employee.getJobId());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getSalary());
    }

        /*
        send a get request to regions
        verify that region ids are 1,2,3,4
        verify that regions names Europe ,Americas , Asia, Middle East and Africa
        verify that count is 4
        try to use pojo as much as possible
        ignore non-used fields
     */
}
