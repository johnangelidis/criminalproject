import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

    public void addCriminal(Criminal c){
        criminals.add(c);
        CriminalWriter.saveCriminals();
    }
    public Criminal getCriminalById(UUID criminalID) {
        int criminalIndex = 0;
        try {
            for (int i = 0; i < criminals.size(); i++) {
                if(criminals.get(i).getId() == criminalID)
                    criminalIndex = i;
            }
        } catch (Exception e) {
            System.out.println("INVALID CRIMINAL ID");
        }
        return criminals.get(criminalIndex);
    }

    public void deleteCriminal(UUID criminalID){
        Criminal c = getCriminalById(criminalID);
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

    public void addCivilian(Civilian c){
        civilians.add(c);
        CivilianWriter.saveCivilians();
    }
    
    public Civilian getCivilianById(UUID civilianID) {
        int civilianIndex = 0;
        try {
            for (int i = 0; i < civilians.size(); i++) {
                if(civilians.get(i).getId() == civilianID)
                    civilianIndex = i;
            }
        } catch (Exception e) {
            System.out.println("INVALID CIVILIAN ID");
        }
        return civilians.get(civilianIndex);
    }

    public void deleteCivilian(UUID civilianID){
        Civilian c = getCivilian(civilianID);
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

    public void addOfficer(PoliceOfficer p){
        officers.add(p);
        PoliceWriter.saveOfficers();
    }

    public PoliceOfficer getOfficerById(UUID officerID) {
        int officerIndex = 0;
        try {
            for (int i = 0; i < officers.size(); i++) {
                if(officers.get(i).getId() == officerID)
                    officerIndex = i;
            }
        } catch (Exception e) {
            System.out.println("INVALID OFFICER ID");
        }
        return officers.get(officerIndex);
    }

    public void deleteOfficer(UUID officerID){
        PoliceOfficer p = getOfficerById(officerID);
        officers.remove(p);
        PoliceWriter.saveOfficers();

    }

    public ArrayList<Detective> getDetectives(){
        return detectives;
    }

    public void addDetective(Detective d){
        detectives.add(d);
        DetectiveWriter.saveDetectives();
    }

    public Detective getDetectiveById(UUID detectiveID) {
        int detectiveIndex = 0;
        try {
            for (int i = 0; i < detectives.size(); i++) {
                if(officers.get(i).getId() == detectiveID)
                   detectiveIndex = i;
            }
        } catch (Exception e) {
            System.out.println("INVALID DETECTIVE ID");
        }
        return detectives.get(detectiveIndex);
    }

    public void deleteDetective(UUID detectiveID){
        Detective d = getDetectiveById(detectiveID);
        detectives.remove(d);
        DetectiveWriter.saveDetectives();
    }

    public ArrayList<Case> getCases(){
        return cases;
    }

    public Case getCaseById(UUID caseID) {
        int caseIndex = 0;
        try {
            for (int i = 0; i < cases.size(); i++) {
                if(cases.get(i).getId() == caseID)
                    caseIndex = i;
            }
        } catch (Exception e) {
            System.out.println("INVALID CASE ID");
        }
        return cases.get(caseIndex);
    }

    public void loadCases(){
        cases = CaseLoader.loadCases();
    }
    public void addCase(Case c) {

        cases.add(c);
        CaseWriter.saveCases();
    }

    public void deleteCase(UUID id){
        Case c = getCaseById(id);
        cases.remove(c);
        CaseWriter.saveCases();
    }

    public ArrayList<Gang> getGangs(){
        return gangs;
    }

    public void loadGangs(){
        gangs = GangLoader.loadGangs();
    }

    public void addGang(Gang g){
        gangs.add(g);
        GangWriter.saveGangs();
    }

    public Gang getGangById(UUID gangID) {
        int gangIndex = 0;
        try {
            for (int i = 0; i < gangs.size(); i++) {
                if(gangs.get(i).getId() == gangID)
                   gangIndex = i;
            }
        } catch (Exception e) {
            System.out.println("INVALID GANG ID");
        }
        return gangs.get(gangIndex);
    }

    public void deleteGang(UUID gangID){
        Gang g = getGangById(gangID);
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
    public Criminal searchCriminals(String firstName, String lastName)
    {
        for (Criminal c : criminals) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }
    public Civilian searchCivilians(String firstName, String lastName){
        for (Civilian c : civilians) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }
    public PoliceOfficer searchOfficers(String firstName, String lastName){
        for (PoliceOfficer p : officers) {
            if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }
    public Detective searchDetectives(String firstName, String lastName){
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
            if(username.equals(u.getUsername())){
                return u;
            }
        }
        return null;
    }

    public boolean findUser(String username, String password){
        for(User u:users){
            if(username.equals(u.getUsername()) && password.equals(u.getPassword())){
                return true;
            }
        }
        return false;
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
