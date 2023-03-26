package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Get05 extends RestfulBaseUrl {
    /*
        Given
           https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "John" and lastname is "Smith"

     */


    @Test
    public void get01() {
        //i)  Set the URL,
        spec.pathParam("first","booking").queryParams("firstname","John","lastname","Smith");
        //ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //iii)Send the Request and Get the Response ( Talep gondermek icin kod yazimi)
       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();
        //iv) Do Assertion (dogrulama yapmak)
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));
    }
}
