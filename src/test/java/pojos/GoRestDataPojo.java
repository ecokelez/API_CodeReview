package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestDataPojo {

    private Integer id;
    private String name;
    private String email;
    private String female;
    private String status ;

    public GoRestDataPojo() {
    }

    public GoRestDataPojo(Integer id, String name, String email, String female, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.female = female;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFemale() {
        return female;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoRestDataPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", female='" + female + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
