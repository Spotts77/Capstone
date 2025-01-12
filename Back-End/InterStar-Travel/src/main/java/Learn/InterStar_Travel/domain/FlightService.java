package Learn.InterStar_Travel.domain;

import Learn.InterStar_Travel.Models.Flight;
import Learn.InterStar_Travel.data.FlightClientRepository;

import java.time.LocalDate;
import java.util.List;

public class FlightService {
    private final FlightClientRepository repository;

    public FlightService(FlightClientRepository repository){this.repository = repository;}

    public List<Flight> findFlightByKey(String dpSpaceportName,
                                        String apSpaceportName, LocalDate departureDate){
        return repository.findFlightsByKey(dpSpaceportName, apSpaceportName, departureDate);
    }
}
