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
    private String suspectDescription;
    private String caseDescription;
    private ArrayList<Civilian> witnesses;
    private ArrayList<Civilian> personsOfInterest;
    private Date dayOfCrime;
    private String time;
    private Address location;
    private ArrayList<PoliceOfficer> officersInvolved;
    private Detective detective;
    private String victimStatement;
    private String witnessStatement;
    private ArrayList<String> evidence
   

    public Case(String crime, Civilian victim, Criminal offender, String suspectDescription, String caseDescription, ArrayList<Civilian> witnesses, ArrayList<Civilian> personsOfInterest, Date dayOfCrime, String time, Address location, ArrayList<PoliceOfficer> officersInvolved, Detective detective, String victimStatement, String witnessStatement, ArrayList<String> evidence){
        this.id = UUID.randomUUID();
        this.crime = crime;
        this.victim = victim;
        this.offender = offender;
        this.suspectDescription = suspectDescription;
        this.caseDescription = caseDescription;
        this.witnesses = new ArrayList<Civilian>();
        this.personsOfInterest = new ArrayList<Civilian>();
        this.dayOfCrime = dayOfCrime;
        this.time = time;
        this.location = location;
        this.officersInvolved = new ArrayList<PoliceOfficer>();
        this.detective = detective;
        this.victimStatement = victimStatement;
        this.witnessStatement = witnessStatement;
        this.evidence = new ArrayList<String>();
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

    public String getSuspectDescription() {
        return this.suspectDescription;
    }

    public void setSuspectDescription(String suspectDescription) {
        this.suspectDescription = suspectDescription;
    }

    public String getCaseDescription() {
        return this.caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public Criminal getOffender() {
        return this.offender;
    }

    public void setOffender(Criminal offender) {
        this.offender = offender;
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

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
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
    public String getVictimStatement() {
        return this.victimStatement;
    }

    public void setVictimStatement(String victimStatement) {
        this.victimStatement = victimStatement;
    }

    public String getWitnessStatement() {
        return this.witnessStatement;
    }

    public void setWitnessStatement(String witnessStatement) {
        this.witnessStatement = witnessStatement;
    }
}
