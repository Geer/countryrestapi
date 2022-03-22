package location.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="2")
public class State extends Location {

    protected State() {

    }

    public State(String name, Country country) {
        super(name, country);
    }

    public Country getCountry() {
        return (Country) this.getParent();
    }

    public void setCountry(Country country) {
        this.setParent(country);
    }
}
