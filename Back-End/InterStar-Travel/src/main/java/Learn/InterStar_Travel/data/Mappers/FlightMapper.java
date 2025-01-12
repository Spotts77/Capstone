package Learn.InterStar_Travel.data.Mappers;

import Learn.InterStar_Travel.Models.Flight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightMapper implements RowMapper<Flight> {
    public Flight mapRow(ResultSet resultSet, int i) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightId(resultSet.getInt("flight_id"));
        flight.setFlightName(resultSet.getString("flight_name"));
        flight.setDepartureTime(resultSet.getTime("departure_time").toLocalTime());
        flight.setDepartureDate(resultSet.getDate("departure_date").toLocalDate());
        flight.setArrivalTime(resultSet.getTime("arrival_time").toLocalTime());
        flight.setPricePerTicket(resultSet.getBigDecimal("price_per_ticket"));
        flight.setDeparturePortId(resultSet.getInt("departure_port_id"));
        flight.setArrivalPortId(resultSet.getInt("arrival_port_id"));
        flight.setSpacecraftId(resultSet.getInt("spacecraft_id"));

        return flight;
    }

}
