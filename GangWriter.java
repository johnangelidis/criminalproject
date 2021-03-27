import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GangWriter extends GangConstants {
	
	
	public static void saveGangs() {
		Database db = Database.getInstance();
		ArrayList<Gang> gangs = db.getGangs();
		JSONArray jsonGangs = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< gangs.size(); i++) {
			jsonGangs.add(getGangJSON(gangs.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(GANG_FILE_NAME)) {
 
            file.write(jsonGangs.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getGangJSON(Gang g) {
		JSONObject gangDetails = new JSONObject();
        gangDetails.put(GANG_ID, g.getId().toString());
        gangDetails.put(GANG_NAME, g.getName());
        gangDetails.put(GANG_MEMBERS, g.getMembers());
        
        return gangDetails;
	}
}
