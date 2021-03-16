import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CaseWriter extends CaseConstants {
	
	
	public static void saveCases() {
		Database db = Database.getInstance();
		ArrayList<Case> cases = db.getCases();
		JSONArray jsonCases = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< cases.size(); i++) {
			jsonCases.add(getCaseJSON(cases.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CASE_FILE_NAME)) {
 
            file.write(jsonCases.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCaseJSON(Case c) {
		JSONObject caseDetails = new JSONObject();
        //caseDetails.put(CASE_ID), c.getId());
		caseDetails.put(CASE_CRIME, c.getCrime());
		caseDetails.put(CASE_VICTIM, c.getVictim());
        caseDetails.put(CASE_OFFENDER, c.getOffender());
        caseDetails.put(CASE_OUTCOME, c.getOutcome());
		caseDetails.put(CASE_WITNESSES, c.getWitnesses());
        caseDetails.put(CASE_PERSONS_OF_INTEREST, c.getPersonsOfInterest());
        caseDetails.put(CASE_DAY_OF_CRIME, c.getDayOfCrime());
        caseDetails.put(CASE_DAY_OF_SENTENCE, c.getDayOfSentence());
        caseDetails.put(CASE_LOCATION, c.getLocation());
        caseDetails.put(CASE_OFFICERS, c.getOfficersInvolved());
        caseDetails.put(CASE_DETECTIVE, c.getDetective());
        
        return caseDetails;
	}
}
