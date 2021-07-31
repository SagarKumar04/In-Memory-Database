import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database {
    private static final Scanner scanner;
    private static Map<String, ArrayList<String>> databases = new HashMap<String, ArrayList<String>>();

    static {
        scanner = new Scanner(System.in);

        databases.put("sagar", new ArrayList<>());
        databases.put("moni", new ArrayList<>());
        databases.put("puja", new ArrayList<>());
        databases.put("khushi", new ArrayList<>());
        databases.put("shubham", new ArrayList<>());
    }

    public void createDatabase() {

    }
}
