package Learn.InterStar_Travel.controller;

import Learn.InterStar_Travel.Models.User;
import Learn.InterStar_Travel.domain.Result;
import Learn.InterStar_Travel.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service){this.service = service;}

    @PostMapping("/make/users")
    public ResponseEntity<Object> add(@RequestBody User user){
        Result<User> result = service.add(user);
        if(result.isSuccess()){
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @GetMapping("/email/{userEmail}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email){
        User user = service.findUserByEmail(email);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable int userId){
        User user = service.findUserById(userId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }
}
