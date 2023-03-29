package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.*;

public class Get09 extends JsonplaceholderBaseUrl {
    /*
  Given
        https://jsonplaceholder.typicode.com/todos
When
    I send GET Request to the URL == > URL'e Get Request gonderin
Then
    1)Status code is 200 == > Status kodu 200 olmali
     //Print all pantone_values
    2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
      Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
    3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
      Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
    4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
      Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
      basliginin "delectus aut autem" icerdigini dogrulayin
     */


    @Test
    public void get01() {
        spec.pathParam("first","todos");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //Do Assertion
        //1)Status code is 200
        assertEquals(200,response.getStatusCode());
        //2)Print all ids greater than 190 on the console
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.getList("findAll{it.id>190}.id");
        System.out.println("Ids that greater than 190 : " + ids);
        //Assert that there are 10 ids greater than 190
        assertEquals("10 ids could not verify that the id was greater than 190 :",10,ids.size());
        //3)Print all userIds whose ids are less than 5 on the console
        List<Integer> userIds = jsonPath.getList("findAll{it.userId<5}.userId");
        System.out.println("Size of UserIds whose ids are less than 5 :" + jsonPath.getList("findAll{it.userId<5}.userId").size());
        System.out.println("UserIds whose ids are less than 5 : " + userIds);
        //Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals("UserIds couldn't match whose ids are less than 5 ",80,userIds.size());
        //4)Print all titles whose ids are less than 5
        List<String> titles = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("Titles that ids less than 5 :" + titles);
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue("Titles that ids less than 5 don't contain delectus aut autem ",titles.contains("delectus aut autem"));
        assertTrue(titles.stream().anyMatch(t->t.equals("delectus aut autem")));




    }
}
