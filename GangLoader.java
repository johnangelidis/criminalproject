import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GangLoader extends GangConstants{
	
	public static ArrayList<Gang> loadGangs() {
		ArrayList<Gang> gangs = new ArrayList<Gang>();
		
		try {
			FileReader reader = new FileReader(GANG_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray gangsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < gangsJSON.size(); i++) {
				JSONObject gangJSON = (JSONObject)gangsJSON.get(i);
                UUID id = (UUID)gangJSON.get(GANG_ID);
				String name = (String)gangJSON.get(GANG_NAME);
                JSONArray members = (JSONArray)gangJSON.get(GANG_MEMBERS);
                
				//gangs.add(new Gang(name, returnCriminals(members)));
				gangs.add(new Gang(name));
			}
			
			return gangs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/*
	public static ArrayList<Criminal> returnCriminals(JSONArray members){
		ArrayList<Criminal> gangCriminals = new ArrayList<Criminal>();
		for(int i=0; i<members.size(); i++){
			UUID id = UUID.fromString((String)members.get(i));
			Criminal criminal = Database.getInstance().getCriminal(id);
			gangCriminals.add(criminal);
		}
	}
	*/
}
