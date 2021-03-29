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
        caseDetails.put(CASE_ID, c.getId().toString());
		caseDetails.put(CASE_CRIME, c.getCrime());
		caseDetails.put(CASE_VICTIM, c.getVictim());
        caseDetails.put(CASE_OFFENDER, c.getOffender());
		caseDetails.put(CASE_WITNESS, c.getWitness());
        caseDetails.put(CASE_CASE_DESCRIPTION, c.getCaseDescription());
        caseDetails.put(CASE_SUSPECT_DESCRIPTION, c.getSuspectDescription());
        caseDetails.put(CASE_TIME, c.getTime());
        caseDetails.put(CASE_PERSON_OF_INTEREST, c.getPersonOfInterest());
        caseDetails.put(CASE_DAY_OF_CRIME, c.getDayOfCrime());
        caseDetails.put(CASE_LOCATION, c.getLocation());
        caseDetails.put(CASE_OFFICER, c.getOfficerInvolved());
        caseDetails.put(CASE_DETECTIVE, c.getDetective());
        caseDetails.put(CASE_VICTIM_STATEMENT, c.getVictimStatement());
        caseDetails.put(CASE_WITNESS_STATEMENT, c.getWitnessStatement());
        caseDetails.put(CASE_EVIDENCE, c.getEvidence());
        
        return caseDetails;
	}
}
