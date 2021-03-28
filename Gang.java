/**
 * A class to represent the Gangs in the system
 * @author challison404
 *
 */
import java.util.ArrayList;
import java.util.UUID;

public class Gang {
	private UUID id;
	private String name;
	private ArrayList<Criminal> members;
	/**
	 * A constructor to create new gangs
	 * @param name The name of the gang
	 * @param members Who is affiliated with the gang
	 * @param crimes What crimes the gang has commited
	 */
	public Gang(String name) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.members = new ArrayList<Criminal>();
	}
	
	public UUID getId() {
		return this.id;
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
	/*
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

	public void addMember(Criminal c){
		members.add(c);
	}

	public String toString(){
		return this.id.toString();
	}
	
}
