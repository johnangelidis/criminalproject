/*
 * Written by Chase Allison
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CriminalWriterTest {
	private Database db = Database.getInstance();
	private ArrayList<Criminal> criminals = db.getCriminals();
	
	@BeforeEach
    public void setup(){
        Database.getInstance().getCriminals().clear();
        CriminalWriter.saveCriminals();
    }

    @AfterEach
    public void tearDown(){
        Database.getInstance().getCriminals().clear();
        CriminalWriter.saveCriminals();
    }

    @Test
    void testWritingOneCriminal(){
    	String firstName = "fName";
        String lastName = "lName";
        Date dob = new Date("July", 4, 2000);
        String gender = "gender";
        String race = "race";
        double weight = 1.0;
        double height = 1.0;
        String eyeColor = "brown";
        String hairColor = "brown";
        String hairLength = "short";
        String facialHair = "none";
        String tattoo = "none";
        String status = "free";
        Gang gang = new Gang("Gang gang");
        long age = 12;
        String conviction = "guilty";
        criminals.add(new Criminal( firstName,  lastName,  dob,  gender,
        	 race,  weight,  height,  eyeColor,  hairColor,  hairLength, 
        	 facialHair,  tattoo, status, gang,age, conviction));
        assertEquals("fName", CriminalLoader.loadCriminals().get(0).getFirstName());
    }

    @Test
    void testWritingThreeCriminals(){
    	String firstName = "fName";
    	String firstName2 = "fName2";
    	String firstName3 = "fName3";
        String lastName = "lName";
        Date dob = new Date("July", 4, 2000);
        String gender = "gender";
        String race = "race";
        double weight = 1.0;
        double height = 1.0;
        String eyeColor = "brown";
        String hairColor = "brown";
        String hairLength = "short";
        String facialHair = "none";
        String tattoo = "none";
        String status = "free";
        Gang gang = new Gang("Gang gang");
        long age = 12;
        String conviction = "guilty";
        criminals.add(new Criminal( firstName,  lastName,  dob,  gender,
        	 race,  weight,  height,  eyeColor,  hairColor,  hairLength, 
        	 facialHair,  tattoo, status, gang,age, conviction));
        criminals.add(new Criminal( firstName2,  lastName,  dob,  gender,
           	 race,  weight,  height,  eyeColor,  hairColor,  hairLength, 
           	 facialHair,  tattoo, status, gang,age, conviction));
        criminals.add(new Criminal( firstName3,  lastName,  dob,  gender,
           	 race,  weight,  height,  eyeColor,  hairColor,  hairLength, 
           	 facialHair,  tattoo, status, gang,age, conviction));
        CriminalWriter.saveCriminals();
        assertEquals("fName", CriminalLoader.loadCriminals().get(0).getFirstName());
        assertEquals("fName2", CriminalLoader.loadCriminals().get(1).getFirstName());
        assertEquals("fName3", CriminalLoader.loadCriminals().get(2).getFirstName());
    }

    @Test
    void testWritingEmptyCriminal(){
    	String firstName = "";
        String lastName = "lName";
        Date dob = new Date("July", 4, 2000);
        String gender = "gender";
        String race = "race";
        double weight = 1.0;
        double height = 1.0;
        String eyeColor = "brown";
        String hairColor = "brown";
        String hairLength = "short";
        String facialHair = "none";
        String tattoo = "none";
        String status = "free";
        Gang gang = new Gang("Gang gang");
        long age = 12;
        String conviction = "guilty";
        criminals.add(new Criminal(firstName,  lastName,  dob,  gender,
        	 race,  weight,  height,  eyeColor,  hairColor,  hairLength, 
        	 facialHair,  tattoo, status, gang,age, conviction));
        CriminalWriter.saveCriminals();
        assertEquals("", DetectiveLoader.loadDetectives().get(0).getFirstName());
    }

    @Test
    void testWritingNullCriminal(){
        Date dob = new Date("", 0, 0);
        Gang gang = new Gang("");
        criminals.add(new Criminal(null,  null,  dob,  null,
        	 null,  0.0,  0.0,  null,  null,  null, 
        	 null,  null, null, gang,0, null));
        CriminalWriter.saveCriminals();
        assertEquals("", CriminalLoader.loadCriminals().get(0).getFirstName());
    }
}
