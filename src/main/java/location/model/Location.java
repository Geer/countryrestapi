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
        return this.getParent() == null ?
                this.getName() :
                String.format("%s, %s", this.getName(), this.getParent().getPath());
    }
}
