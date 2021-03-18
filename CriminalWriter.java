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
        //criminalDetails.put(CRIMINAL_ID), c.getId());
		criminalDetails.put(CRIMINAL_FIRST_NAME, c.getFirstName());
		criminalDetails.put(CRIMINAL_LAST_NAME, c.getLastName());
        criminalDetails.put(CRIMINAL_WEIGHT, c.getWeight());
        criminalDetails.put(CRIMINAL_HEIGHT, c.getHeight());
		criminalDetails.put(CRIMINAL_HAIR_COLOR, c.getHairColor());
        criminalDetails.put(CRIMINAL_EYE_COLOR, c.getEyeColor());
        criminalDetails.put(CRIMINAL_TATTOOS, c.getTattoos());
        criminalDetails.put(CRIMINAL_HAS_SCARS, c.isHasScars());
        criminalDetails.put(CRIMINAL_IS_SERIAL_CRIMINAL, c.isIsSerialCriminal());
        
        return criminalDetails;
	}
}

