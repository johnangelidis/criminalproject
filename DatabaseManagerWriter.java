import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseManagerWriter extends DatabaseManagerConstants {
    public static void saveDatabaseManager() {
        Database db = Database.getInstance();
		ArrayList<User> users = db.getUsers();
		JSONArray JSONUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			JSONUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(DM_FILE_NAME)) {
 
            file.write(JSONUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getUserJson(DatabaseManager user) {
        JSONObject userList = new JSONObject();
        userList.put(USERARRAYLIST, user.getUsers());
        return userList;
    }
}
