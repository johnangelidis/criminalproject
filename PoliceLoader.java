import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;
public class PoliceLoader extends PoliceConstants {
    
    public static ArrayList<PoliceOfficer> loadOfficers() {
        var officers = new ArrayList<PoliceOfficer>();

        try {
            FileReader reader = new FileReader(OFFICERS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray officersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < officersJSON.size(); i++) {
                JSONObject officerJSON = (JSONObject)officersJSON.get(i);
                UUID id = (UUID)officerJSON.get(OFFICERS_ID);
                String firstName = (String)officerJSON.get(OFFICERS_FIRST_NAME);
                String lastName = (String)officerJSON.get(OFFICERS_LAST_NAME);
                Date dateOfBirth = (Date)officerJSON.get(OFFICERS_DOB);
                int badgeNum = (Integer)officerJSON.get(OFFICERS_BADGENUM);
                String poliiceDept = (String)officerJSON.get(OFFICERS_DEPT);
                //ArrayList<Case> cases = (ArrayList<Case>)officerJSON.get(OFFICERS_CASES);
                
                officers.add(new PoliceOfficer(firstName, lastName, dateOfBirth, badgeNum, poliiceDept));

            }
            return officers;
                
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    
