import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.UUID;
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
        criminals = CriminalLoader.loadCriminals();
        civilians = CivilianLoader.loadCivilians();
        officers = PoliceLoader.loadOfficers();
        detectives = DetectiveLoader.loadDetectives();

        users = UserLoader.loadUsers();
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

    public void addCriminal(String firstName, String lastName, double weight, double height, String hairColor, String eyeColor, Tattoo tattoos, boolean hasScars, String status, boolean isSerialCriminal){
        criminals.add(new Criminal(firstName, lastName, weight, height, hairColor, eyeColor, tattoos, hasScars, status, isSerialCriminal));
        CriminalWriter.saveCriminals();
    }

    public void deleteCriminal(Criminal c){
        criminals.remove(c);
        CriminalWriter.saveCriminals();
    }

    public ArrayList<Civilian> getCivilians(){
        return civilians;
    }

    public Civilian getCivilian(UUID id){
        for(Civilian c:civilians){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public void addCivilian(String firstName, String lastName, Date dateOfBirth, Address address, int number, boolean isVictim, boolean isWitness, boolean isPersonOfInterest){
        civilians.add(new Civilian(firstName, lastName, address, number, isVictim, isWitness, isPersonOfInterest));
        CivilianWriter.saveCivilians();
    }
    
    public void deleteCivilian(Civilian c){
        civilians.remove(c);
        CivilianWriter.saveCivilians();
    }

    public ArrayList<PoliceOfficer> getOfficers(){
        return officers;
    }

    public PoliceOfficer getOfficer(UUID id){
        for(PoliceOfficer p:officers){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void addOfficer(String firstName, String lastName, Date dateOfBirth, int badgeNum, String policeDept){
        officers.add(new PoliceOfficer(firstName, lastName, dateOfBirth, badgeNum, policeDept));
        PoliceWriter.saveOfficers();
    }

    public void deleteOfficer(PoliceOfficer p){
        officers.remove(p);
        PoliceWriter.saveOfficers();

    }

    public ArrayList<Detective> getDetectives(){
        return detectives;
    }

    public void addDetective(String firstName, String lastName){
        detectives.add(new Detective(firstName, lastName));
        DetectiveWriter.saveDetectives();
    }

    public void deleteDetective(Detective d){
        detectives.remove(d);
        DetectiveWriter.saveDetectives();
    }

    public ArrayList<Case> getCases(){
        return cases;
    }

    public void loadCases(){
        cases = CaseLoader.loadCases();
    }
    public void addCase(String crime, Civilian victim, Criminal offender, String outcome, ArrayList<Civilian> witnesses, ArrayList<Civilian> personsOfInterest, Calendar dayOfCrime, Calendar dayOfSentence, Address location, ArrayList<PoliceOfficer> officersInvolved, Detective detective){
        cases.add(new Case(crime, victim, offender, outcome, witnesses, personsOfInterest, dayOfCrime, dayOfSentence, location, officersInvolved, detective));
        CaseWriter.saveCases();
    }

    public void deleteCase(Case c){
        cases.remove(c);
        CaseWriter.saveCases();
    }

    public ArrayList<Gang> getGangs(){
        return gangs;
    }

    public void loadGangs(){
        gangs = GangLoader.loadGangs();
    }

    public void addGang(String name){
        gangs.add(new Gang(name));
        GangWriter.saveGangs();
    }

    public void deleteGang(Gang g){
        gangs.remove(g);
        GangWriter.saveGangs();
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(String username, String password){
        users.add(new User(username, password));
        UserWriter.saveUsers();
    }

    public void deleteUser(User u){
        users.remove(u);
        UserWriter.saveUsers();
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

    public static Gang getGangById(UUID id){
        for(Gang g:gangs){
            if(id.equals(g.getId())){
                return g;
            }
        }
        return null;
    }

    /**
     * Allows users to search entries based on associated cases via case ID
     * @param crime A string description of the crime
     * @param offender The offender who committed the crime
     * @return instance of the Case class
     */
    public Case searchCase(String crime, Criminal offender)
    {
        for(Case c:cases){
            if(c.getCrime().equals(crime) && c.getOffender().equals(offender)){
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
