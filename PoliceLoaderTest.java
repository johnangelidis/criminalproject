/**
 * @author Jayden Allen
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PoliceLoaderTest {
    private Database db = Database.getInstance();
    public ArrayList<PoliceOfficer> officers = db.getOfficers();

    @BeforeEach
    public void setup(){
        if(officers == null)
            officers = new ArrayList<PoliceOfficer>();
        officers.clear();
        Date dob1 = new Date("April", 11, 1996);
        Date dob2 = new Date("June", 9, 1999);
        officers.add(new PoliceOfficer("Jerry", "East", dob1, 234, "Richland"));
        officers.add(new PoliceOfficer("Jack", "Smith", dob2, 235, "Richland"));

    }

    @AfterEach
    public void tearDown(){
        officers.clear();
    }

    @Test
    void testGetOfficerSize(){
        assertEquals(2, officers.size());
    }

    @Test
    void testGetSecondOfficerBadgeNum(){
        assertEquals(235, officers.get(1).getbadgeNum());
    }

    @Test
    void testGetOfficerSizeZero(){
        tearDown();
        assertEquals(0, officers.size());
    }
    
}
