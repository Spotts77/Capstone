package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Destination;

import java.util.List;

public interface DestinationClientRepository {
    List<Destination> findAllDestinations();
}
