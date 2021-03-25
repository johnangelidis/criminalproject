/**
 * Class representing an Address
 * @author Jayden Allen
 */
public class Address {
    private int number;
    private String street; 
    private String city; 
    private String state;
    private int zip;
    

    /** 
     * Constructor that creates an address
     * @param number
     * @param street
     * @param city
     * @param state
     * @param zip
     */
    public Address(int number, String street, String city, String state, int zip) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getNumber(){
        return this.number;
    }
    public String getStreet(){
        return this.street;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public int getZip(){
        return this.zip;
    }

    public void setNumber(int number){
        this.number = number;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setZip(int zip){
        this.zip = zip;
    }

    public String toString(){
        return number + " " + street + ", " + city + ", " + state + zip;   
    }

    public static Address splitAddress(String address){
        String[] splitAddress = address.split("/");

        int number = Integer.parseInt(splitAddress[0]);
        String street = splitAddress[1];
        String city = splitAddress[2];
        String state = splitAddress[3];
        int zip = Integer.parseInt(splitAddress[4]);

        Address newAddress = new Address(number, street, city, state, zip);
        return newAddress;
    }
}
