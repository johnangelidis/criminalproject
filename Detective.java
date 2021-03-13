import java.util.ArrayList;

/**
 * Class representation of a Detective
 */
public class Detective extends Person{
    private ArrayList<Case> cases;
    
    /**
     * Parameterized constructor for Dectective class
     * @param cases ArrayList of cases Dectective has been associated with
     */
    public Detective(int id, String firstName, String lastName, ArrayList<Case> cases)
    {
        super(id, firstName, lastName);
        this.cases = cases;
    }

    /**
     * Method that prints the id of every case the detective has worked on
     */
    public void getCases(){
        for(Case c:cases){
            System.out.print(c.getId() + " ");
        }
    }
    /**
     * Method that returns a string with the detective's first and last name
     * @return a string with the detective's first and last name
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " is a detective";
    }
}
