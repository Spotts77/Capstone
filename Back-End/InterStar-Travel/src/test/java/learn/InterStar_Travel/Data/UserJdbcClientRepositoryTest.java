package learn.InterStar_Travel.Data;

import Learn.InterStar_Travel.Models.User;
import Learn.InterStar_Travel.data.UserJdbcClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserJdbcClientRepositoryTest {

    private final int NEXT_ID = 3;

    @Autowired
    UserJdbcClientRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setUp(){knownGoodState.set();}

    @Test
    void shouldFindUserByEmail(){
        User expected = new User(1, "John", "Doe", "john.doe@example.com", "123-456-7890");
        User actual = repository.findUserByEmail("john.doe@example.com");

        assertEquals(expected.getUserId(), actual.getUserId());
    }

    @Test
    void shouldCreateUser(){
        User expected = new User("Mary", "Beth", "M.Beth@example.com", "123-456-7890");
        repository.createUser(expected);

        User actual = repository.findUserByEmail("M.Beth@example.com");
        assertEquals(expected.getUserId(), actual.getUserId());
        assertEquals(actual.getUserId(), NEXT_ID);
    }
}
