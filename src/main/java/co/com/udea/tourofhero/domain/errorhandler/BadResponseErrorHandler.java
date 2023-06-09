package co.com.udea.tourofhero.domain.errorhandler;


import org.springframework.http.HttpStatus;

public class BadResponseErrorHandler extends RuntimeException{

    private final String code;
    private final HttpStatus httpStatus;

    public BadResponseErrorHandler (String message, String code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
