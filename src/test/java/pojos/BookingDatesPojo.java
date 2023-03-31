package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    //1- Tum key'ler icin private variable'lar olusturuyoruz
    private  String checkin;
    private String chechkout;


    // Tum variable'larla  parametreli ve parametresiz Constructor olus.
    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String chechkout) {
        this.checkin = checkin;
        this.chechkout = chechkout;
    }

    //3- Public Getter ve Setter olus.
    public String getCheckin() {
        return checkin;
    }

    public String getChechkout() {
        return chechkout;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setChechkout(String chechkout) {
        this.chechkout = chechkout;
    }

    // 4- toString methodu olus.
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", chechkout='" + chechkout + '\'' +
                '}';
    }
}
