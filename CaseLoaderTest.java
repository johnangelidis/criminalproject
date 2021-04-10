/**
 * Tested by John Angelidis
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaseLoaderTest {
    private Database db = Database.getInstance();
    private ArrayList<Case> cases = db.getCases();


    @BeforeEach
    public void setup(){
        if(cases==null){
            cases = new ArrayList<Case>();
        }
        cases.clear();

        Date dob1 = new Date("June", 9, 1995);
        Address addy1 = new Address(123, "Main St", "Columbia", "SC", 29202);
        Civilian victim = new Civilian("Kevin", "Dog", dob1, addy1, 803123955);
        Date dob2 = new Date("May", 10, 1990);
        Address addy2 = new Address(567, "Long St", "Columbia", "SC", 29205);
        Civilian witness = new Civilian("Niko", "Drinkwater", dob2, addy2, 803198675);
        Date dob3 = new Date("October", 18, 1987);
        Gang gang1 = new Gang("bloods");
        Criminal offender = new Criminal("James", "Coffee", dob3, "male", "white", 180.0, 5.11, "black", "black", "short", "goatee", "dragon", "on probation", gang1, 34, "DUI");
        Date dayOfCrime = new Date("April", 9, 2021);
        Address addy3 = new Address(89, "Broke St", "Columbia", "SC", 29203);
        Date dob4 = new Date("February", 10, 1990);
        Date dob5 = new Date("January", 10, 1990);
        Detective detective = new Detective("Oscar", "Suarez", dob4);
        PoliceOfficer officer = new PoliceOfficer("Sammy", "Ramirez", dob5, 213, "Cayce PD");
        cases.add(new Case("DUI", victim, offender, "White man, wore black hoodie and jeans.", "Suspect was driving under the influence and crashed into another person.", witness, witness, dayOfCrime, "2:00AM", addy3, officer, detective, "The drunk guy crashed into me and was then cursing at me.", "The guy in the black hoodie was obviously driving drunk and saw him crash into the other guy's car.", "Breathalyzer test"));
        
    }

    @AfterEach
    public void tearDown(){
        cases.clear();
    }

    @Test
    public void testGetCasesSize(){
        assertEquals(1, cases.size());
    }

    @Test
    public void testGetCasesSizeZero(){
        tearDown();
        assertEquals(0, cases.size());
    }

    @Test
    public void testGetCaseOffenderLastName(){
        assertEquals("Coffee", cases.get(0).getCriminal().getLastName());
    }

    @Test
    public void testGetCaseOfficerBadgeNum(){
        assertEquals(213, cases.get(0).getOfficer().getbadgeNum());
    }

    @Test
    public void testGetCaseVictimPhoneNumber(){
        assertEquals(803123955, cases.get(0).returnVictim().getPhone());
    }

    @Test
    public void testGetCaseEvidence(){
        assertEquals("Breathalyzer test", cases.get(0).getEvidence());
    }

    @Test 
    public void testGetCaseCriminalHairColor(){
        assertEquals("black", cases.get(0).getCriminal().getHairColor());
    }
}

