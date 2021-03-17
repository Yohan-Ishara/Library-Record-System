package lk.ijse.dep.web.institute.exception;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-04
 **/
public class HttpResponseException extends RuntimeException{

    private int statusCode;

    public HttpResponseException(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.setStatusCode(statusCode);
    }

    public int getStatusCode(){return statusCode;}

    public void setStatusCode(int statusCode){this.statusCode = statusCode;}
}
