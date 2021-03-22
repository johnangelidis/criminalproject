/**
 * Class representation of a Criminal
 */
public class Criminal extends Person{
    private double weight;
    private double height;
    private String hairColor;
    private String eyeColor;
    private Tattoo tattoos;
    private boolean hasScars;
    private String status;
    private boolean isSerialCriminal;

    /**
     * Parameterized constructor for Criminal class
     * @param weight double representation of criminal's weight
     * @param height double representation of criminal's height
     * @param hairColor String representation of criminal's hair color
     * @param eyeColor String representation of criminal's eye color
     * @param tattoos Instance of Tattoos class that represent criminal's tattoos
     * @param hasScars Boolean value that indicates if criminal has scars or not
     * @param status String representation of criminal's incarceration status
     * @param gang Instance of Gang class that represents the criminal's gang association
     * @param isSerialCriminal Boolean value that indicates if criminal is a serial criminal or not
     */
    public Criminal(String firstName, String lastName, double weight, double height, String hairColor,
                    String eyeColor, Tattoo tattoos, boolean hasScars,
                    String status, boolean isSerialCriminal) {
        super(firstName, lastName);
        setWeight(weight);
        setHeight(height);
        setHairColor(hairColor);
        setEyeColor(eyeColor);
        setTattoos(tattoos);
        setHasScars(hasScars);
        setStatus(status);
        setIsSerialCriminal(isSerialCriminal);
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

    public String getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Tattoo getTattoos() {
        return this.tattoos;
    }

    public void setTattoos(Tattoo tattoos) {
        this.tattoos = tattoos;
    }

    public boolean isHasScars() {
        return this.hasScars;
    }

    public void setHasScars(boolean hasScars) {
        this.hasScars = hasScars;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsSerialCriminal() {
        return this.isSerialCriminal;
    }

    public void setIsSerialCriminal(boolean isSerialCriminal) {
        this.isSerialCriminal = isSerialCriminal;
    }

    /**
     * @return String representation of criminal's first and last name
     */
    public String toString() {
        return firstName + " " + lastName + " is a criminal.";
    }
}
