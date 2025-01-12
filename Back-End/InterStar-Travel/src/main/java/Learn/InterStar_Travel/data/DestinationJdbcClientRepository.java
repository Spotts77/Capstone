package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.Destination;
import Learn.InterStar_Travel.data.Mappers.DestinationMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DestinationJdbcClientRepository implements DestinationClientRepository {
    private final JdbcClient jdbcClient;

    public DestinationJdbcClientRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<Destination> findAllDestinations(){
        final String sql = """
                select
                destination_id,
                destination_name,
                destination_description,
                image_url
                from destination;
                """;
        return jdbcClient.sql(sql)
                .query(new DestinationMapper())
                .list();
    }

}
