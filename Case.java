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
    private Civilian witness;
    private Civilian personOfInterest;
    private Date dayOfCrime;
    private String time;
    private Address location;
    private PoliceOfficer officerInvolved;
    private Detective detective;
    private String victimStatement;
    private String witnessStatement;
    private String evidence;

    public Case(String crime, Civilian victim, Criminal offender, String suspectDescription, 
                String caseDescription, Civilian witness, Civilian personOfInterest, 
                Date dayOfCrime, String time, Address location, PoliceOfficer officerInvolved, 
                Detective detective, String victimStatement, String witnessStatement, String evidence) { 
        this.id = UUID.randomUUID();
        this.crime = crime;
        this.victim = victim;
        this.offender = offender;
        this.suspectDescription = suspectDescription;
        this.caseDescription = caseDescription;
        this.witness = witness;
        this.personOfInterest = personOfInterest;
        this.dayOfCrime = dayOfCrime;
        this.time = time;
        this.location = location;
        this.officerInvolved = officerInvolved;
        this.detective = detective;
        this.victimStatement = victimStatement;
        this.witnessStatement = witnessStatement;
        this.evidence = evidence;
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

    public Civilian getWitness() {
        return this.witness;
    }

    public void setWitness(Civilian witness) {
        this.witness = witness;
    }

    public Civilian getPersonOfInterest() {
        return this.personOfInterest;
    }

    public void setPersonOfInterest(Civilian personOfInterest) {
        this.personOfInterest = personOfInterest;
    }

    public Date getDayOfCrime() {
        return this.dayOfCrime;
    }

    public void setDayOfCrime(Date dayOfCrime) {
        this.dayOfCrime = dayOfCrime;
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

    public PoliceOfficer getOfficerInvolved() {
        return this.officerInvolved;
    }

    public void setOfficerInvolved(PoliceOfficer officerInvolved) {
        this.officerInvolved = officerInvolved;
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

    public String getEvidence() {
        return this.evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }
   


}
