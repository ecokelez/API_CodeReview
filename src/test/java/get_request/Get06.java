package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get06 extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json;charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void get01() {
        //i)  Set the URL,
        spec.pathParams("first","unknown","second",3);
        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // iii)Send the Request and Get the Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        // iv) Do Assertion (dogrulama yapmak)
        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getInt("data.id")); // 3
        System.out.println(jsonPath.getInt("data.id")+4); // 7


        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"),3,"id degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red","name degeri dogru degil");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002,"year degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932","color degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664","pantone_value degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading","url degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!","url degeri dogru degil");
        softAssert.assertAll();

    }
}
