package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Booking;
import Learn.InterStar_Travel.data.Mappers.BookingMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJdbcClientRepository implements BookingClientRepository{

    private final JdbcClient jdbcClient;

    public BookingJdbcClientRepository(JdbcClient jdbcClient){this.jdbcClient = jdbcClient;}

    @Override
    public Booking findBookingById(int bookingId){
        final String sql = """
                select
                booking_id,
                booking_date,
                booking_status,
                ticket_num,
                total,
                passenger_id,
                flight_id
                from booking
                where booking_id = ?;
                """;
        return jdbcClient.sql(sql)
                .param(bookingId)
                .query(new BookingMapper())
                .optional().orElse(null);
    }

    @Override
    public Booking createBooking(Booking booking){
        final String sql = """
                insert into booking(booking_date, booking_status, ticket_num, total, passenger_id, flight_id)
                values
                (:bookingDate, :bookingStatus, :ticketNum, :total, :passengerId, :flightId)
                """;
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param("bookingDate", booking.getBookingDate())
                .param("bookingStatus", booking.getBookingStatus())
                .param("ticketNum", booking.getTicketNumber())
                .param("total", booking.getTotal())
                .param("passengerId", booking.getUserId())
                .param("flightId", booking.getFlightId())
                .update(keyHolder, "booking_id");


        int bookingId = keyHolder.getKey().intValue();

        booking.setBookingId(bookingId);

        return booking;

    }

    @Override
    public boolean deleteBookingById(int bookingId){
        return jdbcClient.sql("delete from booking where booking_id = ?")
                .param(bookingId)
                .update() > 0;
    }
}
