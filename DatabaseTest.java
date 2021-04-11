/**
 * Tested by John Angelidis
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DatabaseTest {
    private Database db = Database.getInstance();
    private ArrayList<Case> cases = db.getCases();
    private ArrayList<Civilian> civilians = db.getCivilians();
    private ArrayList<Criminal> criminals = db.getCriminals();
    private ArrayList<Detective> detectives = db.getDetectives();
    private ArrayList<PoliceOfficer> officers = db.getOfficers();
    private ArrayList<Gang> gangs = db.getGangs();
    private ArrayList<User> users = db.getUsers();

    @BeforeEach
    public void setup(){
        Database.getInstance().getCivilians().clear();
        Database.getInstance().getCriminals().clear();
        Database.getInstance().getDetectives().clear();
        Database.getInstance().getOfficers().clear();
        Database.getInstance().getGangs().clear();
        Database.getInstance().getCases().clear();
        Database.getInstance().getUsers().clear();

        CivilianWriter.saveCivilians();
        CriminalWriter.saveCriminals();
        DetectiveWriter.saveDetectives();
        PoliceWriter.saveOfficers();
        GangWriter.saveGangs();
        CaseWriter.saveCases();
        UserWriter.saveUsers();
    
    }

    @AfterEach
    public void tearDown(){
        Database.getInstance().getCivilians().clear();
        Database.getInstance().getCriminals().clear();
        Database.getInstance().getDetectives().clear();
        Database.getInstance().getOfficers().clear();
        Database.getInstance().getGangs().clear();
        Database.getInstance().getCases().clear();
        Database.getInstance().getUsers().clear();

        CivilianWriter.saveCivilians();
        CriminalWriter.saveCriminals();
        DetectiveWriter.saveDetectives();
        PoliceWriter.saveOfficers();
        GangWriter.saveGangs();
        CaseWriter.saveCases();
        UserWriter.saveUsers();
    }

    @Test
    public void testAddUser(){
        db.addUser("nick", "nick123");
        assertEquals("nick", users.get(0).getUsername());
    }

    @Test
    public void testFindUser(){
        db.addUser("nick", "nick123");
        boolean isFound = db.findUser("nick", "nick123");
        assertTrue(isFound);
    }

    @Test
    public void testAddCriminal(){
        db.addCriminal(new Criminal("James", "Coffee", new Date("September", 10, 1990), "male", "white", 180.0, 5.11, "black", "black", "short", "goatee", "dragon", "on probation", new Gang("gang"), 34, "DUI"));
        assertEquals("James", criminals.get(0).getFirstName());
    }

    @Test
    public void testDeleteCriminal(){
        Criminal c = new Criminal("James", "Coffee", new Date("September", 10, 1990), "male", "white", 180.0, 5.11, "black", "black", "short", "goatee", "dragon", "on probation", new Gang("gang"), 34, "DUI");
        db.addCriminal(c);
        db.removeCriminal(c);
        assertNull(criminals);
    }

    @Test
    public void testAddOfficer(){
        db.addOfficer(new PoliceOfficer("Sammy", "Ramirez", new Date("January", 10, 1990), 213, "Cayce PD"));
        assertEquals("213", officers.get(0).getbadgeNum());
    }

    @Test
    public void testDeleteDetective(){
        Detective d = new Detective("Oscar", "Suarez", new Date("February", 10, 1990));
        db.addDetective(d);
        db.removeDetective(d);
        assertNull(detectives);
    }

    @Test
    public void testAddCase(){
        db.addCase(new Case("DUI", new Civilian("Kevin", "Dog", new Date("June", 9, 1995), new Address(123, "Main St", "Columbia", "SC", 29202), 803123955), new Criminal("James", "Coffee", new Date("October", 18, 1987), "male", "white", 180.0, 5.11, "black", "black", "short", "goatee", "dragon", "on probation", new Gang("bloods"), 34, "DUI"), "White man, wore black hoodie and jeans.", "Suspect was driving under the influence and crashed into another person.", new Civilian("Niko", "Drinkwater", new Date("May", 10, 1990), new Address(567, "Long St", "Columbia", "SC", 29205), 803198675), new Civilian("Niko", "Drinkwater", new Date("May", 10, 1990), new Address(567, "Long St", "Columbia", "SC", 29205), 803198675), new Date("April", 9, 2021), "2:00AM", new Address(89, "Broke St", "Columbia", "SC", 29203), new PoliceOfficer("Sammy", "Ramirez", new Date("January", 10, 1990), 213, "Cayce PD"), new Detective("Oscar", "Suarez", new Date("February", 10, 1990)), "The drunk guy crashed into me and was then cursing at me.", "The guy in the black hoodie was obviously driving drunk and saw him crash into the other guy's car.", "Breathalyzer test"));
        assertEquals("dragon", cases.get(0).getCrime());
    }

    @Test
    public void testDeleteGang(){
        Gang g = new Gang("gang");
        db.addGang(g);
        db.removeGang(g);
        assertNull(gangs);
    }

    @Test
    public void testAddCivilian(){
        Civilian civ = new Civilian("Kevin", "Dog", new Date("June", 9, 1995), new Address(123, "Main St", "Columbia", "SC", 29202), 803123955);
        db.addCivilian(civ);
        assertEquals("Dog", civilians.get(0).getLastName());
    }

}
