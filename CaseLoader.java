import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;
public class CaseLoader extends CaseConstants{
	
	public static ArrayList<Case> loadCases() {
		ArrayList<Case> cases = new ArrayList<Case>();
		
		try {
			FileReader reader = new FileReader(CASE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray casesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < casesJSON.size(); i++) {
				JSONObject caseJSON = (JSONObject)casesJSON.get(i);
                UUID id = UUID.fromString((String)caseJSON.get(CASE_ID));
				String crime = (String)caseJSON.get(CASE_CRIME);
				UUID victimID = UUID.fromString((String)caseJSON.get(CASE_VICTIM));
				Civilian victim = Database.getCivilianById(victimID);
				UUID offenderID = UUID.fromString((String)caseJSON.get(CASE_OFFENDER));
                Criminal offender = Database.getCriminalById(offenderID);
				String suspectDescription = (String)caseJSON.get(CASE_SUSPECT_DESCRIPTION);
				String caseDescription = (String)caseJSON.get(CASE_CASE_DESCRIPTION);
				UUID witnessID = UUID.fromString((String)caseJSON.get(CASE_WITNESS));
                Civilian witness = Database.getCivilianById(witnessID);
				UUID poiID = UUID.fromString((String)caseJSON.get(CASE_PERSON_OF_INTEREST));
                Civilian personOfInterest = Database.getCivilianById(poiID);
				String stringDay = (String)caseJSON.get(CASE_DAY_OF_CRIME);
                Date dayOfCrime = Date.splitDate(stringDay);
				String time = (String)caseJSON.get(CASE_TIME);
				String stringAddress = (String)caseJSON.get(CASE_LOCATION);
                Address location = Address.splitAddress(stringAddress);
				UUID officerID = UUID.fromString((String)caseJSON.get(CASE_OFFICER));
                PoliceOfficer officer = Database.getOfficerById(officerID);
				UUID detectiveID = UUID.fromString((String)caseJSON.get(CASE_DETECTIVE));
                Detective detective = Database.getDetectiveById(detectiveID);
				String victimStatement = (String)caseJSON.get(CASE_VICTIM_STATEMENT);
				String witnessStatement = (String)caseJSON.get(CASE_WITNESS_STATEMENT);
				String evidence = (String)caseJSON.get(CASE_EVIDENCE);

				cases.add(new Case(crime, victim, offender, suspectDescription, caseDescription, witness, personOfInterest, dayOfCrime, time, location, officer, detective, victimStatement, witnessStatement, evidence));
			}
			
			return cases;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args){
		ArrayList<Case> cases = loadCases();
		for(Case c:cases){
			System.out.println(c);
		}
	}
}
