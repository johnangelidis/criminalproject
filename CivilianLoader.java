import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import java.util.Calendar;
public class CivilianLoader extends CivilianConstants{
	
	public static ArrayList<Civilian> loadCivilians() {
		ArrayList<Civilian> civilians = new ArrayList<Civilian>();
		
		try {
			FileReader reader = new FileReader(CIVILIANS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray civiliansJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < civiliansJSON.size(); i++) {
				JSONObject civilianJSON = (JSONObject)civiliansJSON.get(i);
                int id = (int)civilianJSON.get(CIVILIAN_ID);
				String firstName = (String)civilianJSON.get(CIVILIAN_FIRST_NAME);
				String lastName = (String)civilianJSON.get(CIVILIAN_LAST_NAME);
                //Calendar dateOfBirth = (Calendar)civilianJSON.get(CIVILIAN_DOB);
                Address address = (Address)civilianJSON.get(CIVILIAN_ADDRESS);
                int number = (int)civilianJSON.get(CIVILIAN_PHONE_NUMBER);
                boolean isVictim = (boolean)civilianJSON.get(CIVILIAN_IS_VICTIM);
				boolean isWitness = (boolean)civilianJSON.get(CIVILIAN_IS_WITNESS);
                boolean isPersonOfInterest = (boolean)civilianJSON.get(CIVILIAN_IS_PERSON_OF_INTEREST);
                ArrayList<Case> cases = (ArrayList<Case>)civilianJSON.get(CIVILIAN_CASES);
				
				civilians.add(new Civilian(id, firstName, lastName, address, number, isVictim, isWitness, isPersonOfInterest, cases));
			}
			
			return civilians;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
