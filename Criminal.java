import java.util.ArrayList;

/**
 * Class representation of a Criminal
 */
public class Criminal extends Person{
    private static double weight;
    private static double height;
    private String hairColor;
    private String eyeColor;
    private Tattoo tattoos;
    private boolean hasScars;
    private String status;
    private Gang gang;
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
    public Criminal(int id, String firstName, String lastName, double weight, double height, String hairColor,
                    String eyeColor, Tattoo tattoos, boolean hasScars,
                    String status, Gang gang, boolean isSerialCriminal) {
        super(id, firstName, lastName);
        setWeight(weight);
        setHeight(height);
        setHairColor(hairColor);
        setEyeColor(eyeColor);
        setTattoos(tattoos);
        setHasScars(hasScars);
        setStatus(status);
        setGang(gang);
        setSerialCriminal(isSerialCriminal);
    }

    /**
     * Mutator for weight instance variable
     * @param weight double representation of criminal's weight
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * Mutator for height instance variable 
     * @param height double representation of criminal's height
     */
    public void setHeight(double height)
    {
        this.height = height; 
    }

    /**
     * Mutator for hairColor instance variable 
     * @param hairColor String representation of criminal's hair color
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Mutator for eyeColor instance variable 
     * @param eyeColor String representation of criminal's eye color
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Mutator for tattoos instance variable
     * @param tattoos Instance of the Tattoos class that represents the criminal's tattoos
     */
    public void setTattoos(Tattoo tattoos) {
        this.tattoos = tattoos;
    }

    /**
     * Mutator for hasScars instance variable
     * @param hasScars boolean value that indicates if criminal has scars
     */
    public void setHasScars(boolean hasScars) {
        this.hasScars = hasScars;
    }

    /**
     * Mutator for status instance variable
     * @param status String representation of the criminal's incarceration status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Mutator for gang instance variable
     * @param gang Instance of the Gang class that represents the criminals associated gang(s)
     */
    public void setGang(Gang gang) {
        this.gang = gang;
    }

    /**
     * Mutator for the isSerialCriminal instance variable 
     * @param isSerialCriminal boolean value that represents if the criminal is a serial criminal
     */
    public void setSerialCriminal(boolean isSerialCriminal) {
        this.isSerialCriminal = isSerialCriminal;
    }
    
    /**
     * @return String representation of criminal's first and last name
     */
    public String toString() {
        return firstName + " " + lastName + " is a criminal.";
    }
}
