/**
* Written by Chase Allison
  The UI which will prompt the user and allow them
  to make choices and overall use the application
*/
/**
* Three scenarios need to happen:
1. A detective signs in and enters details of a new crime,
2. Search the system off a suspects description,
  [30 something male.  Thick black hair and a ball cap.  Tall, approximately 6'2''
  Has a dove tattoo on his left shoulder, and a goatee],
  , find dove tattoos. Only two results come up so search for using their age, hair color and height.
  3 results are given, print out their details and their contact information
3. Search for a case by its number and display all of its information,
  [Details, evidence, witnesses, suspect information, victim information etc]
  Print to text file and display on screen
*/
import java.util.ArrayList;
import java.util.Scanner;
public class UI extends UIConstants{
    private Scanner scanner;
    private Database database;
    //private static ArrayList<PoliceOfficer> loadOfficers;
    UI(){
      scanner = new Scanner(System.in);
      database = new Database();
    }
    public void run() {
      System.out.println(WELCOME_MESSAGE);
      //Loop until user quits
      while(true) {
        //displayMainMenu();
        //int userCommand = getUserCommand(mainMenuOptions.length());
        if(userCommand == -1) {
          System.out.println("Invalid command");
          continue;
        }
        //if(userCommand == mainMenuOptions.length -1) break;
        /*switch(userCommand){
          case(0):
        }*/
      }
    }
    public static void main(String[] args) {
        UI UIInterface = new UI();
        UIInterface.run();
    }
}
