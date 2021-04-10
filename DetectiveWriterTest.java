/**
 * Tested by John Angelidis
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DetectiveWriterTest {
    private Database db = Database.getInstance();
    private ArrayList<Detective> detectives = db.getDetectives();

    @BeforeEach
    public void setup(){
        Database.getInstance().getDetectives().clear();
        DetectiveWriter.saveDetectives();
    }

    @AfterEach
    public void tearDown(){
        Database.getInstance().getDetectives().clear();
        DetectiveWriter.saveDetectives();
    }

    @Test
    void testWritingOneDetective(){
        Date dob1 = new Date("July", 4, 1994);
        detectives.add(new Detective("Mike", "Henry", dob1));
        DetectiveWriter.saveDetectives();
        assertEquals("Mike", DetectiveLoader.loadDetectives().get(0).getFirstName());
    }

    @Test
    void testWritingThreeDetectives(){
        Date dob1 = new Date("July", 4, 1994);
        detectives.add(new Detective("Mike", "Henry", dob1));
        Date dob2 = new Date("April", 4, 1994);
        detectives.add(new Detective("Nick", "Potato", dob2));
        Date dob3 = new Date("September", 4, 1994);
        detectives.add(new Detective("Steve", "Stevens", dob3));
        DetectiveWriter.saveDetectives();
        assertEquals("Steve", DetectiveLoader.loadDetectives().get(2).getFirstName());
    }

    @Test
    void testWritingEmptyDetective(){
        Date dob1 = new Date("",0,0);
        detectives.add(new Detective("", "", dob1));
        DetectiveWriter.saveDetectives();
        assertEquals("", DetectiveLoader.loadDetectives().get(0).getFirstName());
    }

    @Test
    void testWritingNullDetective(){
        Date dob1 = new Date("",0,0);
        detectives.add(new Detective(null, null, dob1));
        DetectiveWriter.saveDetectives();
        assertEquals(null, DetectiveLoader.loadDetectives().get(0).getFirstName());
    }




}
