package learn.InterStar_Travel.Data;

import Learn.InterStar_Travel.Models.Destination;
import Learn.InterStar_Travel.data.DestinationJdbcClientRepository;
import Learn.InterStar_Travel.data.UserJdbcClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DestinationJdbcClientRepositoryTest {
    @Autowired
    DestinationJdbcClientRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setUp(){knownGoodState.set();}

    @Test
    void shouldFindAllDestinations(){
        int expected = 2;
        List<Destination> actual = repository.findAllDestinations();
        assertEquals(expected, actual.size());
    }
}
