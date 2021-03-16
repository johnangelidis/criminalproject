import java.io.FileReader;
import java.util.ArrayList;
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
                int id = (int)gangJSON.get(GANG_ID);
				String name = (String)gangJSON.get(GANG_NAME);
                ArrayList<Criminal> members = (ArrayList<Criminal>)gangJSON.get(GANG_MEMBERS);
                ArrayList<Case> crimes = (ArrayList<Case>)gangJSON.get(GANG_CRIMES);
                
				gangs.add(new Gang(id, name, members, crimes));
			}
			
			return gangs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
