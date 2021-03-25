import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Calendar;
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
                UUID id = (UUID)caseJSON.get(CASE_ID);
				String crime = (String)caseJSON.get(CASE_CRIME);
				Civilian victim = (Civilian)caseJSON.get(CASE_VICTIM);
                Criminal offender = (Criminal)caseJSON.get(CASE_OFFENDER);
                String outcome = (String)caseJSON.get(CASE_OUTCOME);
                JSONArray witnesses = (JSONArray)caseJSON.get(CASE_WITNESSES);
                JSONArray personsOfInterest = (JSONArray)caseJSON.get(CASE_PERSONS_OF_INTEREST);
                Calendar dayOfCrime = (Calendar)caseJSON.get(CASE_DAY_OF_CRIME);
                Calendar dayOfSentence = (Calendar)caseJSON.get(CASE_DAY_OF_SENTENCE);
                Address location = (Address)caseJSON.get(CASE_LOCATION);
                JSONArray officers = (JSONArray)caseJSON.get(CASE_OFFICERS);
                Detective detective = (Detective)caseJSON.get(CASE_DETECTIVE);
                
				cases.add(new Case(crime, victim, offender, outcome, returnWitnesses(witnesses), returnPersonsOfInterest(personsOfInterest), dayOfCrime, dayOfSentence, location, returnOfficers(officers), detective));
			}
			
			return cases;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Civilian> returnWitnesses(JSONArray witnesses){
		ArrayList<Civilian> caseWitnesses = new ArrayList<Civilian>();
		for(int i=0; i<witnesses.size(); i++){
			UUID id = UUID.fromString((String)witnesses.get(i));
			Civilian witness = Database.getInstance().getCivilian(id);
			caseWitnesses.add(witness);
		}
		return caseWitnesses;
	}

	public static ArrayList<Civilian> returnPersonsOfInterest(JSONArray personsOfInterest){
		ArrayList<Civilian> casePOI = new ArrayList<Civilian>();
		for(int i=0; i<personsOfInterest.size(); i++){
			UUID id = UUID.fromString((String)personsOfInterest.get(i));
			Civilian personOfInterest = Database.getInstance().getCivilian(id);
			casePOI.add(personOfInterest);
		}
		return casePOI;
	}

	public static ArrayList<PoliceOfficer> returnOfficers(JSONArray officers){
		ArrayList<PoliceOfficer> caseOfficers = new ArrayList<PoliceOfficer>();
		for(int i=0; i<officers.size(); i++){
			UUID id = UUID.fromString((String)officers.get(i));
			PoliceOfficer officer = Database.getInstance().getOfficer(id);
			caseOfficers.add(officer);
		}
		return caseOfficers;
	}
}
