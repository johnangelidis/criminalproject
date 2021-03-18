import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;

import jdk.nashorn.internal.parser.JSONParser;


public class DatabaseManagerLoader extends DatabaseManagerConstants {

    public static ArrayList<DatabaseManager> loadDatabaseMangaer() {
        ArrayList<DatabaseManager> dataMan = new ArrayList<DatabaseManager>();
        
        try{
            FileReader reader = new FileReader(DM_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray dataManJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < dataManJSON.size(); i++) {
                JSONObject dataManJSON = (JSONObject)dataManJSON.get(i);
                ArrayList<User> databaseManager = (ArrayList<User>)dataManJSON.get(USERARRAYLIST);
                dataMan.add(new DatabaseManager(databaseManager));
            }
            return dataMan;
            reader.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
