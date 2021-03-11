/**
 * A class which will represent Civilians in the system
 * @author challison404
 *
 */
import java.util.ArrayList;

public class Civilian {
	private Address address;
	private int phone;
	private boolean isVictim;
	private boolean isWitness;
	private boolean isPersonOfInterest;
	private ArrayList<Case> cases;
	/**
	 * A constructor which will create a Civilian
	 * @param anAddress Civilians Address
	 * @param aPhone Civilians Phone
	 * @param bisVictim Is the Civilian a Victim of a crime
	 * @param bisWitness Is the Civilian a Witness of a crime
	 * @param bisPersonOfInterest Is the Civilian a POI?
	 */
	public Civilian(Address anAddress, int aPhone,
					boolean bisVictim, boolean bisWitness,
					boolean bisPersonOfInterest
					ArrayList<Case> aCases) {
		cases = new ArrayList<Case>();
		this.address = anAddress;
		this.phone = aPhone;
		this.isVictim = bisVictim;
		this.isWitness = bisWitness;
		this.isPersonOfInterest = bisPersonOfInterest;
		this.cases = aCases;
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
	 * Method to return victim status of Civilian
	 * @return Are they a victim?
	 */
	public boolean getisVictim() {
		return this.isVictim;
	}
	/**
	 * Method to return witness status of Civilian
	 * @return Are they a witness?
	 */
	public boolean getisWitNess() {
		return this.isWitness;
	}
	/**
	 * Method to return if Civilian is a person of interest
	 * @return Are they a person of interest?
	 */
	public boolean getisPersonOfInterest() {
		return this.isPersonOfInterest;
	}
	/**
	 * Method to return cases involving the Civilian
	 * @return The present cases the Civilian is involved in
	 */
	public ArrayList<Case> getCases() {
		return this.cases;
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
	/**
	 * Method to declare victim status
	 * @param isVictim Whether or not they are a victim
	 */
	public void setisVictim(boolean isVictim) {
		this.isVictim = isVictim;
	}
	/**
	 * Method to declare witness status
	 * @param isWitness Whether or not they are a witness
	 */
	public void setisWitness(boolean isWitness) {
		this.isWitness = isWitness;
	}
	/**
	 * Method to declare POI status
	 * @param isPersonOfInterest Whether or not they are a POI
	 */
	public void setisPersonOfInterest(boolean isPersonOfInterest) {
		this.isPersonOfInterest = isPersonOfInterest;
	}
	/**
	 * Method to set current cases to new Arraylist
	 * @param cases the arraylist of new cases to be applied
	 */
	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}
}
