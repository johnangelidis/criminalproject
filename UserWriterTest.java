/**
 * @author Coby Arambula
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserWriterTest {
    private Database db = Database.getInstance();
    private ArrayList<User> users = db.getUsers();

    @BeforeEach
    public void setup(){
        if (users == null)
            users = new ArrayList<User>();
        users.clear();
    }

    @AfterEach
    public void tearDown(){
        users.clear();
    }

    @Test
    void testWritingOneUser(){
        users.add(new User("username1", "password1"));
        assertEquals("username1", users.get(0).getUsername());
        assertEquals("password1", users.get(0).getPassword());
    }

    @Test
    void testWritingThreeUsers(){
        users.add(new User("username1", "password1"));
        users.add(new User("username2", "password2"));
        users.add(new User("username3", "password3"));
        assertEquals("username3", users.get(2).getUsername());
        assertEquals("password3", users.get(2).getPassword());
    }

    @Test
    void testWritingEmptyGang(){
        users.add(new User("", ""));
        assertEquals("", users.get(0).getUsername());
        assertEquals("", users.get(0).getPassword());
    }

    @Test
    void testWritingNullGang(){
        users.add(new User(null, null));
        assertEquals(null, users.get(0).getUsername());
        assertEquals(null, users.get(0).getPassword());
    }
}
