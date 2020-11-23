public class MyArrayDataException extends Exception {

    public MyArrayDataException(){
    }
    public MyArrayDataException (String message){
        super(message);
    }

    public MyArrayDataException (String message, Throwable cause){
        super(message, cause);
    }

}
