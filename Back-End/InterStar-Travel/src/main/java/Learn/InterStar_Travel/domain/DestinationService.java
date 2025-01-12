package Learn.InterStar_Travel.domain;

import Learn.InterStar_Travel.Models.Destination;
import Learn.InterStar_Travel.data.DestinationClientRepository;

import java.util.List;

public class DestinationService {
    private final DestinationClientRepository repository;

    public DestinationService(DestinationClientRepository repository){this.repository = repository;}

    public List<Destination> findAllDestinations(){ return  repository.findAllDestinations();}
}
