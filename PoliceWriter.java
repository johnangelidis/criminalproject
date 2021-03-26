import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PoliceWriter extends PoliceConstants {



    public static void saveOfficers() {
        Database db = Database.getInstance();
        ArrayList<PoliceOfficer> officers = db.getOfficers();
        JSONArray jsonOfficers = new JSONArray();

        //creating all the json objects
        for(int i=0; i< officers.size();i++){
            jsonOfficers.add(getPoliceOfficerJSON(officers.get(i)));
        }
    }

    //Writing the JSON File
    try (FileWriter file = new FileWriter(OFFICERS_FILE_NAME)) {

        
        file.write(jsonOfficers.toJSONString());
        file.flush();
    }catch (IOException e) {
        e.printStackTrace();
    }

    public static JSONObject getPoliceOfficerJSON(PoliceOfficer officer) {
        JSONObject officerDetails = new JSONObject();
        officerDetails.put(OFFICERS_FIRST_NAME, officer.getFirstName());
        officerDetails.put(OFFICERS_LAST_NAME, officer.getLastName());
        officerDetails.put(OFFICERS_DOB, officer.getDOB());
        officerDetails.put(OFFICERS_DEPT, officer.getpoliceDept());
        officerDetails.put(OFFICERS_BADGENUM, officer.getbadgeNum());

        return officerDetails;
    }
}
