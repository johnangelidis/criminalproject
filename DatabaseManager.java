import java.util.ArrayList;

/**
 * Class that represents a Database Manager
 * @author Jayden Allen
 */
public class DatabaseManager {
    
    private ArrayList<User> users;

    public ArrayList<User> getUsers(){
        return this.users;
    }
    public void setUsers(ArrayList<User> users){
        this.users = users;
    }

    public void addUser(String username, String password, String firstName, String lastName, boolean isAdmin){
        User newUser = new User(username, password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAdminStatus(isAdmin);
        users.add(newUser);
    }

    public void removeUser(String username, String password) {
        users.remove(username);
    }

    // removed set AdminStatus and removeAdminStatus methods, as these are implemented in the user class
}
