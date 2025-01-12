package Learn.InterStar_Travel.data.Mappers;

import Learn.InterStar_Travel.Models.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet resultSet, int i) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(resultSet.getInt("booking_id"));
        booking.setBookingDate(resultSet.getDate("booking_date").toLocalDate());
        booking.setBookingStatus(resultSet.getString("booking_status"));
        booking.setTicketNumber(resultSet.getInt("ticket_num"));
        booking.setTotal(resultSet.getBigDecimal("total"));
        booking.setFlightId(resultSet.getInt("flight_id"));
        booking.setUserId(resultSet.getInt("passenger_id"));
        return booking;
    }
}
