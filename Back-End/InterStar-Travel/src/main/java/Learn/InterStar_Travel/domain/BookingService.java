package Learn.InterStar_Travel.domain;

import Learn.InterStar_Travel.Models.Booking;
import Learn.InterStar_Travel.Models.Flight;
import Learn.InterStar_Travel.data.BookingClientRepository;
import Learn.InterStar_Travel.data.FlightClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BookingService {
    private final BookingClientRepository repository;

    @Autowired
    FlightClientRepository flightRepository;

    public BookingService(BookingClientRepository repository){this.repository = repository;}

    public Booking findBookingById(int id){return repository.findBookingById(id);}

    public Result<Booking> createBooking(Booking booking){

        Result<Booking> result = validate(booking);
        if(!result.isSuccess()){
            return result;
        }

        if (booking.getFlightId() <= 0 || booking.getUserId() <= 0){
            result.addMessage("Id must be set for Add operation", ResultType.INVALID);
        }

        Flight flight = flightRepository.findFlightById(booking.getFlightId());
        booking.setTotal(calulateTotal(flight, booking));



        result.setPayload(repository.createBooking(booking));
        return result;
    }

    public boolean deleteBooking(int id){return repository.deleteBookingById(id);}

    private BigDecimal calulateTotal(Flight flight, Booking booking){
        BigDecimal total = flight.getPricePerTicket().multiply(BigDecimal.valueOf(booking.getTicketNumber()));
        return total;
    }

    private Result<Booking> validate(Booking booking){
        Result<Booking> result = new Result<>();
        if(booking == null){
            result.addMessage("Booking cannot be null", ResultType.INVALID);
            return result;
        }

        if(Validations.isNullOrBlank(booking.getBookingStatus())){
            result.addMessage("Booking status Required", ResultType.INVALID);
        }
        return result;
    }


}
