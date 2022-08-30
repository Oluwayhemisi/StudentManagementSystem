package africa.semicolon.studentmanagementsys.exceptions;

public class SmsException extends Exception {
    private int statusCode;
    public SmsException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }
}
