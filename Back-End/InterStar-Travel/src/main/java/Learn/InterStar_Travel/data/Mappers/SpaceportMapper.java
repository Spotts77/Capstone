package Learn.InterStar_Travel.data.Mappers;

import Learn.InterStar_Travel.Models.Spaceport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpaceportMapper implements RowMapper<Spaceport> {

    public Spaceport mapRow(ResultSet resultSet, int i) throws SQLException {
        Spaceport spaceport = new Spaceport();
        spaceport.setSpaceportId(resultSet.getInt("spaceport_id"));
        spaceport.setSpaceportName(resultSet.getString("spaceport_name"));
        spaceport.setFacilities(resultSet.getString("facilities"));
        spaceport.setContactNumber(resultSet.getString("contact_number"));
        spaceport.setYearEstablished(resultSet.getString("year_established"));
        spaceport.setDestinationId(resultSet.getInt("destination_id"));
        return spaceport;
    }
}
