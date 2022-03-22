package location.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="3")
public class County extends Location {

    protected County() {

    }

    public County(String name, State parent) {
        super(name, parent);
    }

    public State getState() {
        return (State)this.getParent();
    }

    public void setState(State state) {
        this.setParent(state);
    }
}
   /* @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

   @OneToMany(mappedBy = "county",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<>();
*/
