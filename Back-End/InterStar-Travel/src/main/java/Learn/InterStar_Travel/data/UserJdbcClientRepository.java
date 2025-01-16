package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.User;
import Learn.InterStar_Travel.data.Mappers.UserMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcClientRepository implements UserClientRepository {
private final JdbcClient jdbcClient;

    public UserJdbcClientRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public User findUserByEmail(String email){
        final String sql = """
                select
                passenger_id,
                first_name,
                last_name,
                email,
                phone_number
                from passenger
                where email = ?;
                """;
        return jdbcClient.sql(sql)
                .param(email)
                .query(new UserMapper())
                .optional().orElse(null);
    }

    @Override
    public User findUserById(int id){
        final String sql = """
                select
                passenger_id,
                first_name,
                last_name,
                email,
                phone_number
                from passenger
                where passenger_id = ?;
                """;
        return jdbcClient.sql(sql)
                .param(id)
                .query(new UserMapper())
                .optional().orElse(null);
    }

    @Override
    public User createUser(User user){
        final String sql = """
                INSERT INTO passenger (first_name, last_name, email, phone_number)
                values
                (:first_name, :last_name, :email, :phone_number);
                """;
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param("first_name", user.getFirstName())
                .param("last_name", user.getLastName())
                .param("email", user.getEmail())
                .param("phone_number", user.getPhoneNumber())
                .update(keyHolder, "passenger_id");

        int userId = keyHolder.getKey().intValue();
        user.setUserId(userId);
        return user;

    }
}
