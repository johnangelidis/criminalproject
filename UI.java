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
    private Person searchPerson;
    //private static ArrayList<PoliceOfficer> loadOfficers;
    UI(){
      scanner = new Scanner(System.in);
      database = Database.getInstance();
    }
    public void run() {
      System.out.println(WELCOME_MESSAGE);
      //Loop until user quits
      while(true) {
        displayMainMenu();
        int userCommand = getUserCommand(mainMenuOptions.length());
        if(userCommand == -1) {
          System.out.println("Invalid command");
          continue;
        }
        if(userCommand == mainMenuOptions.length -1){
          if(currentUser.getLoggedInStatus == true){
            System.out.println("Logging out.");
            currentUser.logout();
            break;
          } else
           break;
        }
        switch(userCommand){
          case(0):
                  createUser();
                  break;
          case(1):
                  login();
                  break;
          case(2):
                  if(currentUser.getLoggedInStatus == true && currentUser.getAdminStatus == true){
                    addCase();
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
        }
      }
    }
    private void searchPeople(){
      System.out.println("Enter First Name");
      String firstName = scanner.nextLine();
      System.out.println("Enter Last Name");
      String lastName = scanner.nextLine();
      System.out.println("Searching Library");
      database.searchPerson(firstName, lastName);
    }
    private void searchCases(){

    }
    private Address makeAddress(){
      int number = getInput("Number");
      String street = getInput("Street");
      String city = getInput("City");

      /*
      private int number;
      private String street;
      private String city;
      private String state;
      private int zip;
      */
    }
    private Detective makeDetective(){
      String firstName = getInput("First name");
      String lastName = getInput("Last name");
      if(database.addDetective(firstName,lastName)){
        System.out.println("Detective created successfully.");
      } else {
        System.out.println("Sorry, something went wrong.");
      }
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
        Detective oldDetective = database.searchPerson(getInput("FirstName"),getInput("LastName"));
        return oldDetective;
      } else {
        System.out.println("Invalid input");
      }
      return null;
    }
    private Civilian makeCivilian(){
      int phone = getInput("Phone Number");
      /*
      private Address address;
    	private int phone;
    	private boolean isVictim;
    	private boolean isWitness;
    	private boolean isPersonOfInterest;
      */
    }
    private Civilian promptForVictim(){
      System.out.println("Would you like to add a new or existing"+
      "Civilian?\n Enter 1 for new or 2 for existing");
      String input = scanner.nextLine();
      int choice = Integer.parseInt(input);
      if(choice == 1) {
        Civilian newCivilian = makeCivilian();
        return newCivlian;
      } else if (choice == 2) {
        Detective oldCivilian = database.searchPerson(getInput("FirstName"),getInput("LastName"));
        return oldCivilian;
      } else {
        System.out.println("Invalid input");
      }
      return null;
    }
    private void addCase(){
      //get basics then prompt(new or existing)
      String crime = getInput("Crime");
      String outcome = getInput("Outcome");
      Date dayOfCrime = new Date(getInput("Month"),getInput("Day"),getInput("Year"));
      Date dayOfSentence = new Date(getInput("Month"),getInput("Day"),getInput("Year"));
      Detective caseDetective = promptForDetective();
      //Civilian caseVictim = promptForVictim();
      //Criminal offender = promptForOffender();
      //Address location = promptForAddress();

      /*
      private ArrayList<Civilian> witnesses;
      private ArrayList<Civilian> personsOfInterest;
      private ArrayList<PoliceOfficer> officersInvolved;
      */
    }
    private void createUser(){
      String username = getInput("Username");
      String password = getInput("Password");
      if(database.addUser(username,password)){
        System.out.println("Account created successfully.");
      } else {
        System.out.println("Sorry, try a different username.");
      }
    }
    private String getInput(String input) {
		System.out.print(input + ": ");
		return scanner.nextLine();
    }
    private void login(){
      String username = getField("Username");
      String password = getField("Password");
      if(database.searchUser(username)){
        User currentUser = database.searchUser(username);
        if(currentUser.getPassword.equals(password)){
        currentUser.login();
      } else {
        System.out.println("Invalid password.");
      }
        System.out.println("Welcome " +currentUser.getUsername()+".");
      } else {
        System.out.println("Sorry, invalid username.");
      }
    }
    private void getUserCommand(int numCommands){
      System.out.print("Please select an action: ");

      String input = scanner.nextLine();
      int command = Integer.parseInt(input) - 1;

      if(command >= 0 && command <= numCommands -1) return command;

      return -1;
    }
    private void displayMainMenu(){
        System.out.println("\n********** Main Menu **********");
        for(int i=0; i<mainMenuOptions.length; i++){
          System.out.println(i+1) + ", " + mainMenuOptions[i]);
        }
        System.out.println("\n");


    }
    public static void main(String[] args) {
        UI UIInterface = new UI();
        UIInterface.run();
    }
}
