/**
 * Class representation of a Detective
 */
public class Detective extends Person{
    
    /**
     * Parameterized constructor for Dectective class
     * @param cases ArrayList of cases Dectective has been associated with
     */
    public Detective(String firstName, String lastName, Date dateOfBirth)
    {
        super(firstName, lastName, dateOfBirth);
    }
    /**
     * Method that returns a string with the detective's first and last name
     * @return a string with the detective's first and last name
     */
    @Override
    public String toString() {
        return this.id.toString();
    }
}
