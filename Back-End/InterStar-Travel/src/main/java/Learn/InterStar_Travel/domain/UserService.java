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

    public User findUserById(int id){return repository.findUserById(id);}

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



        result.setPayload(repository.createUser(user));
        return result;
    }

    private Result<User> validate(User user){
        Result<User> result = new Result<>();
        if(user == null){
            result.addMessage("User cannot be null", ResultType.INVALID);
            return result;
        }

        if(Validations.isNullOrBlank(user.getFirstName())){
            result.addMessage("User first name required", ResultType.INVALID);
        }

        if(!validateNulls(user, result).isSuccess()){
            return result;
        }
        return result;
    }

    public Result<User> validateNulls(User user, Result<User> result){
        if (user.getEmail().isBlank() || user.getLastName().isBlank() || user.getPhoneNumber().isBlank()){
            result.addMessage("User information cannot be empty", ResultType.INVALID);
        }
        return result;
    }
}
