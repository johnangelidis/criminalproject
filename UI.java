/**
* Written by Chase Allison
  The UI which will prompt the user and allow them
  to make choices and overall use the application
*/
/**
* Three scenarios need to happen:
1. A detective signs in and enters details of a new crime,
2. Search the system off a suspects description,
  , find dove tattoos. Only two results come up so search for using their age, hair color and height.
  3 results are given, print out their details and their contact information
3. Search for a case by its number and display all of its information,
  [Details, evidence, witnesses, suspect information, victim information etc]
  Print to text file and display on screend
*/
import java.util.ArrayList;
import java.util.Scanner;
public class UI extends UIConstants{
    private Scanner scanner;
    private Database database;
    private User currentUser;
    //private static ArrayList<PoliceOfficer> loadOfficers;
    UI(){
      scanner = new Scanner(System.in);
      database = Database.getInstance();
    }
    public void run() {
      System.out.println(WELCOME_MESSAGE);
      //Loop until user quits

      boolean hasQuit = false;
      displayLoginScreen();
      while(!hasQuit) {  // made boolean value for better control over while loop
        displayMainMenu();
        int userCommand = getUserCommand(mainMenuOptions.length);
        if(userCommand == -1)  {
          System.out.println("Invalid command");
          continue;
        }
        if(userCommand == mainMenuOptions.length - 1){
          if(currentUser.getLoggedInStatus() == true) {
            System.out.println("Logging out.");
            hasQuit = true;
            break;
        } else
            break;
        }
        switch(userCommand){
          case(1):
                  createUser();
                  break;
          /*        
          case(2):
                  if(currentUser.getLoggedInStatus() == true && currentUser.getAdminStatus() == true){
                    addACase();
                    break;
                  } else {
                    System.out.println("You either are not logged in or are not an admin");
                    break;
                  }
          case(3):

                  break;
                  //search for criminal/suspect
          
          case(4):
                  database.searchCases(getInput("Crime:"),getInput(""));
                  break;
                  //search cases
          */        
        }
      }
    }
    private Address makeAddress(){
      int number = getInt("Address number");
      String street = getString("Address street");
      String city = getString("Address city");
      String state = getString("Address state");
      int zip = getInt("Address zipcode");
      Address ret = new Address(number, street, city, state, zip);
      return ret;
    }
    private Detective makeDetective(){
      String firstName = getString("First name");
      String lastName = getString("Last name");
      Date dateOfBirth = makeDate("Date of Birth");
      Detective d = new Detective(firstName, lastName, dateOfBirth);
      database.addDetective(d);
      return d;
      
    }
    private Detective promptForDetective(){
      System.out.println("Would you like to add a new or existing"+
      "Detective?\n Enter 1 for new or 2 for existing");
      String input = scanner.nextLine();
      int choice = Integer.parseInt(input);
      if(choice == 1) {
        Detective newDetective = makeDetective();
        return newDetective;
      } else if (choice == 2) {
        String firstName = getString("FirstName");
        String lastName = getString("LastName");
        Detective oldDetective = database.searchDetectives(firstName,lastName);
        return oldDetective;
      } else {
        System.out.println("Invalid input");
      }
      return null;
    }
    private Civilian makeCivilian(){
      String firstName = getString("FirstName");
      String lastName = getString("LastName");
      int phone = getInt("Phone Number");
      Date dob = makeDate("Birthday");
      Address addy = makeAddress();
      Civilian ret = new Civilian(firstName, lastName, dob, addy, phone);
      return ret;
    }
    private Date makeDate(String instance){
      String monthOfCrime = getString("Month of "+instance);
      int dayOfCrime = getInt("Day of "+instance);
      int yearOfCrime = getInt("Year of "+instance);
      Date ret = new Date(monthOfCrime,dayOfCrime,yearOfCrime);
      return ret;
    }
    private Civilian promptForVictim(){
      System.out.println("Would you like to add a new or existing"+
      "Civilian?\n Enter 1 for new or 2 for existing");
      String input = scanner.nextLine();
      int choice = Integer.parseInt(input);
      if(choice == 1) {
        Civilian newCivilian = makeCivilian();
        return newCivilian;
      } else if (choice == 2) {
        String firstName = getString("FirstName");
        String lastName = getString("LastName");
        Civilian oldCivilian = database.searchCivilians(firstName,lastName);
        return oldCivilian;
      } else {
        System.out.println("Invalid input");
      }
      return null;
    }
    
    private void addACase(){
      //get basics then prompt(new or existing)
      String crime = getString("Crime");
      String outcome = getString("Outcome");
      Date dateOfCrime = makeDate("Crime");
      Date dateOfSentence = makeDate("Sentence");
      Detective caseDetective = promptForDetective();
      //Civilian caseVictim = promptForVictim();
      //Criminal offender = promptForOffender();
      //Address location = promptForAddress();

    }
    
    private void createUser(){
      String username = getString("Username");
      String password = getString("Password");
      database.addUser(username,password);
    }

    private int getInt(String input) {
		System.out.print(input + ": ");
		return scanner.nextInt();
    }
    private String getString(String input) {
      System.out.print(input + ": ");
      String in = scanner.next();
      System.out.println(" ");
      return in;
    }

    // made currentUser an instance variable so it can be used in other methods
    private void login() { 
      String username = getString("Username");
      String password = getString("Password");
      if(database.searchUser(username) != null){
        currentUser = database.searchUser(username);
        if(currentUser.getPassword().equals(password)){
        currentUser.login();
      } else {
        System.out.println("Invalid password.");
      }
        System.out.println("Welcome " +currentUser.getUsername()+".");
      } else {
        System.out.println("Sorry, invalid username.");
      }
    }
    private int getUserCommand(int numCommands){
      System.out.print("Please select an action: ");
      // String input = scanner.nextLine();
      // int command = Integer.parseInt(input) - 1;
      int command = scanner.nextInt();  
      // this ^ method is more efficient, will keep unless there are side effects
      if(command >= 0 && command <= numCommands -1) return command;
      return -1;
    }
    private void displayMainMenu(){
        System.out.println("\n********** Main Menu **********");
        for(int i=0; i<mainMenuOptions.length; i++){
          System.out.println((i+1) + ", " + mainMenuOptions[i]);
        }
        System.out.println("\n");
    }

    private void displayLoginScreen() {  // gives user option to either login or create an account
      System.out.println("Enter 1 to login:\nEnter 2 to create an account: ");
      Scanner keyboard = new Scanner(System.in);
      int input = keyboard.nextInt();
      boolean validOption = true;
      while (validOption) {
      if (input == 1) {
        login();
        validOption = false;
      }
      else if (input == 2) {
        createUser();
        validOption = false;
      }
      else
        System.out.println("Please enter a valid option");
    }
    }
    public static void main(String[] args) {
        UI UIInterface = new UI();
        UIInterface.run();
    }
}
