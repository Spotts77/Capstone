package Learn.InterStar_Travel.domain;

import Learn.InterStar_Travel.Models.User;
import Learn.InterStar_Travel.data.UserClientRepository;
import Learn.InterStar_Travel.data.UserJdbcClientRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;


@Service
public class UserService {
    private final UserClientRepository repository;

    public UserService(UserClientRepository repository){this.repository = repository;}

    public User findUserByEmail(String userEmail){return repository.findUserByEmail(userEmail);}

    public Result<User> add(User user) {
        Result<User> result = validate(user);
        if(!result.isSuccess()) {
            return result;
        }

        User exsiting = repository.findUserByEmail(user.getEmail());
        if(exsiting != null){
            user = exsiting;
            result.setPayload(user);
            return result;
        }

        if (user.getUserId() <= 0){
            result.addMessage("Id must be set for Add operation", ResultType.INVALID);
        }

        result.setPayload(repository.createUser(user));
        return result;
    }

    }
}
