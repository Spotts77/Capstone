package Learn.InterStar_Travel.domain;

import Learn.InterStar_Travel.Models.Destination;
import Learn.InterStar_Travel.data.DestinationClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DestinationService {
    private final DestinationClientRepository repository;

    public DestinationService(DestinationClientRepository repository){this.repository = repository;}

    public List<Destination> findAllDestinations(){ return  repository.findAllDestinations();}
}
