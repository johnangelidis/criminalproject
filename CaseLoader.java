import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Calendar;
public class CaseLoader extends CaseConstants{
	
	public static ArrayList<Case> loadCases() {
		ArrayList<Case> cases = new ArrayList<Case>();
		
		try {
			FileReader reader = new FileReader(CASE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray casesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < casesJSON.size(); i++) {
				JSONObject caseJSON = (JSONObject)casesJSON.get(i);
                int id = (int)caseJSON.get(CASE_ID);
				String crime = (String)caseJSON.get(CASE_CRIME);
				Civilian victim = (Civilian)caseJSON.get(CASE_VICTIM);
                Criminal offender = (Criminal)caseJSON.get(CASE_OFFENDER);
                String outcome = (String)caseJSON.get(CASE_OUTCOME);
                ArrayList<Civilian> witnesses = (ArrayList<Civilian>)caseJSON.get(CASE_WITNESSES);
                ArrayList<Civilian> personsOfInterest = (ArrayList<Civilian>)caseJSON.get(CASE_PERSONS_OF_INTEREST);
                Calendar dayOfCrime = (Calendar)caseJSON.get(CASE_DAY_OF_CRIME);
                Calendar dayOfSentence = (Calendar)caseJSON.get(CASE_DAY_OF_SENTENCE);
                Address location = (Address)caseJSON.get(CASE_LOCATION);
                ArrayList<PoliceOfficer> officers = (ArrayList<PoliceOfficer>)caseJSON.get(CASE_OFFICERS);
                Detective detective = (Detective)caseJSON.get(CASE_DETECTIVE);
                
				cases.add(new Case(id, crime, victim, offender, outcome, witnesses, personsOfInterest, dayOfCrime, dayOfSentence, location, officers, detective));
			}
			
			return cases;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
