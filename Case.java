import java.util.ArrayList;
import java.util.Calendar;
/**
 * Class that represents a criminal case
 * Written by John Angelidis
 */
public class Case {
    private int id;
    private String crime;
    private Civilian victim;
    private String outcome;
    private ArrayList<Civilian> witnesses;
    private ArrayList<Civilian> personsOfInterest;
    private Calendar dayOfCrime;
    private Calendar dayOfSentence;
    private Address location;
    private ArrayList<PoliceOfficer> officersInvolved;

    /**
     * Constructor that creates a new case
     * @param id
     * @param crime
     * @param victim
     * @param outcome
     * @param witnesses
     * @param personsOfInterest
     * @param dayOfCrime
     * @param dayOfSentence
     * @param location
     * @param officersInvolved
     */
    public Case(int id, String crime, Civilian victim, String outcome, ArrayList<Civilian> witnesses, ArrayList<Civilian> personsOfInterest, Calendar dayOfCrime, Calendar dayOfSentence, Address location, ArrayList<PoliceOfficer> officersInvolved){
        this.id = id;
        this.crime = crime;
        this.victim = victim;
        this.outcome = outcome;
        this.witnesses = new ArrayList<Civilian>();
        this.personsOfInterest = new ArrayList<Civilian>();
        this.dayOfCrime = dayOfCrime;
        this.dayOfSentence = dayOfCrime;
        this.location = location;
        this.officersInvolved = new ArrayList<PoliceOfficer>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrime() {
        return this.crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public Civilian getVictim() {
        return this.victim;
    }

    public void setVictim(Civilian victim) {
        this.victim = victim;
    }

    public String getOutcome() {
        return this.outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public ArrayList<Civilian> getWitnesses() {
        return this.witnesses;
    }

    public void setWitnesses(ArrayList<Civilian> witnesses) {
        this.witnesses = witnesses;
    }

    public ArrayList<Civilian> getPersonsOfInterest() {
        return this.personsOfInterest;
    }

    public void setPersonsOfInterest(ArrayList<Civilian> personsOfInterest) {
        this.personsOfInterest = personsOfInterest;
    }

    public String getDayOfCrime() {
        return dayOfCrime.toString();
    }

    public void setDayOfCrime(int year, int month, int day) {
        dayOfCrime.set(year,month,day);
    }

    public String getDayOfSentence() {
        return dayOfSentence.toString();
    }

    public void setDayOfSentence(int year, int month, int day) {
        dayOfSentence.set(year,month,day);
    }

    public Address getLocation() {
        return this.location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public ArrayList<PoliceOfficer> getOfficersInvolved() {
        return this.officersInvolved;
    }

    public void setOfficersInvolved(ArrayList<PoliceOfficer> officersInvolved) {
        this.officersInvolved = officersInvolved;
    }

}
