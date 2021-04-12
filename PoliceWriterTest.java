/**
 * @author Jayden Allen
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PoliceWriterTest {
    private Database db = Database.getInstance();
    private ArrayList<PoliceOfficer> officers = db.getOfficers();

    @BeforeEach
    public void setup(){
        if(officers == null)
            officers = new ArrayList<PoliceOfficer>();
        officers.clear();
    }

    @AfterEach
    public void tearDown(){
        officers.clear();
    }

    @Test
    void testWritingOneOfficer(){
        Date dob1 = new Date("March", 12, 1998);
        officers.add(new PoliceOfficer("John", "West", dob1, 257, "Richland"));
    }

    @Test
    void testWritingThreeOfficers(){
        Date dob1 = new Date("March", 12, 1998);
        officers.add(new PoliceOfficer("John", "West", dob1, 257, "Richland"));
        Date dob2 = new Date("April", 13, 1999);
        officers.add(new PoliceOfficer("Mike", "Ferarri", dob2, 258, "Richland"));
        Date dob3 = new Date("May", 14, 2000);
        officers.add(new PoliceOfficer("Jackson", "Bar", dob3, 259, "Richland"));
    }

    @Test
    void testWritingEmptyOfficer(){
        Date dob1 = new Date("", 0, 0);
        officers.add(new PoliceOfficer("", "", dob1, 0, ""));
        assertEquals("", officers.get(0).getFirstName());

    }

    @Test
    void testWritingNullOfficer(){
        Date dob1 = new Date("", 0, 0);
        officers.add(new PoliceOfficer(null, null, dob1, 0, null));
        assertEquals(null, officers.get(0).getFirstName());
    }
    
}
