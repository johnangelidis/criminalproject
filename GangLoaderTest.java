/**
 * @author Coby Arambula
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GangLoaderTest {
    private Database db = Database.getInstance();
    public ArrayList<Gang> gangs = db.getGangs();

    @BeforeEach
    public void setup(){
        if (gangs == null)
            gangs = new ArrayList<Gang>();
        gangs.clear();
        gangs.add(new Gang("Floor gang"));
        gangs.add(new Gang("Ceiling gang"));
    }

    @AfterEach
    public void tearDown(){
        gangs.clear();
    }

    @Test
    void testGetGangSize(){
        assertEquals(2, gangs.size());
    }

    @Test
    void testGetGangName(){
        assertEquals("Floor gang", gangs.get(0).getName());
    }

    @Test
    void testGetGangSizeZero(){
        tearDown();
        assertEquals(0, gangs.size());
    }
}
