import java.util.ArrayList;

public class UI {
    private static ArrayList<PoliceOfficer> loadOfficers;

    public static void main(String[] args) {
        loadOfficers = PoliceLoader.loadOfficers();
    }
}
