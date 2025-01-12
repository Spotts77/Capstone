package learn.InterStar_Travel.Data;

import Learn.InterStar_Travel.Models.Booking;
import Learn.InterStar_Travel.data.BookingJdbcClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookingJdbcClientRepositoryTest {

    @Autowired
    BookingJdbcClientRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setUp(){knownGoodState.set();}

    @Test
    void shouldFindBookingById(){
        Booking actual = repository.findBookingById(1);
        assertEquals(1, actual.getBookingId());
    }

    @Test
    void shouldCreateBooking(){
        BigDecimal total = new BigDecimal(600.00);
        LocalDate bookingDate = LocalDate.of(2025, 02, 07);
        Booking expected = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 2, 1);
        repository.createBooking(expected);
        Booking actual = repository.findBookingById(2);
        assertEquals(expected.getBookingStatus(), actual.getBookingStatus());
    }

    @Test
    void shouldDeleteBooking(){
        boolean actual = repository.deleteBookingById(1);
        assertTrue(actual);
    }
}
