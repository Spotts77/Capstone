package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Flight;

public interface FlightClientRepository {
    Flight findFlightByKey(Flight flight);
}
