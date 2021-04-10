/**
 * @author Coby Arambula
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GangWriterTest {
    private Database db = Database.getInstance();
    private ArrayList<Gang> gangs = db.getGangs();

    @BeforeEach
    public void setup(){
        if (gangs == null)
            gangs = new ArrayList<Gang>();
        gangs.clear();
    }

    @AfterEach
    public void tearDown(){
        gangs.clear();
    }

    @Test
    void testWritingOneGang(){
        gangs.add(new Gang("Floor Gang"));
        assertEquals("Floor Gang", gangs.get(0).getName());
    }

    @Test
    void testWritingThreeGangs(){
        gangs.add(new Gang("Floor Gang"));
        gangs.add(new Gang("Ceiling Gang"));
        gangs.add(new Gang("Chair Gang"));
        assertEquals("Chair Gang", gangs.get(2).getName());
    }

    @Test
    void testWritingEmptyGang(){
        gangs.add(new Gang(""));
        assertEquals("", gangs.get(0).getName());
    }

    @Test
    void testWritingNullGang(){
        gangs.add(new Gang(null));
        assertEquals(null, gangs.get(0).getName());
    }

}
