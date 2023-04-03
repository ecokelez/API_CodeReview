package get_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.*;
import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;
import static org.hamcrest.Matchers.*;


public class Get18 extends DummyRestApiBaseUrl {
     /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                   iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770

        Given
            https://dummy.restapiexample.com/api/v1/employees => Onkosul-EndPoint
        When
            User sends Get Request
        Then
            i) Status code is 200
        And
            ii) There are 24 employees
        And
            iii) "Tiger Nixon" and "Garrett Winters" are among the employees
        And 
            iv) The greatest age is 66
         And
            v) The name of the lowest age is "Tatyana Fitzpatrick"
         And
            vi) Total salary of all employees is 6,644,770
    */

    @Test
    public void get01() {
        spec.pathParams("first","employees");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        response.then().assertThat().
                statusCode(200).
                body("data.id",hasSize(24),
                        "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("ages : " + ages);
        Collections.sort(ages);
        System.out.println("Sorted ages : " + ages);
        System.out.println("The greatest age : " + ages.get(ages.size()-1));
        assertEquals(66,(int)ages.get(ages.size()-1));
        List<String> lowestAgeEmployee = response.jsonPath().getList("data.findAll{it.employee_age == "+ages.get(0)+"}.employee_name");
        System.out.println("lowestAgeEmployee : " + lowestAgeEmployee);
        //assertEquals("[Tatyana Fitzpatrick]",lowestAgeEmployee);
        List<Integer> salaries = response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries : " + salaries);

        int sum = 0;
        for (int w:salaries) {
                sum += w;
        }
        System.out.println("sum : " + sum);
        assertEquals( 6644770,sum);

        //Methods with Lambda
        // 1-
        int sum01 = salaries.stream().reduce(0,(t,u)->t+u);
        System.out.println("sum01 : " + sum01);
        assertEquals(6644770,sum01);
        // 2-
        int sum02 = salaries.stream().reduce(0,Integer::sum);
        System.out.println("sum02 = " + sum02);
        assertEquals(6644770,sum02);
        // 3-
        int sum03 = salaries.stream().reduce(0,Math::addExact);
        System.out.println("sum03 : " + sum03);
        assertEquals(6644770,sum03);


    }
}
