package learn.InterStar_Travel.Domain;

import Learn.InterStar_Travel.Models.User;
import Learn.InterStar_Travel.data.UserClientRepository;
import Learn.InterStar_Travel.domain.Result;
import Learn.InterStar_Travel.domain.ResultType;
import Learn.InterStar_Travel.domain.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {

    @Autowired
    UserService service;

    @MockBean
    UserClientRepository repository;

    @Test
    void shouldCreateUser(){
        User actual = new User("Mary", "Beth", "M.Beth@example.com", "123-456-7890");
        User mockOut = new User("Mary", "Beth", "M.Beth@example.com", "123-456-7890");

        when(repository.createUser(actual)).thenReturn(mockOut);
        Result<User> result = service.add(actual);
        assertEquals(ResultType.SUCCESS, result.getType());
    }

    @Test
    void shouldNotCreateUser(){
        User actual = new User("Mary", "", "M.Beth@example.com", "123-456-7890");
        User mockOut = new User("Mary", "", "M.Beth@example.com", "123-456-7890");

        when(repository.createUser(actual)).thenReturn(mockOut);
        Result<User> result = service.add(actual);
        assertEquals(ResultType.INVALID, result.getType());

        actual = new User("Mary", "Beth", "", "123-456-7890");
        mockOut = new User("Mary", "Beth", "", "123-456-7890");

        result = service.add(actual);
        assertEquals(ResultType.INVALID, result.getType());

        actual = new User("Mary", "Beth", "M.Beth@example.com", "");
        mockOut = new User("Mary", "Beth", "M.Beth@example.com", "");
                result = service.add(actual);
        assertEquals(ResultType.INVALID, result.getType());

    }

    @Test
    void shouldReturnExistingUser(){
        User actual = new User(1, "John", "Doe", "john.doe@example.com", "123-456-7890");
        User mockOut = new User(1, "John", "Doe", "john.doe@example.com", "123-456-7890");

        when(repository.createUser(actual)).thenReturn(mockOut);
        Result<User> result = service.add(actual);
        assertEquals(ResultType.SUCCESS, result.getType());
    }
}
