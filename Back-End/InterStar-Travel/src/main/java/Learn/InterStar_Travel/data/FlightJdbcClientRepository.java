package Learn.InterStar_Travel.data;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class FlightJdbcClientRepository{
    private final JdbcClient jdbcClient;


    public FlightJdbcClientRepository(JdbcClient jdbcClient) {this.jdbcClient = jdbcClient;}

    
}
