/**
 * Class that represents a person
 */
public abstract class Person{
    protected int id;
    protected String firstName;
    protected String lastName;
    //protected Date dateOfBirth;

    /**
     * Constructor that creates a person
     * @param id
     * @param firstName
     * @param lastName
     */
    public Person(int id, String firstName, String lastName /*, Date dateOfBirth*/){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    /**
     * Method that sets the first name of a person to the name given
     * @param fName (given first name)
     */
    public void setFirstName(String fName){
        firstName = fName;
    }
    /**
     * Method that sets the last name of a person to the last name given
     * @param lName (given last name)
     */
    public void setLastname(String lName){
        lastName = lName;
    }

    //public void setDOB(Date date){}

    /**
     * Abstract method that will return a string with all the attributes of a person
     */
    public abstract String toString();
}