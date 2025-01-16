package learn.InterStar_Travel.Domain;

import Learn.InterStar_Travel.Models.Booking;
import Learn.InterStar_Travel.data.BookingClientRepository;
import Learn.InterStar_Travel.data.BookingJdbcClientRepository;
import Learn.InterStar_Travel.domain.BookingService;
import Learn.InterStar_Travel.domain.Result;
import Learn.InterStar_Travel.domain.ResultType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookingServiceTest {

    @Autowired
    BookingService service;

    @MockBean
    BookingClientRepository repository;

    @Test
    void shouldCreateBooking(){
        BigDecimal total = new BigDecimal(600.00);
        Booking booking = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 2, 1);
        Booking mockOut = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 2, 1);

        when(repository.createBooking(booking)).thenReturn(mockOut);
        Result<Booking> actual = service.createBooking(booking);
        assertEquals(ResultType.SUCCESS, actual.getType());
        assertEquals(mockOut, actual.getPayload());
    }

    @Test
    void shouldNotCreateBooking(){
        BigDecimal total = new BigDecimal(600.00);
        Booking booking = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 0, 1);
        Booking mockOut = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 0, 1);

        when(repository.createBooking(booking)).thenReturn(mockOut);
        Result<Booking> actual = (service.createBooking(booking));
        assertEquals(ResultType.INVALID, actual.getType());

        booking = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 2, 0);
        mockOut = new Booking(LocalDate.of(2025, 02, 07), "Problem with Card", 1, total, 2, 0);

        assertEquals(ResultType.INVALID, actual.getType());
    }


}
