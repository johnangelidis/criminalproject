import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 * Class representation of Database that allows user to search and export entries
 */
public class Database {
    private ArrayList<Criminal> criminals;
    private ArrayList<Civilian> civilians;
    private ArrayList<PoliceOfficer> officers;
    private ArrayList<Detective> detectives;
    private ArrayList<Case> cases;
    private ArrayList<Gang> gangs;
    private ArrayList<User> users;

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
