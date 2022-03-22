package location.controller;

import location.dto.LocationDto;
import location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {

    private final LocationRepository locationRepository;

    @GetMapping("/countries")
    public ResponseEntity<List<LocationDto>> listCountries() {

        return ResponseEntity.ok(
                this.locationRepository.findAll().stream()
                        .map(LocationDto::new)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/countries/find")
    public ResponseEntity<List<LocationDto>> findByNameContaining(@RequestParam String name)  {

        return ResponseEntity.ok(
                this.locationRepository.findByNameContainingIgnoreCase(name).stream()
                        .map(LocationDto::new)
                        .collect(Collectors.toList()));
    }


}
