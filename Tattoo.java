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
     * Method that sets the location of a tattoo to the one given
     * @param loc
     */
    public void setLocation(String loc){
        this.location=loc;
    }
    /**
     * Method that sets the color of a tattoo to the one given
     * @param col
     */
    public void setColor(String col){
        this.color=col;
    }
    /**
     * Method that sets the design of a tattoo to the one given
     * @param des
     */
    public void setDesign(String des){
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
