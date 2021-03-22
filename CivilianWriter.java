import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CivilianWriter extends CivilianConstants {
	
	
	public static void saveCivilians() {
		Database db = Database.getInstance();
		ArrayList<Civilian> civilians = db.getCivilians();
		JSONArray jsonCivilians = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< civilians.size(); i++) {
			jsonCivilians.add(getCivilianJSON(civilians.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CIVILIANS_FILE_NAME)) {
 
            file.write(jsonCivilians.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCivilianJSON(Civilian c) {
		JSONObject civilianDetails = new JSONObject();
        //civilianDetails.put(CIVILIAN_ID), c.getId());
		civilianDetails.put(CIVILIAN_FIRST_NAME, c.getFirstName());
		civilianDetails.put(CIVILIAN_LAST_NAME, c.getLastName());
        civilianDetails.put(CIVILIAN_DOB, c.getDOB());
        civilianDetails.put(CIVILIAN_ADDRESS, c.getAddress());
		civilianDetails.put(CIVILIAN_PHONE_NUMBER, c.getPhone());
        civilianDetails.put(CIVILIAN_IS_VICTIM, c.getisVictim());
        civilianDetails.put(CIVILIAN_IS_WITNESS, c.getisWitNess());
        civilianDetails.put(CIVILIAN_IS_PERSON_OF_INTEREST, c.getisPersonOfInterest());
		
        return civilianDetails;
	}
}
