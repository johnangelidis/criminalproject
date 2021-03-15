/**
 * Class representation of a user
 */
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private boolean isLoggedIn;

    public User(String username, String password){
        this.username = username;
        this.password = password;
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
