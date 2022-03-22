package location.Exception;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(Long id) {
        super("Could not find country " + id);
    }
}
