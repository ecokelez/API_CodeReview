package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get13 extends GoRestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Bhudeva Deshpande II", "Tanirika Kaul" and "Aaryan Shukla DVM" are among the users
        And
            The female users are less than or equals to male users
     */

    @Test
    public void get01() {
        // Set the Url
        spec.pathParams("first","users");
        // Set The Expected Data
        //=> Burada body() methodu ve JsonPath kullanmak istedik
        //yani datamizi Map' e donusturmek ıstememdik,bu da
        // genelde framework'umze,calsıtıgımız sirketın is kulturune ve o anki task'imize gore degisir
        //Send The Request and Get The Respons
        Response response = given().spec(spec).when().get("/{first}");
        response.jsonPath().prettyPrint();

        // Do Assertion
        response.then().assertThat().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.current",equalTo(null),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Bhudeva Deshpande II","Tanirika Kaul","Aaryan Shukla DVM"));

        // Comparing numbers of man and woman
        //Method 1 :
         List<String> genders = response.jsonPath().getList("data.gender");
        System.out.println(genders);

        int numFemale = 0;
        for (String w:genders) {

            if (w.equalsIgnoreCase("female")){
                numFemale++;
            }
        }
        assertTrue(numFemale <= genders.size() - numFemale);

        //Method 1 :
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender == 'female'}.name");
        System.out.println("femaleNames : " + femaleNames);
        List<String> maleNames = response.jsonPath().getList("data.findAll{it.gender == 'male'}.name");
        System.out.println("maleNames : " + maleNames);


    }
}
