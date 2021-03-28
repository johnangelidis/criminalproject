//import java.util.*;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;

//import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Driver {
    public void exportCriminal(Detective d){
        try{
            File file1 = new File("export.txt");
            FileWriter fw = new FileWriter(file1, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(d.toString());
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args){
        Driver driver = new Driver();
        Date date = new Date("May",12,2020);
        Detective d = new Detective("Steve","Madden",date);
        driver.exportCriminal(d);
    }
}
