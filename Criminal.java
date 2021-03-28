/**
 * Class representation of a Criminal
 */
public class Criminal extends Person{
    private String race;
    private double weight;
    private double height;
    private String eyeColor;
    private String hairColor;
    private String hairLength;
    private String facialHair;
    private String tattoo;
    private String status;
    private Gang gang;

    public Criminal(String firstName, String lastName, Date dateOfBirth, String race, double weight, double height, String eyeColor, String hairColor, String hairLength, String facialHair, String tattoo, String status, Gang gang) {
        super(firstName, lastName, dateOfBirth);
        this.race = race;
        this.weight = weight;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairLength = hairLength;
        this.facialHair = facialHair;
        this.tattoo = tattoo;
        this.status = status;
        this.gang = gang;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairLength() {
        return this.hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public String getFacialHair() {
        return this.facialHair;
    }

    public void setFacialHair(String facialHair) {
        this.facialHair = facialHair;
    }

    public String getTattoo() {
        return this.tattoo;
    }

    public void setTattoo(String tattoo) {
        this.tattoo = tattoo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Gang getGang() {
        return this.gang;
    }

    public void setGang(Gang gang) {
        this.gang = gang;
    }



    /**
     * @return String representation of criminal's first and last name
     */
    public String toString() {
        return firstName + " " + lastName + " is a criminal.";
    }
}
