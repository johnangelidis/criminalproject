import java.util.ArrayList;

/**
 * Class representing a police officer
 * @author Jayden Allen
 */
public class PoliceOfficer extends Person {
    private int badgeNum;
    private String policeDept;
    private ArrayList<Case> cases;

/**
 * Paramaterized Constructor that creates a police officer
 * @param dateOfBirth
 * @param badge number
 * @param police department
 * @param cases
 */
    public PoliceOfficer(int id, String firstName, String lastName, String dateOfBirth, int badgeNum, String policeDept,
    ArrayList<Case> cases){
        super(id, firstName, lastName);
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
    /**
     * Method that returns an array of case ID's for each police officer. 
     * @return
     */
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

    @Override
    public String toString() {
        return "Officer: "+firstName+" "+lastName
        "\n Department: "+policeDept
        "\n Badge Number: "+badgeNum;
    }
}
