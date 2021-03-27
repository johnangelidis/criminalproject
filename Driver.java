import java.util.*;

public class Driver {
private Scanner scanner;
private Database database;


Driver(){
    scanner = new Scanner(System.in);
    database = Database.getInstance();
}

public void run(){
    System.out.println("***WELCOME****");
    System.out.print("Username: ");
    String username = scanner.next();
    System.out.println("");
    System.out.print("Password: ");
    String password = scanner.next();

    if(database.findUser(username,password)){
        System.out.println("Welcome " + username + "!");
    }
    else{
        System.out.println("Sorry user not found");
    }
    


    
}
    

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.run();
    }
}
