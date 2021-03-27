import java.util.UUID;
/**
 * Class representation of a user
 */
public class User {
    private UUID id;
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isLoggedIn;

    public User() {
        this.username = "none";
        this.password = "none";
    }

    public User(String username, String password){
        id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    }

    public UUID getId() {
        return this.id;
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

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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
    /**
    * Returns status of user, if they are logged in or not
    */
    public boolean getLoggedInStatus(){
      return this.isLoggedIn;
    }
    /**
    * Returns admin status of user, true if they are admin false if not
    */
    public boolean getAdminStatus(){
      return this.isAdmin;
    }

    public String toString(){
        return username;
    }
}
