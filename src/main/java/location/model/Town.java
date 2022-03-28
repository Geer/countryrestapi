package location.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="5")
public class Town extends Location {

    protected Town() {
    }

    public Town(String name, City parent) {
        super(name, parent);
    }

    public City getCity() {
        return (City) this.getParent();
    }

    public void setCity(City city) {
        this.setParent(city);
    }

    public String getPath() {
        return this.getParent().getName() + ", "
                + this.getParent().getName() + ", "
                + this.getParent().getParent().getName() + ", "
                + this.getParent().getParent().getParent().getName();
    }

}