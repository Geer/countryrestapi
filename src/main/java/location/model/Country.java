package location.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="1")
public class Country extends Location {

    protected Country() {
    }

    public Country(String name) {
        super(name);
    }
}
