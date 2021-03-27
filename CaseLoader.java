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
				Civilian victim = (Civilian)caseJSON.get(CASE_VICTIM);
                Criminal offender = (Criminal)caseJSON.get(CASE_OFFENDER);
				String suspectDescription = (String)caseJSON.get(CASE_SUSPECT_DESCRIPTION);
				String caseDescription = (String)caseJSON.get(CASE_CASE_DESCRIPTION);
                Civilian witness = (Civilian)caseJSON.get(CASE_WITNESS);
                Civilian personOfInterest = (Civilian)caseJSON.get(CASE_PERSON_OF_INTEREST);
				String stringDay = (String)caseJSON.get(CASE_DAY_OF_CRIME);
                Date dayOfCrime = Date.splitDate(stringDay);
				String time = (String)caseJSON.get(CASE_TIME);
				String stringAddress = (String)caseJSON.get(CASE_LOCATION);
                Address location = Address.splitAddress(stringAddress);
                PoliceOfficer officer = (PoliceOfficer)caseJSON.get(CASE_OFFICER);
                Detective detective = (Detective)caseJSON.get(CASE_DETECTIVE);
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
	
}
