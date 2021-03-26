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
				String stringDate = (String)criminalJSON.get(CRIMINAL_DOB);
				Date dateOfBirth = Date.splitDate(stringDate);
				String race = (String)criminalJSON.get(CRIMINAL_RACE);
                double weight = (double)criminalJSON.get(CRIMINAL_WEIGHT);
                double height = (double)criminalJSON.get(CRIMINAL_HEIGHT);
				String eyeColor = (String)criminalJSON.get(CRIMINAL_EYE_COLOR);
                String hairColor = (String)criminalJSON.get(CRIMINAL_HAIR_COLOR);
                String hairLength = (String)criminalJSON.get(CRIMINAL_HAIR_LENGTH);
				String facialHair = (String)criminalJSON.get(CRIMINAL_FACIAL_HAIR);
				String stringTattoo = (String)criminalJSON.get(CRIMINAL_TATTOO);
                Tattoo tattoo = Tattoo.splitTattoo(stringTattoo);
                String status = (String)criminalJSON.get(CRIMINAL_STATUS);
                String stringGang = (String)criminalJSON.get(CRIMINAL_GANG);
				Gang gang = Gang.getGangById(stringGang);
				criminals.add(new Criminal(firstName, lastName, dateOfBirth, race, weight, height, eyeColor, hairColor, hairLength, facialHair, tattoo,  status, gang));
			}
			
			return criminals;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

