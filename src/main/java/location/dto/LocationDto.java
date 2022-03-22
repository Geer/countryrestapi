package location.dto;

import location.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class LocationDto {

    public LocationDto(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.parentId = location.getParent() != null ? location.getParent().getId() : null;
    }

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long parentId;
}
