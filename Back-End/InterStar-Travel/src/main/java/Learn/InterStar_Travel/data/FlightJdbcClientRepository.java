package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Flight;
import Learn.InterStar_Travel.data.Mappers.FlightMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FlightJdbcClientRepository implements FlightClientRepository{
    private final JdbcClient jdbcClient;
    public FlightJdbcClientRepository(JdbcClient jdbcClient) {this.jdbcClient = jdbcClient;}

    @Override
    public List<Flight> findFlightsByKey(String dpSpaceportName, String apSpaceportName, LocalDate departureDate){
        final String sql = """
                SELECT
                f.flight_id,
                f.departure_date,
                f.flight_name,
                f.departure_time,
                f.arrival_time,
                f.price_per_ticket,
                f.departure_port_id,
                f.arrival_port_id,
                f.spacecraft_id
                FROM flight f
                JOIN spaceport dp ON f.departure_port_id = dp.spaceport_id
                JOIN spaceport ap ON f.arrival_port_id = ap.spaceport_id
                WHERE dp.spaceport_name = ?
                AND ap.spaceport_name = ?
                AND f.departure_date = ?;
                """;
        return jdbcClient.sql(sql)
                .param(dpSpaceportName)
                .param(apSpaceportName)
                .param(departureDate)
                .query(new FlightMapper())
                .list();
    }
}
