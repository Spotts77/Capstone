package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Flight;

import java.util.List;

public interface FlightClientRepository {
    List<Flight> findFlightsByKey();
}
