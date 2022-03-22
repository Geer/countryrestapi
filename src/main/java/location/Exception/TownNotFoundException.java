package location.Exception;

public class TownNotFoundException extends RuntimeException {

    public TownNotFoundException(Long id) {
        super("Could not find town " + id);
    }
}
