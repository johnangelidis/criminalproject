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
    public PoliceOfficer(String firstName, String lastName, String dateOfBirth, int badgeNum, String policeDept){
        super(firstName, lastName);
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
    public void addCase(Case c){
        cases.add(c);
    }

    @Override
    public String toString() {
        return "Officer: "+firstName+" "+lastName+
        "\n Department: "+policeDept+
        "\n Badge Number: "+badgeNum;
    }
}
