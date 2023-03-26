package api_notes;

public class API_Notes01 {
    /*
    API testi, beklenen işlevselliği, güvenliği, performansı ve güvenilirliği karşılayıp karşılamadığını
     doğrulamak için bir uygulama programı arayüzünü (API) analiz eden bir tür yazılım testidir
     ---------------
     API Test Adımları
    •Test için hangi ‘Endpoint'ler kullanılabilir?
    •Beklenen ‘Status Code‘ hangisi?
    •Beklenen ‘Response Body’ doğru mu?
    -----------------
    Endpoint
    API’ların istek gönderdiği ve kaynağın yaşadığı noktaya endpoint denir.
    Endpoint = URL yada URI
    -------------------------
    Swagger Nedir?
    Swagger is a framework for describing your API by using a common language that is easy to read and understand
    by developers and testers, even they have weak source code knowledge.
    Swagger, API’larınızın yapısını tanımlamanıza olanak tanıyan bir framework’tür.
    Bunu bir ev için bir plan olarak düşünebilirsiniz.
    İstediğiniz yapı malzemelerini kullanabilirsiniz, ancak planın parametrelerinin dışına çıkamazsınız.
    Nerede Swagger Kullandınız?
    API dökümantasyon için SWAGGER kullandım.
    SWAGGER bana API Endpoint bilgilerini verir ve bunların nasıl kullanılacağı hakkında beni bilgilendirir
    ---------------
    Postman Nedir?
    Postman , API testi için kullanılan bir uygulamadır. Daha sonra doğrulanması
    gereken farklı yanıt türlerini elde ettiğimiz grafiksel bir kullanıcı arabirimi kullanarak HTTP isteklerini
    test eden birHTTP istemcisidir.
    Manuel API testi için kullanılır
    -----------------
    Status Code
    En Sık Karşılaşılan Durum Kodları
    •200 Durum Kodu (Başarılı)
    •301 Durum Kodu (Kalıcı Yönlendirme)
    •302 Durum Kodu (Geçici Yönlendirme)
    •403 Durum Kodu (Erişim İzni Sorunu)
    •404 Durum Kodu (Bulunamadı)
    •410 Durum Kodu (Kalıcı Olarak Bulunmuyor)
    •500 Durum Kodu (Sunucu Hatası)
    •503 Durum Kodu (Sunucu Kullanılamıyor
    -----------------------------------------
         Serialization
     "Java objesinin Json datasına çevrilmesi.
     De-Serialization
     " Json datasının Java objesine çevrilmesi.
     ------------------------------
     De-Serialization
     response .body( )
     response . jsonPath()
     response.as( ) HashMap.class
     response.as( ) Pojo.class
     ObjectMapper().readValue( ) String data , HashMap.class
     ObjectMapper().readValue( )
     ----------------------------------
     Payload
    "Api’a göderilecek olan veri.
    Payload Oluşturma (Map)
    ----------------------------
    Pojo Class
    " Plain Old Java Object
    ------------------------------
    Payload Oluşturma (Pojo Class)
    ------------------------------
    @JsonIgnoreProperties (ignoreUnknown = true)
    Bu annotation ile Json datayı Pojo classa çevirirken Pojo classta aynı seviyedeki karşılığı olmayan Json veri
    işleme alınmaz.
    Veriler farklı levelde ise bu annotation çalışmaz.
    -----------------------




     */
}
