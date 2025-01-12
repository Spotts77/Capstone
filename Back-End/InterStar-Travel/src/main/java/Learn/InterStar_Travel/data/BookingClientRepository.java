package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Booking;

public interface BookingClientRepository {
    Booking findBookingById(int bookingId);
    Booking createBooking(Booking booking);
    boolean deleteBookingById(int bookingId);
}
