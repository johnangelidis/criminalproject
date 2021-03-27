/**
 * A class which will represent Civilians in the system
 * @author challison404
 *
 */
public class Civilian extends Person{
	private Address address;
	private int phone;

	public Civilian(String firstName, String lastName, Date dateOfBirth, Address anAddress, int aPhone) {
		super(firstName, lastName, dateOfBirth);
		this.address = anAddress;
		this.phone = aPhone;
	}
	/**
	 * Method to return Address of Civilian
	 * @return their current street address
	 */
	public Address getAddress() {
		return this.address;
	}
	/**
	 * Method to return phone of Civilian
	 * @return their current phone number
	 */
	public int getPhone() {
		return this.phone;
	}
	/**
	 * Method to set Address of Civilian
	 * @param anAddress What the address will change to
	 */
	public void setAddress(Address anAddress) {
		this.address = anAddress;
	}
	/**
	 * Method to set Phone of Civilian
	 * @param aPhone Phone number of new phone
	 */
	public void setPhone(int aPhone) {
		this.phone = aPhone;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName + " is a civilian.";
	}
}
