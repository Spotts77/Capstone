package Learn.InterStar_Travel.domain;

import Learn.InterStar_Travel.Models.Booking;
import Learn.InterStar_Travel.data.BookingClientRepository;

public class BookingService {
    private final BookingClientRepository repository;

    public BookingService(BookingClientRepository repository){this.repository = repository;}

    public Booking findBookingById(int id){return repository.findBookingById(id);}


}
