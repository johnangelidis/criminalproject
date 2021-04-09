/**
 * Tested by John Angelidis
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class DetectiveLoaderTest {
    private Database db = Database.getInstance();
    private ArrayList<Detective> detectives = db.getDetectives();

    @BeforeEach
    public void setup(){
        detectives.clear();
        Date dob1 = new Date("April", 9, 1979);
        detectives.add(new Detective("Josh", "Williams", dob1));
        Date dob2 = new Date("March", 17, 1987);
        detectives.add(new Detective("Daniel", "Spade", dob2));
        DetectiveWriter.saveDetectives();
    }

    @AfterEach
    public void tearDown(){
        Database.getInstance().getDetectives().clear();
        DetectiveWriter.saveDetectives();
    }

    @Test
    void testGetDetectivesSize(){
        detectives = DetectiveLoader.loadDetectives();
        assertEquals(2, detectives.size());
    }

    @Test
    void testGetFirstDetectiveName(){
        detectives = DetectiveLoader.loadDetectives();
        assertEquals("Josh", detectives.get(0).getFirstName());
    }

    @Test
    void testGetDetectivesSizeZero(){
        tearDown();
        assertEquals(0, detectives.size());
    }
}
