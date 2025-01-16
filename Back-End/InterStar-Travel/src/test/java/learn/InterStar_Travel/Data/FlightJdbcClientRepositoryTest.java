package learn.InterStar_Travel.Data;


import Learn.InterStar_Travel.Models.Flight;
import Learn.InterStar_Travel.data.FlightJdbcClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FlightJdbcClientRepositoryTest {
    private final int NEXT_ID = 3;

    @Autowired
    FlightJdbcClientRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setUp(){knownGoodState.set();}

    @Test
    void shouldFindFlightByKey(){
        String dpDeparturePortName = "VST";
        String apArrivalPortName = "MBA";
        LocalDate departureDate = LocalDate.of(2025, 2, 10);

        List<Flight> allFlights = repository.findFlightsByKey(dpDeparturePortName, apArrivalPortName, departureDate);
        int sizeActual = 1;

        assertEquals(allFlights.size(), sizeActual);
    }

    @Test
    void shouldFindFlightById(){
        int expected = 1;
        Flight actual = repository.findFlightById(expected);
        assertEquals(expected, actual.getFlightId());
    }
}
