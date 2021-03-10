/**
 * Class representing an Address
 */
public class Address {
    private int number;
    private String street; 
    private String city; 
    private String state;
    private int zip;
    private int number2;

    /** 
     * Constructor that creates an address
     * @param number
     * @param street
     * @param city
     * @param state
     * @param zip
     */
    public Address(int number, String street, 
    String city, String state, int zip) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

   /**
    *  Method that returns the address of a give person
    @return address
    */
    public Address getAddress(){
        return this.getAddress();
    }
}
