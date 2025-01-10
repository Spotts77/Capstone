package Learn.InterStar_Travel.data;

import Learn.InterStar_Travel.Models.User;

public interface UserClientRepository {
    User findUserByEmail(String email);
    User createUser(User user);
}
