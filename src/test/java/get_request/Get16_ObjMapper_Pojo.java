package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get16_ObjMapper_Pojo extends JsonplaceholderBaseUrl {
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
    public void get01ObjMapperPojo() {
        spec.pathParams("first","todos","second",198);
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);
        System.out.println("expectedData : " + expectedData);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData : " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());


    }
}
