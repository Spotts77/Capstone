package Learn.InterStar_Travel.controller;

import Learn.InterStar_Travel.Models.Flight;
import Learn.InterStar_Travel.domain.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service){this.service = service;}

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> findFlightById(@PathVariable int flightId){
        Flight flight = service.findFlightById(flightId);
        if(flight == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/search/{departure}/{destination}/{departureDate}")
    public ResponseEntity<List<Flight>> findFlightsByKey(
            @PathVariable String departure,
            @PathVariable String destination,
            @PathVariable LocalDate departureDate) {
        // Calls the service layer to find flights based on the provided keys
        List<Flight> flights = service.findFlightByKey(departure, destination, departureDate);
        if(flights.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(flights);
    }
}
