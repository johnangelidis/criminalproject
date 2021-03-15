/**
 * A class to represent the Gangs in the system
 * @author challison404
 *
 */
import java.util.ArrayList;
public class Gang {
	private int id;
	private String name;
	private ArrayList<Criminal> members;
	private ArrayList<Case> crimes;
	/**
	 * A constructor to create new gangs
	 * @param name The name of the gang
	 * @param members Who is affiliated with the gang
	 * @param crimes What crimes the gang has commited
	 */
	public Gang(int id, String name, ArrayList<Criminal> members, ArrayList<Case> crimes) {
		this.id = id;
		this.name = name;
		this.members = members;
		this.crimes = crimes;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get name of the gang
	 * @return The name of the gang
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Get gangmembers of selected gang
	 * @return the arraylist of criminals affiliated with the gang
	 */
	public ArrayList<Criminal> getMembers() {
		return this.members;
	}
	/**
	 * Get crimes gang is responsible for
	 * @return the arraylist of cases involving the gang
	 */
	public ArrayList<Case> getCrimes() {
		return this.crimes;
	}
	/**
	 * Set name of the gang
	 * @param aName the name the gang will be set to
	 */
	public void setName(String aName) {
		this.name = aName;
	}
	/**
	 * Set affiliated members of the gang
	 * @param aMembers ArrayList of Criminals to be updated containing new members of the gang
	 */
	public void setMembers(ArrayList<Criminal> aMembers) {
		this.members = aMembers;
	}
	/**
	 * Set cases the gang is responsible for
	 * @param aCrimes ArrayList of Cases to be updated containing current cases the gang is responsible for
	 */
	public void setCrimes(ArrayList<Case> aCrimes) {
		this.crimes = aCrimes;
	}
}
