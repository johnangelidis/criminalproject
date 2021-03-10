import java.util.ArrayList;

/**
 * Class representing a police officer
 * @author Jayden Allen
 */
public class PoliceOfficer {
    private int badgeNum;
    private String policeDept;
    private ArrayList<Case> cases;

/**
 * Constructor that creates a police officer
 * @param badge number
 * @param police department
 * @param cases
 */
    public PoliceOfficer(int badgeNum, String policeDept,
    ArrayList<Case> cases){
        this.badgeNum = badgeNum;
        this.policeDept = policeDept;
        this.cases = cases;
    }
}
