/**
 * Class representation of a user
 */
public class User {
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isLoggedIn;

    public User() {
        this.username = "none";
        this.password = "none";
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdminStatus(boolean admin) {
        this.isAdmin = admin;
    }

    /**
     * Logs the user into the database
     */
    public void login(){
        if(!isLoggedIn)
            isLoggedIn = true;
    }

    /**
     * Logs the user out of the database
     */
    public void logout(){
        if(isLoggedIn)
            isLoggedIn = false;
    }
    
}
