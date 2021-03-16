import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
/**
 * Class representation of Database that allows user to search and export entries
 */
public class Database {
    private static Database db = null;
    private static ArrayList<Criminal> criminals;
    private static ArrayList<Civilian> civilians;
    private static ArrayList<PoliceOfficer> officers;
    private static ArrayList<Detective> detectives;
    private static ArrayList<Case> cases;
    private static ArrayList<Gang> gangs;
    private static ArrayList<User> users;

    private Database(){
        //criminals = CriminalLoader.loadCriminals();
        civilians = CivilianLoader.loadCivilians();
        //officers = OfficerLoader.loadOfficers();
        //detectives = DetectiveLoader.loadDetectives();
        cases = CaseLoader.loadCases();
        //gangs = GangLoader.loadGangs();
        //users = UserLoader.loadUsers();
    }

    public static Database getInstance(){
        if(db == null){
            db = new Database();
        }
        return db;
    }

    public ArrayList<Criminal> getCriminals(){
        return criminals;
    }
    public ArrayList<Civilian> getCivilians(){
        return civilians;
    }

    public void addCivilian(int id, String firstName, String lastName, Calendar dateOfBirth, Address address, int number, boolean isVictim, boolean isWitness, boolean isPersonOfInterest, ArrayList<Case> cases){
        civilians.add(new Civilian(id, firstName, lastName, address, number, isVictim, isWitness, isPersonOfInterest, cases));
        CivilianWriter.saveCivilians();
    }
    
    public ArrayList<PoliceOfficer> getOfficers(){
        return officers;
    }
    public ArrayList<Detective> getDetectives(){
        return detectives;
    }
    public ArrayList<Case> getCases(){
        return cases;
    }

    public void addCase(int id, String crime, Civilian victim, Criminal offender, String outcome, ArrayList<Civilian> witnesses, ArrayList<Civilian> personsOfInterest, Calendar dayOfCrime, Calendar dayOfSentence, Address location, ArrayList<PoliceOfficer> officersInvolved, Detective detective){
        cases.add(new Case(id, crime, victim, offender, outcome, witnesses, personsOfInterest, dayOfCrime, dayOfSentence, location, officersInvolved, detective);
        CaseWriter.saveCases();
    }
    public ArrayList<Gang> getGangs(){
        return gangs;
    }

    public void addGang(int id, String name, ArrayList<Criminal> members, ArrayList<Case> crimes){
        gangs.add(new Gang(id, name, members, crimes);
        GangWriter.saveGangs();
    }
    public ArrayList<User> getUsers(){
        return users;
    }


    /**
     * Allows user to search entries based on people associated with those entries
     * @param firstName First name of person
     * @param lastName Last name of person
     * @return instance of the Person class
     */
    public Person searchPerson(String firstName, String lastName)
    {
        for (Criminal c : criminals) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        for (Civilian c : civilians) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        for (PoliceOfficer p : officers) {
            if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
                return p;
            }
        }
        for (Detective d : detectives) {
            if (d.getFirstName().equals(firstName) && d.getLastName().equals(lastName)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Allows user to search entries based on associated gangs
     * @param name name of the gang
     * @return instance of the Gang class
     */
    public Gang searchGang(String name)
    {
        for(Gang g:gangs){
            if(g.getName().equals(name)){
                return g;
            }
        }
        return null;
    }

    /**
     * Allows users to search entries based on associated cases via case ID
     * @param id ID number associated with case
     * @return instance of the Case class
     */
    public Case searchCase(int id)
    {
        for(Case c:cases){
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    public User searchUser(String username){
        for(User u:users){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    /**
     * Allows user to export a Person entry
     * @param p Person that we want to write to file
     */
    public void exportPerson(Person p){
        try{
            FileOutputStream output = new FileOutputStream("c:\\Users\\J\\Desktop");
            ObjectOutputStream objectOut = new ObjectOutputStream(output);
            objectOut.writeObject(p);
            System.out.println("Person successfully written to file!");
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Allows user to export a Gang entry
     * @param g Gang that we want to write to file
     */
    public void exportGang(Gang g)
    {
        try{
            FileOutputStream output = new FileOutputStream("c:\\Users\\J\\Desktop");
            ObjectOutputStream objectOut = new ObjectOutputStream(output);
            objectOut.writeObject(g);
            System.out.println("Gang successfully written to file!");
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Allows user to export a Case entry
     * @param c Case that we want to write to file
     */
    public void exportCase(Case c)
    {
        try{
            FileOutputStream output = new FileOutputStream("c:\\Users\\J\\Desktop");
            ObjectOutputStream objectOut = new ObjectOutputStream(output);
            objectOut.writeObject(c);
            System.out.println("Case successfully written to file!");
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
