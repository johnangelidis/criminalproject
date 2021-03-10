import java.util.ArrayList;

/**
 * Class that represents a case
 */
public class Case{
    private int id;
    private String crime;
    private Criminal offender;
    private Citizen victim;
    private String outcome;
    private ArrayList<Citizen> witnesses;
    private ArrayList<Citizen> personsOfInterests;
    private Date dayOfCrime;
    private Date dayOfSentence;
    private Address location;
    private ArrayList<PoliceOfficer> officersInvolved;

    Public Case(int id, String crime, Criminal offender, Citizen victim
    ,String outcome, ArrayList<Citizen> witnesses, ArrayList<Citizen> 
    personsOfInterests, Date dayOfCrime, Date dayOfSentence, Address location,
    ArrayList<PoliceOfficer> officersInvolved){
        
    }
}