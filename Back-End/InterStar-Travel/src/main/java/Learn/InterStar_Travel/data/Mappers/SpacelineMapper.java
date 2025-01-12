package Learn.InterStar_Travel.data.Mappers;

import Learn.InterStar_Travel.Models.Spaceline;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpacelineMapper implements RowMapper<Spaceline> {

    @Override
    public Spaceline mapRow(ResultSet resultSet, int i) throws SQLException {
        Spaceline spaceline = new Spaceline();
        spaceline.setSpacelineId(resultSet.getInt("spaceline_id"));
        spaceline.setSpacelineName(resultSet.getString("spaceline_name"));
        spaceline.setContactNumber(resultSet.getString("contact_number"));
        spaceline.setFoundedYear(resultSet.getString("founded_year"));
        spaceline.setFleetSize(resultSet.getInt("fleet_size"));
        return spaceline;
    }

}
