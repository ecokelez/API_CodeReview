package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get07 extends RestfulBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/1922
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
    {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
}
     */

    @Test
    public void get01() {
        //i)  Set the URL,
        spec.pathParams("first","booking","second",1922);
        //ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //iii)Send the Request and Get the Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //iv) Do Assertion (dogrulama yapmak)
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Alen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));

        //=> 2.Method=> Usage JsonPath
        JsonPath jsonPath = response.jsonPath();

        assertEquals(200,response.getStatusCode());
        assertEquals("application/json",response.contentType());
        assertEquals("Josh",jsonPath.getString("firstname"));
        assertEquals("Allen",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertEquals(true,jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("super bowls",jsonPath.getString("additionalneeds"));

        //=> Method 3 => Usage Soft Assertion

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200,"wrong StatusCode");
        softAssert.assertEquals(response.getContentType(),"application/json","wrong ContentType");
        softAssert.assertEquals("firstname","Josh","wrong firstname");
        softAssert.assertEquals("lastname","Allen","wrong lastname");
        softAssert.assertEquals("totalprice",111,"wrong totalprice");
        softAssert.assertEquals("depositpaid",true,"wrong depositpaid");
        softAssert.assertEquals("bookingdates.checkin","2018-01-01","wrong bookingdates.checkin");
        softAssert.assertEquals("bookingdates.checkout","2019-01-01","wrong bookingdates.checkout");
        softAssert.assertEquals("additionalneeds","super bowls","wrong additionalneeds");


    }
}
