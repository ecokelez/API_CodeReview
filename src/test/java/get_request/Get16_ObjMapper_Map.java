package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get16_ObjMapper_Map extends JsonplaceholderBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */


    @Test
    public void get01ObjMapper() {
        spec.pathParams("first","todos","second",198);

        String expectedDataInString = new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);
        //Map<String,Object> expectedData = ObjectMapperUtils.convertJsonToJava(expectedDataInString, HashMap.class);
        HashMap expectedData = ObjectMapperUtils.convertJsonToJava(expectedDataInString, HashMap.class);
        System.out.println("expectedData : " + expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

       HashMap actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData : " + actualData);

        assertEquals(200,response.getStatusCode());
       assertEquals(expectedData.get("userId"),actualData.get("userId"));
       assertEquals(expectedData.get("title"),actualData.get("title"));
       assertEquals(expectedData.get("completed"),actualData.get("completed"));



    }
}
