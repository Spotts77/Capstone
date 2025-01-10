package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Destination;

public interface DestinationClientRepository {
    Destination findDestinationByName();
}
