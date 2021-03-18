/**
* Written by Chase Allison
  The UI which will prompt the user and allow them
  to make choices and overall use the application
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
