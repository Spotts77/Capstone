package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Booking;

public interface BookingClientRepository {
    Booking findBookingById(Booking booking);
    Booking createBooking(Booking booking);
    boolean updateBooking(Booking booking);
    boolean deleteBookingById(int bookingId);
}
