/**
 * Class representing an Address
 * @author Jayden Allen
 */
public class Address {
    private String number;
    private String street; 
    private String city; 
    private String state;
    private String zip;
    

    /** 
     * Constructor that creates an address
     * @param number
     * @param street
     * @param city
     * @param state
     * @param zip
     */
    public Address(String number, String street, String city, String state, String zip) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getNumber(){
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
    public String getZip(){
        return this.zip;
    }

    public void setNumber(String number){
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
    public void setZip(String zip){
        this.zip = zip;
    }

    public String toString(){
        return number + " " + street + ", " + city + ", " + state + zip;   
    }
