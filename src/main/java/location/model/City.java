package location.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="4")
public class City extends Location {

    protected City() {
    }

    public City(String name, County parent) {
        super(name, parent);
    }

    public County getCounty() {
        return (County) this.getParent();
    }

    public void setCounty(County county) {
        this.setParent(county);
    }
}
