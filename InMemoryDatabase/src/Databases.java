import java.util.*;

public class Databases {
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

    private static String databaseSelected;

    public String getDatabaseSelected() {
        return databaseSelected;
    }

    public void databaseOperations(Constants.OperationCodes databaseOperationCodes) {
        Users users = new Users();
        String loggedInUser = users.getLoggedInUser();

        switch(databaseOperationCodes) {
            case CREATE:
                createDatabase(loggedInUser);
                break;
            case READ:
                readDatabase(loggedInUser);
                break;
            case UPDATE:
                updateDatabase(loggedInUser);
                break;
            case DELETE:
                deleteDatabase(loggedInUser);
                break;
            case EXIT:
                break;
            default:
        }
    }

    private void createDatabase(String loggedInUser) {
        System.out.println("Enter database name: ");
        String databaseName = scanner.next();
        List<String> currentUsersDatabase = databases.get(loggedInUser);
        if(currentUsersDatabase.contains(databaseName)) {
            System.out.println("Databases with the name '" + databaseName + "' already exists.");
        }
        else {
            currentUsersDatabase.add(databaseName);
        }
    }

    private void readDatabase(String loggedInUser) {
        List<String> currentUsersDatabase = databases.get(loggedInUser);
        if(currentUsersDatabase.size() > 0) {
            System.out.println("Databases are: ");
            for(String database : currentUsersDatabase) {
                System.out.println(database);
            }
        }
        else {
            System.out.println("0 databases found.");
        }
    }

    private void updateDatabase(String loggedInUser) {
        System.out.println("Enter database name: ");
        String databaseName = scanner.next();
        ArrayList<String> currentUsersDatabase = databases.get(loggedInUser);
        if(currentUsersDatabase.contains(databaseName)) {
            Tables tables = new Tables();
            int usersChoice = 0;

            System.out.println("Below are your options: ");
            System.out.println("1. Create table");
            System.out.println("2. Read table");
            System.out.println("3. Update table");
            System.out.println("4. Delete table");
            System.out.println("5. Exit table");
            System.out.println("Choice: ");

            usersChoice = scanner.nextInt();

            switch (usersChoice) {
                case 1:
                    tables.tableOperations(Constants.OperationCodes.CREATE);
                    break;
                case 2:
                    tables.tableOperations(Constants.OperationCodes.READ);
                    break;
                case 3:
                    tables.tableOperations(Constants.OperationCodes.UPDATE);
                    break;
                case 4:
                    tables.tableOperations(Constants.OperationCodes.DELETE);
                    break;
                case 5:
                    tables.tableOperations(Constants.OperationCodes.EXIT);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        else {
            System.out.println("0 databases with name '" + databaseName + "' found.");
        }
    }

    private void deleteDatabase(String loggedInUser) {
        System.out.println("Enter database name: ");
        String databaseName = scanner.next();
        ArrayList<String> currentUsersDatabase = databases.get(loggedInUser);
        if(currentUsersDatabase.contains(databaseName)) {
            currentUsersDatabase.remove(databaseName);
            databases.put(loggedInUser, currentUsersDatabase);
            System.out.println("Databases with the name '" + databaseName + "' deleted.");
        }
        else {
            System.out.println("0 databases with name '" + databaseName + "' found.");
        }
    }

    private void exitDatabase(String loggedInUser) {

    }
}