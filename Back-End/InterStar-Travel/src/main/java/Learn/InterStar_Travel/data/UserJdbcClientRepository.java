package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.User;
import org.springframework.jdbc.core.simple.JdbcClient;
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
                first_name,
                last_name,
                email,
                phone_number
                from passenger
                where email = ?;
                """;
        return jdbcClient.sql(sql)
                .param(email)
    }

    @Override
    User createUser(User user){

    }
}
