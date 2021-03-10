/**
 * Class that represents a tattoo
 * Written by John Angelidis
 */
public class Tattoo {
    private String location;
    private String color;
    private String design;

    /**
     * Constructor that creates a tattoo
     * @param location
     * @param color
     * @param design
     */
    public Tattoo(String location, String color, String design){
        this.location=location;
        this.color=color;
        this.design=design;
    }

    /**
     * Method that returns the tattoo of a given person
     * @return tattoo
     */
    public Tattoo getTattoo(){
        return this;
    }

    /**
     * Method that sets a new tattoo for a person
     * @param loc
     * @param col
     * @param des
     */
    public void setTattoo(String loc, String col, String des){
        this.location=loc;
        this.color=col;
        this.design=des;
    }

    /**
     * Method that returns a string with all the attributes
     * @return string description
     */
    public String toString(){
        return color + " " + design + " " + " located on " + location + ".";
    }
}
