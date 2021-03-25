import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DetectiveWriter extends DetectiveConstants {

    public static void saveDetectives() {
        Database db = Database.getInstance();
        ArrayList<Detective> detectives = db.getDetectives();
        JSONArray jsonDetectives = new JSONArray();

        for(int i=0; i<detectives.size();i++)
        {
            jsonDetectives.add(getDetectiveJSON(detectives.get(i)));
        }
    }

    try (FileWriter file = new FileWriter(DETECTIVE_FILE_NAME)){
    file.write(jsonDetectives.toJSONString());
    file.flush();
    } catch (IOException e){
        e.printStackTrace();
    }
    public static JSONObject getDetectiveJSON(Detective detective){
        JSONObject detectiveDetails = new JSONObject();
        detectiveDetails.put(DETECTIVE_FIRST_NAME, detective.getFirstName());
        detectiveDetails.put(DETECTIVE_LAST_NAME, detective.getLastName());
        detectiveDetails.put(DETECTIVE_DOB, detective.getDOB());
        
        return detectiveDetails;
    }

}
    
