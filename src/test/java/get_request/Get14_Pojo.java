package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get14_Pojo extends RestfulBaseUrl {
       /*
        Given
            https://restful-booker.herokuapp.com/booking/19
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
                                    {
                            "firstname": "Jane",
                            "lastname": "Doe",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Extra pillows please"
                        }
     */

    @Test
    public void getPojo01() {
        //Set the Url
        spec.pathParams("first","booking","second",19);
        //Set the Expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        System.out.println("bookingDatesPojo : " + bookingDatesPojo.toString());

        BookingPojo expectedData = new BookingPojo("Jane","Doe",111,true,bookingDatesPojo,"Extra pillows please");
        System.out.println("expectedData : " + expectedData.toString());

        //Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //Do Assertion
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("actualData : " + actualData);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        //1. yol
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getChechkout(),actualData.getBookingdates().getChechkout());
        //2.yol == tavsiye edilen
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getChechkout(),actualData.getBookingdates().getChechkout());
    }
}
