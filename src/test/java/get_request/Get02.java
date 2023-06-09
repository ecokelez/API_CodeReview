package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get02 extends ReqresBaseUrl {
     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void get01() {
        //Set the Url
     spec.pathParams("first","users","second",23);
        //Set The Expected Data
        //Send The Request and Get The Response
       Response response =  given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
       //Do Assertion
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        //assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());
        assertEquals(2,response.asString().replaceAll("\\s","").length());
        // space icindekileri hiclik ile degisitr ve lenght'ini al ve zaten sadece Curly braces kalacak 2 adet
        // ve 2 ' ye esitle , assertion yap



    }
}
