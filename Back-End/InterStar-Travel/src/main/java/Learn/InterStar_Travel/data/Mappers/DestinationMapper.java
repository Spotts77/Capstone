package Learn.InterStar_Travel.data.Mappers;

import Learn.InterStar_Travel.Models.Destination;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinationMapper implements RowMapper<Destination> {

    @Override
    public Destination mapRow(ResultSet resultSet, int i) throws SQLException {
        Destination destination = new Destination();
        destination.setDestinationId(resultSet.getInt("destination_id"));
        destination.setDestinationName(resultSet.getString("destination_name"));
        destination.setDestinationDescription(resultSet.getString("destination_description"));
        destination.setImageUrl(resultSet.getString("image_url"));
        return destination;
    }
}
