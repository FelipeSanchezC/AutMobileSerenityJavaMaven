package exceptions.commons;

public class CommonsExeptions extends AssertionError {

    public CommonsExeptions(String mensaje){
        super(mensaje);
    }

    public CommonsExeptions(String mensaje, Throwable cause){
        super(mensaje, cause);
    }
}
