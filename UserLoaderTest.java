/**
 * @author Coby Arambula
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserLoaderTest {
    private Database db = Database.getInstance();
    public ArrayList<User> users = db.getUsers();

    @BeforeEach
    public void setup(){
        if (users == null)
            users = new ArrayList<User>();
        users.clear();
        users.add(new User("username1", "password1"));
        users.add(new User("username2", "password2"));
    }

    @AfterEach
    public void tearDown(){
        users.clear();
    }

    @Test
    void testGetUsersSize(){
        assertEquals(2, users.size());
    }

    @Test
    void testGetUserNameAndPassword(){
        assertEquals("username1", users.get(0).getUsername());
        assertEquals("password2", users.get(1).getPassword());
    }

    @Test
    void testGetUsersSizeZero(){
        tearDown();
        assertEquals(0, users.size());
    }
}

