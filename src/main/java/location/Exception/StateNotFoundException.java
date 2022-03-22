package location.Exception;

public class StateNotFoundException extends RuntimeException {

    public StateNotFoundException(Long id) {
        super("Could not find state " + id);
    }

}
