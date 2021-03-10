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
        this.cases = new ArrayList<Case>();
    }

    public int getbadgeNum() {
        return this.badgeNum;
    }
    public String getpoliceDept() {
        return this.policeDept;
    }
    public ArrayList<Case> getCases() {
        return this.cases;
    }

    public void setbadgeNum(int badgeNum) {
        this.badgeNum = badgeNum;
    }
    public void setpoliceDept(String policeDept){
        this.policeDept = policeDept;
    }
    public void setCases(ArrayList<Case> cases){
        this.cases = cases;
    }
}
