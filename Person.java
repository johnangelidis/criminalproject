import java.util.*;
/**
 * Class that represents a person
 */
public abstract class Person{
    protected int id;
    protected String firstName;
    protected String lastName;
    protected Calendar dateOfBirth;

    /**
     * Constructor that creates a person
     * @param id
     * @param firstName
     * @param lastName
     */
    public Person(int id, String firstName, String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    /**
     * Method that returns the first name
     * @return first name
     */
    public String getFirstName(){
        return this.firstName;
    }
    /**
     * Method that sets the first name of a person to the name given
     * @param fName (given first name)
     */
    public void setFirstName(String fName){
        firstName = fName;
    }
    /**
     * Method that returns the last name
     * @return last name
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Method that sets the last name of a person to the last name given
     * @param lName (given last name)
     */
    public void setLastname(String lName){
        lastName = lName;
    }

    /**
     * Method that returns a string representation of the date of birth
     * @return string representation of date of birth
     */
    public Calendar getDOB(){
        return dateOfBirth;
    }
    /**
     * Method that sets the date of birth given the year, month, and day
     * @param year
     * @param month
     * @param day
     */
    public void setDOB(int year, int month, int day){
        dateOfBirth.set(year,month,day);
    }

    /**
     * Abstract method that will return a string with all the attributes of a person
     */
    public abstract String toString();
}