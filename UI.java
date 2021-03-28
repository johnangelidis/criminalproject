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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.UUID;

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
      database.loadCases();
      boolean hasQuit = false;
      displayLoginScreen();
      while(!hasQuit) {  // made boolean value for better control over while loop
        displayMainMenu();
        int userCommand = getUserCommand(mainMenuOptions.length);
        if(userCommand == -1)  {
          System.out.println("Invalid command");
          continue;
        }
        // if(userCommand == mainMenuOptions.length){
        //   if(currentUser.getLoggedInStatus() == true) {
        //     System.out.println("Logging out.");
        //     hasQuit = true;
        //     break;
        // } else
        //     break;
        // }
        switch(userCommand){
          case(1):  // create account
                  createUser();
                  break;     
          case(2):  // add a case
                    addCase();
                    break;
          case(3):  // search for criminal
                database.searchCriminals(getString("first name"), getString("last name"));
                break;
          case(4):  // search cases
                  String enteredString = getString("Please enter case ID");
                  UUID enteredUUID = UUID.fromString(enteredString);
                  database.getCaseById(enteredUUID);
                  break;  
          case(5):
                  System.out.println("Logging out");
                  System.exit(0);
          default:
                  System.out.println("invalid command");
                  continue;
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

    private Criminal makeCriminal(){
      String firstName = getString("Criminal first name");
      String lastName = getString("Criminal Last name");
      Date dateOfBirth = makeDate("Criminal Date of Birth");
      int age = getInt("Criminal's age");
      String race = getString("Criminal Race");
      double weight = getDouble("Criminal Weight");
      double height = getDouble("Criminal Height");
      String eyeColor = getString("Criminal Eye color");
      String hairColor = getString("Criminal Hair color");
      String hairLength = getString("Criminal Hair length");
      String facialHair = getString("Criminal Facial hair");
      String tattoo = getString("Tattoo");
      String status = getString("Criminal Status");
      Gang gang = new Gang("Gang");

      Criminal c = new Criminal(firstName, lastName, dateOfBirth, race, weight, height, eyeColor, hairColor, hairLength, facialHair, tattoo, status, gang,age);
      database.addCriminal(c);
      return c;
    }

    private Tattoo promptForTattoo(){
      String color = getString("Tattoo color");
      String design = getString("Tattoo design");
      String location = getString("Tattoo location");
      Tattoo t = new Tattoo(color, design, location);
      return t;
    }

    private Detective makeDetective(){
      String firstName = getString("First name");
      String lastName = getString("Last name");
      Date dateOfBirth = makeDate("Date of Birth");
      Detective d = new Detective(firstName, lastName, dateOfBirth);
      database.addDetective(d);
      return d;
    }

    private Civilian makeCivilian(){
      String firstName = getString("FirstName");
      String lastName = getString("LastName");
      long phone = getLong("Phone Number");
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

    private PoliceOfficer makePoliceOfficer() {
      String firstName = getString("first name");
      String lastName = getString("last name");
      System.out.print("Enter date of birth: ");
      Date dob = makeDate("birth");
      int badgeNumber = getInt("badge number");
      String policeDepartment = getString("police department");
      PoliceOfficer newPoliceOfficer = new PoliceOfficer(firstName, lastName, dob, badgeNumber, policeDepartment);
      return newPoliceOfficer;
    }

    private Gang makeGang() {
      String name = getString("gang name");
      Gang newGang = new Gang(name);
      database.addGang(newGang);
      return newGang;
    }
    
    private void addCase(){
      //get basics then prompt(new or existing)
      String crime = getString("Crime");
      System.out.println("Victim Information");
      Civilian victim = makeCivilian();
      System.out.println("Offender Information");
      Criminal offender = makeCriminal();
      String suspectDescription = getString("Suspect Description");
      String caseDescription = getString("Case Description");
      System.out.println("Witness Information");
      Civilian witness = makeCivilian();
      System.out.println("Person of Interest Information");
      Civilian personOfInterest = makeCivilian();
      Date dayOfCrime = makeDate("Date");
      String time = getString("Time");
      Address location = makeAddress();
      System.out.println("Police Officer Information");
      PoliceOfficer officer = makePoliceOfficer();
      System.out.println("Detective Information");
      Detective detective = makeDetective();
      String victimStatement = getString("Victim Statement");
      String witnessStatement = getString("Witness Statement");
      String evidence = getString("Evidence");

      Case c = new Case(crime, victim, offender, suspectDescription, caseDescription, witness, personOfInterest, dayOfCrime, time, location, officer, detective, victimStatement, witnessStatement, evidence);
      database.addCase(c);
    }

    private void deleteCase(UUID caseID){
      database.deleteCase(caseID);
    }

    private void deleteCriminal(UUID criminalID){
      database.deleteCriminal(criminalID);
    }

    private void deleteCivilian(UUID civilianID){
      database.deleteCivilian(civilianID);
    }

    private void deletePoliceOfficer(UUID officerID){
      database.deleteOfficer(officerID);
    }

    private void deleteUser(UUID userID){
      database.deleteUser(userID);
    }

    private void deleteDetective(UUID detectiveID){
      database.deleteDetective(detectiveID);
    }

    private void deleteGang(UUID gangID){
      database.deleteGang(gangID);
    }

    private int getInt(String input) {
      System.out.print(input + ": ");
      int in = scanner.nextInt();
      System.out.println(" ");
      return in;
    }
    private String getString(String input) {
      System.out.print(input + ": ");
      String in = scanner.next();
      System.out.println(" ");
      return in;
    }

    private long getLong(String input) {
      System.out.print(input + ": ");
      long in = scanner.nextLong();
      System.out.println(" ");
      return in;
    }

    private double getDouble(String input){
      System.out.print(input + ": " );
      double in = scanner.nextDouble();
      System.out.println(" ");
      return in;
    }

    // made currentUser an instance variable so it can be used in other methods
    private void login() { 
      String username = getString("Username");
      String password = getString("Password");
      boolean loginSuccess = false;
      while (!loginSuccess) {
        if(database.searchUser(username) != null){
          currentUser = database.searchUser(username);
          if(currentUser.getPassword().equals(password)) {
          currentUser.login();
        } else {
          System.out.println("Invalid password.");
          displayLoginScreen();
        }
          System.out.println("Welcome " +currentUser.getUsername()+".");
          loginSuccess = true;
          return;
        } else {
          System.out.println("Sorry, invalid username.");
          displayLoginScreen();
      }
    }
    }

    private void createUser(){
      String username = getString("Username");
      String password = getString("Password");
      database.addUser(username, password);
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
          System.out.println((i+1) + ": " + mainMenuOptions[i]);
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
    
    private void exportCase(Case aCase) throws FileNotFoundException {
      String caseOutput = aCase.toString();
      PrintWriter out = new PrintWriter("case.txt");
      out.println(caseOutput);
    }

    private void exportPerson(Person aPerson) throws FileNotFoundException {
      String personOutput = aPerson.toString();
      PrintWriter out = new PrintWriter("person.txt");
      out.println(personOutput);
      
    }
    public static void main(String[] args) {
        UI UIInterface = new UI();
        UIInterface.run();
    }
}
