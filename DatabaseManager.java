import java.util.ArrayList;

/**
 * Class that represents a Database Manager
 * @author Jayden Allen
 */
public class DatabaseManager implements User {
    private ArrayList<User> users;

    public ArrayList<User> getUsers(){
        return this.users;
    }
    public void setUsers(ArrayList<User> users){
        this.users = users;
    }

    public void addUser(String username, String password, String firstName, String lastName, boolean isAdmin){

    }
    public void removeUser(String username, String password){

    }
    public void setAdminStatus(){

    }
    public void removeAdminStatus(){

    }
}
