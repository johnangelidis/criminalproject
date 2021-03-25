import java.util.ArrayList;
import java.util.UUID;
/**
 * Class that represents a criminal case
 * Written by John Angelidis
 */
public class Case {
    private UUID id;
    private String crime;
    private Civilian victim;
    private Criminal offender;
    private String outcome;
    private ArrayList<Civilian> witnesses;
    private ArrayList<Civilian> personsOfInterest;
    private Date dayOfCrime;
    private Date dayOfSentence;
    private Address location;
    private ArrayList<PoliceOfficer> officersInvolved;
    private Detective detective;

    /**
     * Constructor that creates a new case
     * @param id
     * @param crime
     * @param victim
     * @param offender
     * @param outcome
     * @param witnesses
     * @param personsOfInterest
     * @param dayOfCrime
     * @param dayOfSentence
     * @param location
     * @param officersInvolved
     * @param detective
     */
    public Case(String crime, Civilian victim, Criminal offender, String outcome, ArrayList<Civilian> witnesses, ArrayList<Civilian> personsOfInterest, Date dayOfCrime, Date dayOfSentence, Address location, ArrayList<PoliceOfficer> officersInvolved, Detective detective){
        this.id = UUID.randomUUID();
        this.crime = crime;
        this.victim = victim;
        this.offender = offender;
        this.outcome = outcome;
        this.witnesses = new ArrayList<Civilian>();
        this.personsOfInterest = new ArrayList<Civilian>();
        this.dayOfCrime = dayOfCrime;
        this.dayOfSentence = dayOfCrime;
        this.location = location;
        this.officersInvolved = new ArrayList<PoliceOfficer>();
        this.detective = detective;
    }

    public UUID getId() {
        return this.id;
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

    public Criminal getOffender() {
        return this.offender;
    }

    public void setOffender(Criminal offender) {
        this.offender = offender;
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

    public void setDayOfCrime(String month, int day, int year) {
        dayOfCrime = new Date(month,day,year);
    }

    public String getDayOfSentence() {
        return dayOfSentence.toString();
    }

    public void setDayOfSentence(String month, int day, int year) {
        dayOfSentence = new Date(month,day,year);
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

    public Detective getDetective() {
        return this.detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }
}
