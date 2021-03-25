import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;
public class CriminalLoader extends CriminalConstants{
	
	public static ArrayList<Criminal> loadCriminals() {
		ArrayList<Criminal> criminals = new ArrayList<Criminal>();
		
		try {
			FileReader reader = new FileReader(CRIMINALS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray criminalsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < criminalsJSON.size(); i++) {
				JSONObject criminalJSON = (JSONObject)criminalsJSON.get(i);
                UUID id = (UUID)criminalJSON.get(CRIMINAL_ID);
				String firstName = (String)criminalJSON.get(CRIMINAL_FIRST_NAME);
                String lastName = (String)criminalJSON.get(CRIMINAL_LAST_NAME);
				Date dateOfBirth = (Date)criminalJSON.get(CRIMINAL_DOB);
                double weight = (double)criminalJSON.get(CRIMINAL_WEIGHT);
                double height = (double)criminalJSON.get(CRIMINAL_HEIGHT);
                String hairColor = (String)criminalJSON.get(CRIMINAL_HAIR_COLOR);
                String eyeColor = (String)criminalJSON.get(CRIMINAL_EYE_COLOR);
                Tattoo tattoos = (Tattoo)criminalJSON.get(CRIMINAL_TATTOOS);
                boolean hasScars = (boolean)criminalJSON.get(CRIMINAL_HAS_SCARS);
                String status = (String)criminalJSON.get(CRIMINAL_STATUS);
                boolean isSerialCriminal = (boolean)criminalJSON.get(CRIMINAL_IS_SERIAL_CRIMINAL);
                
				criminals.add(new Criminal(firstName, lastName, weight, height, hairColor, eyeColor, tattoos, hasScars, status, isSerialCriminal));
			}
			
			return criminals;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

