/*
 * Written by Chase Allison
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CriminalLoaderTest {
	private Database db = Database.getInstance();
    private ArrayList<Criminal> criminals = db.getCriminals();


    @BeforeEach
    public void setup(){
        if(criminals==null){
            criminals = new ArrayList<Criminal>();
        }
        criminals.clear();

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
        
    }

    @AfterEach
    public void tearDown(){
        criminals.clear();
    }

    @Test
    public void testGetCriminalsSize(){
        assertEquals(1, criminals.size());
    }

    @Test
    public void testGetCriminalsSizeZero(){
        tearDown();
        assertEquals(0, criminals.size());
    }

    @Test
    public void testGetCrimFirstName(){
        assertEquals("fName", criminals.get(0).getFirstName());
    }

    @Test
    public void testGetCrimLastName(){
        assertEquals("lName", criminals.get(0).getLastName());
    }
    
    @Test
    public void testGetCrimGender(){
        assertEquals("gender", criminals.get(0).getGender());
    }
    @Test
    public void testGetCrimRace(){
        assertEquals("race", criminals.get(0).getRace());
    }
    @Test
    public void testGetCrimWeight(){
        assertEquals(1.0, criminals.get(0).getWeight());
    }
    @Test
    public void testGetCrimHeight(){
        assertEquals(1.0, criminals.get(0).getHeight());
    }
    @Test
    public void testGetCrimEyeColor(){
        assertEquals("brown", criminals.get(0).getEyeColor());
    }
    @Test
    public void testGetCrimHairColor(){
        assertEquals("brown", criminals.get(0).getHairColor());
    }
    @Test
    public void testGetCrimHairLength(){
        assertEquals("short", criminals.get(0).getHairLength());
    }
    @Test
    public void testGetCrimFacialHair(){
        assertEquals("none", criminals.get(0).getFacialHair());
    }
    @Test
    public void testGetCrimTattoo(){
        assertEquals("none", criminals.get(0).getTattoo());
    }
    @Test
    public void testGetCrimStatus(){
        assertEquals("free", criminals.get(0).getStatus());
    }
    @Test
    public void testGetCrimGang(){
        assertEquals("Gang gang", criminals.get(0).getGang());
    }
    @Test
    public void testGetCrimAge(){
        assertEquals(12, criminals.get(0).getAge());
    }
    @Test
    public void testGetCrimConviction(){
        assertEquals("guilty", criminals.get(0).getConviction());
    }
    
}
