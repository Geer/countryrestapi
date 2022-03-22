package location.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LocationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String stateNotFoundHandler(CountryNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(StateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String stateNotFoundHandler(StateNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CountyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String countyNotFoundHandler(CountyNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cityNotFoundHandler(CityNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TownNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String townNotFoundHandler(TownNotFoundException ex) {
        return ex.getMessage();
    }
}
