import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import java.util.Calendar;
import java.util.UUID;
public class CivilianLoader extends CivilianConstants{
	
	public static ArrayList<Civilian> loadCivilians() {
		ArrayList<Civilian> civilians = new ArrayList<Civilian>();
		
		try {
			FileReader reader = new FileReader(CIVILIANS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray civiliansJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < civiliansJSON.size(); i++) {
				JSONObject civilianJSON = (JSONObject)civiliansJSON.get(i);
                UUID id = (UUID)civilianJSON.get(CIVILIAN_ID);
				String firstName = (String)civilianJSON.get(CIVILIAN_FIRST_NAME);
				String lastName = (String)civilianJSON.get(CIVILIAN_LAST_NAME);
                //Calendar dateOfBirth = (Calendar)civilianJSON.get(CIVILIAN_DOB);
                Address address = (Address)civilianJSON.get(CIVILIAN_ADDRESS);
                int number = (int)civilianJSON.get(CIVILIAN_PHONE_NUMBER);
                boolean isVictim = (boolean)civilianJSON.get(CIVILIAN_IS_VICTIM);
				boolean isWitness = (boolean)civilianJSON.get(CIVILIAN_IS_WITNESS);
                boolean isPersonOfInterest = (boolean)civilianJSON.get(CIVILIAN_IS_PERSON_OF_INTEREST);
				
				civilians.add(new Civilian(firstName, lastName, address, number, isVictim, isWitness, isPersonOfInterest));
			}
			
			return civilians;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
