import java.util.ArrayList;

/**
 * Class representation of Database that allows user to search and export entries
 */
public class Database {
    private ArrayList<Criminal> criminals;
    private ArrayList<Civilian> civilians;
    private ArrayList<PoliceOfficer> officers;
    private ArrayList<Detectives> detectives;
    private ArrayList<Case> cases;
    private ArrayList<Gang> gangs;
    private ArrayList<User> users;

    /**
     * Allows user to search entries based on people associated with those entries
     * @param id ID number associated with person entry
     * @param firstName First name of person
     * @param lastName Last name of person
     * @return instance of the Person class
     */
    public Person SearchPerson(int id, String firstName, String lastName)
    {

    }

    /**
     * Allows user to search entries based on associated gangs
     * @param name name of the gang
     * @return instance of the Gang class
     */
    public Gang SearchGang(String name)
    {

    }

    /**
     * Allows users to search entries based on associated cases via case ID
     * @param id ID number associated with case
     * @return instance of the Case class
     */
    public Case SearchCase(int id)
    {

    }

    /**
     * Allows user to export a Person entry
     * @param id Id number associated with person entry
     */
    public void exportPerson(int id)
    {

    }

    /**
     * Allows user to export a Gang entry
     * @param name String representation of the Gang's name
     */
    public void exportGang(String name)
    {

    }

    /**
     * Allows user to export a Case entry
     * @param id ID number associated with the Case
     */
    public void exportCase(int id)
    {

    }

    /**
     * @return String representation of what method was used by the user
     */
    public String toString()
    {

    }
}
