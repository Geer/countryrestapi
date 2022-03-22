package location.Exception;

public class CountyNotFoundException extends RuntimeException {

    public CountyNotFoundException(Long id) {
        super("Could not find county " + id);
    }
}
