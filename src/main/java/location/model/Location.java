package location.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "locations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Location {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parent;

    protected Location() {
    }

    protected Location(String name) {
        this(name, null);
    }

    protected Location(String name, Location parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getPath() {
        return this instanceof Town
                ? this.getName() + ", "
                + this.getParent().getName() + ", " //city
                + this.getParent().getParent().getName() + ", " //county
                + this.getParent().getParent().getParent().getName() + ", " //state
                + this.getParent().getParent().getParent().getParent().getName()  //country
                : this instanceof City
                ? this.getName() + ", "
                + this.getParent().getName() + ", " //county
                + this.getParent().getParent().getName() + ", " //state
                + this.getParent().getParent().getParent().getName() //country
                : this instanceof County
                ? this.getName() + ", "
                + this.getParent().getName() + ", " //State
                + this.getParent().getParent().getName()//Country
                : this instanceof State
                ? this.getName() + ", "
                + this.getParent().getName() //Country
                : null;
    }
}
