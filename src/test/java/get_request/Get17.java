package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get17  extends RestfulBaseUrl {
     /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                  {
                    "firstname": "John",
                    "lastname": "Smith",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                        },
                    "additionalneeds": "Breakfast"
                }

     */

    //==>ObjeMapper ile Pojo classdan yapalim :

    @Test
    public void get01() {
        //Set the Url
        spec.pathParams("first","booking","second",22);
        //Set the Expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo( "2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData : " + expectedData);
        //Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);
        System.out.println("actualData : " + actualData);

        //=>Hard Assertion
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getChechkout());
        assertEquals(bookingDatesPojo.getChechkout(),actualData.getBookingdates().getChechkout());
        //Soft Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"Wrong firstanme");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Wrong lastname");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"Wrong Totalprice");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"Wrong Depositpaid");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),bookingDatesPojo.getCheckin(),"Wrong Checkin");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),bookingDatesPojo.getChechkout(),"Wrong Chechkout");
        softAssert.assertAll();

    }
}
