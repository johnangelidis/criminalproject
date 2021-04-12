/**
 * @author Jayden Allen
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CivilianWriterTest {
    private Database db = Database.getInstance();
    private ArrayList<Civilian> civilians = db.getCivilians();

    @BeforeEach
    public void setup(){
        if(civilians == null)
            civilians = new ArrayList<Civilian>();
        civilians.clear();
    }

    @AfterEach
    public void tearDown(){
        civilians.clear();
    }

    @Test
    void testWritingOneCivilian(){
        Date dob1 = new Date("August", 12, 2001);
        Address add1 = new Address(123, "main", "Columbia", "SC", 29405);
        civilians.add(new Civilian("Jayden", "Allen", dob1, add1, 1234567));
        assertEquals("Jayden", civilians.get(0).getFirstName());

    }

    @Test
    void testWritingThreeCivilians(){
        Date dob1 = new Date("August", 12, 2001);
        Address add1 = new Address(123, "main", "Columbia", "SC", 29405);
        Date dob2 = new Date("January", 1, 1992);
        Address add2 = new Address(124, "Main St.", "Columbia", "SC", 29405);
        Date dob3 = new Date("September", 14, 1995);
        Address add3 = new Address(125, "Main St", "city", "state", 29504);
        civilians.add(new Civilian("Jayden", "Allen", dob1, add1, 1234567));
        civilians.add(new Civilian("Michael", "Scott", dob2, add2, 7654321));
        civilians.add(new Civilian("Mary", "Scott", dob3, add3, 4567890));
        assertEquals("Mary", civilians.get(2).getFirstName());
    }

    @Test
    void testWritingEmptyCivilian(){
        Date dob1 = new Date("", 0, 0);
        Address add1 = new Address(0, "", "", "", 0);
        civilians.add(new Civilian("", "", dob1, add1, 0000000));
        assertEquals("", civilians.get(0).getFirstName());
    }

    @Test
    void testWritingNullCivilian(){
        Date dob1= new Date("", 0, 0);
        Address add1 = new Address(0, "", "", "", 0);
        civilians.add(new Civilian(null, null, dob1, add1, 0));
        assertEquals(null, civilians.get(0).getFirstName());
        

    }
    
}
