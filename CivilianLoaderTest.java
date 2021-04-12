/**
 * @author Jayden Allen
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CivilianLoaderTest {
    private Database db = Database.getInstance();
    public ArrayList<Civilian> civilians = db.getCivilians();

    @BeforeEach
    public void setup(){
        if (civilians == null)
            civilians = new ArrayList<Civilian>();
        civilians.clear();
        Date dob1 = new Date("August", 12, 2001);
        Address add1 = new Address(123, "main", "Columbia", "SC", 29405);
        Date dob2 = new Date("January", 1, 1992);
        Address add2 = new Address(124, "Main St.", "Columbia", "SC", 29405);
        civilians.add(new Civilian("Jayden", "Allen", dob1, add1, 1234567));
        civilians.add(new Civilian("Michael", "Scott", dob2, add2, 7654321));
    }

    @AfterEach
    public void tearDown(){
        civilians.clear();
    }

    @Test
    void testGetFirstCivilianName(){

        assertEquals("Jayden", civilians.get(0).getFirstName());
    }

    @Test
    void testGetSecondCivName(){
        assertEquals("Michael", civilians.get(1).getFirstName());
    }

    @Test
    void testGetCivilianSize(){
        assertEquals(2, civilians.size());
    }
    
}
