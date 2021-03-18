import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DetectiveLoader extends DetectiveConstants{
    
    public static ArrayList<Detective> loadDetectives() {
        ArrayList<Detective> detectives = new ArrayList<Detective>();

        try {
            FileReader reader = new FileReader(DETECTIVE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray detectivesJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < detectivesJSON.size();i++) {
                JSONObject detectiveJSON = (JSONObject)detectivesJSON.get(i);
                int id = (Integer)detectiveJSON.get(DETECTIVE_ID);
                String firstName = (String)detectiveJSON.get(DETECTIVE_FIRST_NAME);
                String lastName = (String)detectiveJSON.get(DETECTIVE_LAST_NAME);
                ArrayList<Case> cases = (ArrayList<Case>)detectiveJSON.get(DETECTIVE_CASES);

                detectives.add(new Detective(id, firstName, lastName, cases));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}