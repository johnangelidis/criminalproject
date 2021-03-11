import java.util.ArrayList;

/**
 * Class representation of a Detective
 */
public class Detective {
    private ArrayList<Case> cases;
    
    /**
     * Parameterized constructor for Dectective class
     * @param cases ArrayList of cases Dectective has been associated with
     */
    public Detective(ArrayList<Case> cases)
    {
        this.cases = cases;
    }
}
