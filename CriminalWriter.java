import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CriminalWriter extends CriminalConstants {
	
	
	public static void saveCriminals() {
		Database db = Database.getInstance();
		ArrayList<Criminal> criminals = db.getCriminals();
		JSONArray jsonCriminals = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< criminals.size(); i++) {
			jsonCriminals.add(getCriminalJSON(criminals.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CRIMINALS_FILE_NAME)) {
 
            file.write(jsonCriminals.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCriminalJSON(Criminal c) {
		JSONObject criminalDetails = new JSONObject();
        criminalDetails.put(CRIMINAL_ID, c.getId().toString());
		criminalDetails.put(CRIMINAL_FIRST_NAME, c.getFirstName());
		criminalDetails.put(CRIMINAL_LAST_NAME, c.getLastName());
		criminalDetails.put(CRIMINAL_DOB, c.getDOB());
		criminalDetails.put(CRIMINAL_GENDER, c.getGender());
		criminalDetails.put(CRIMINAL_RACE, c.getRace());
        criminalDetails.put(CRIMINAL_WEIGHT, c.getWeight());
        criminalDetails.put(CRIMINAL_HEIGHT, c.getHeight());
		criminalDetails.put(CRIMINAL_EYE_COLOR, c.getEyeColor());
		criminalDetails.put(CRIMINAL_HAIR_COLOR, c.getHairColor());
        criminalDetails.put(CRIMINAL_HAIR_LENGTH, c.getHairLength());
		criminalDetails.put(CRIMINAL_FACIAL_HAIR, c.getFacialHair());
        criminalDetails.put(CRIMINAL_TATTOO, c.getTattoo());
		criminalDetails.put(CRIMINAL_STATUS, c.getStatus());
		criminalDetails.put(CRIMINAL_GANG, c.getGang());
        criminalDetails.put(CRIMINAL_AGE, c.getAge());
		criminalDetails.put(CRIMINAL_CONVICTION, c.getConviction());
        return criminalDetails;
	}
}

