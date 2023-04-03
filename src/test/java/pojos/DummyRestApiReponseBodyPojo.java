package pojos;

public class DummyRestApiReponseBodyPojo {

    private String status;
    private DummyRestApiDataPojo data;
    private String message;

    public DummyRestApiReponseBodyPojo() {
    }

    public DummyRestApiReponseBodyPojo(String status, DummyRestApiDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiDataPojo getData() {
        return data;
    }

    public void setData(DummyRestApiDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiReponseBodyPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
