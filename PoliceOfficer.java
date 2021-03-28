/**
 * Class representing a police officer
 * @author Jayden Allen
 */
public class PoliceOfficer extends Person {
    private long badgeNum;
    private String policeDept;

/**
 * Paramaterized Constructor that creates a police officer
 * @param dateOfBirth
 * @param badge number
 * @param police department
 */
    public PoliceOfficer(String firstName, String lastName, Date dateOfBirth, long badgeNum, String policeDept){
        super(firstName, lastName, dateOfBirth);
        this.badgeNum = badgeNum;
        this.policeDept = policeDept;
    }

    public long getbadgeNum() {
        return this.badgeNum;
    }
    public String getpoliceDept() {
        return this.policeDept;
    }

    public void setbadgeNum(long badgeNum) {
        this.badgeNum = badgeNum;
    }
    public void setpoliceDept(String policeDept){
        this.policeDept = policeDept;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
