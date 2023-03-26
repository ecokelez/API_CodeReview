package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
     /*
    1) Postman, manuel API testleri icin kullandik,
    2) Otomasyon testleri icin de Rest Assured Library kullancagiz.
    3) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz;
        a) Gereksimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da, karsimizdaki
            kisiler hakim olmayabilir ama Gherkin ile yazilan testleri anlamak ta zorluk çekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;

            - Given : On kosullar,
            - When  : Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete() )
            - Then  : Istek yaptiktan (request gonderdikten sonra) dogrulama
            - And   : Coklu islemlerde kullanacagiz

        c) Test Kodlarimizi Yazmaya Baslayacagiz

            i)  Set the URL,
            ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
            iii) Type code to send request ( Talep gondermek icin kod yazimi)
            iv) Do Assertion (dogrulama yapmak)


            => Test Case yazdık ve Url erismek icin Swagger dokuman ulasmak gerekir
           Swagger dokumnan. ise bana hangi EdnPoint'i- hangi Url'i ne is icin kullanmam gerek. soyleyecek,
           hangi body ile kullanmam gerek. soyleyecek
           ==> Swagger, REST API'lerini tasarlamanıza, oluşturmanıza, belgelemenize ve  kullanmamıza
            yardımcı olabilecek; OpenAPI Spesifikasyonu etrafında oluşturulmuş açık kaynaklı bir araçtır.
           ● Swagger’ın önemli bir amacı RestApi ler için bir arayüz sağlamaktır. Bu, insanların
           kaynak koda erişmeden RestApi lerin özelliklerini görmesine, incelemesine ve
           anlamasına olanak sağlar

     */

      /*
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void get01() {
        //  i)  Set the URL
            String url = "   https://reqres.in/api/users/3";
        //  ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //===> Bizden post, put ya da patch istenmedigi icin bu case de kullanmayacagiz.
        //  iii) Send the request and Get the Response( Talep gondermek icin kod yazimi)
         Response response = given().when().get(url);
         response.prettyPrint();
        //  v) Do Assertion (dogrulama yapmak)
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

    }
}
