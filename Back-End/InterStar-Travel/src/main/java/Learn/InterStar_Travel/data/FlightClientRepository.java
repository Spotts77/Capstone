package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightClientRepository {
    List<Flight> findFlightsByKey(String dpSpaceportName, String apSpaceportName, LocalDate departureDate);

    Flight findFlightById(int id);
}
