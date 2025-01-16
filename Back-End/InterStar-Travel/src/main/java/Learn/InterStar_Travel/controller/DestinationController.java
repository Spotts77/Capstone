package Learn.InterStar_Travel.controller;

import Learn.InterStar_Travel.Models.Destination;
import Learn.InterStar_Travel.domain.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/destination")
public class DestinationController {

    private final DestinationService service;

    public DestinationController(DestinationService service){this.service = service;}

    @GetMapping
    public ResponseEntity<List<Destination>> findAllDestinations() {
        List<Destination> destinations = service.findAllDestinations();

        if (destinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(destinations);
    }
}
