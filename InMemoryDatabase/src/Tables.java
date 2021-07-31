import java.util.*;

public class Tables {
    private static final Scanner scanner;
    private static Map<String, ArrayList<String>> tables = new HashMap<String, ArrayList<String>>();

    static {
        scanner = new Scanner(System.in);
    }

    private static String tableSelected;

    public String getTableSelected() {
        return tableSelected;
    }

    public void tableOperations(Constants.OperationCodes tableOperationCodes) {
        Databases database = new Databases();
        String databaseName = database.getDatabaseSelected();

        switch(tableOperationCodes) {
            case CREATE:
                createTable(databaseName);
                break;
            case READ:
                readTable(databaseName);
                break;
            case UPDATE:
                updateTable(databaseName);
                break;
            case DELETE:
                deleteTable(databaseName);
                break;
            case EXIT:
                break;
            default:
        }
    }

    private void createTable(String databaseName) {
        System.out.println("Enter database name: ");
        String tableName = scanner.next();
        List<String> currentDatabaseTables = tables.get(tableName);
        if(currentDatabaseTables.contains(databaseName)) {
            System.out.println("Table with the name '" + tableName + "' already exists.");
        }
        else {
            currentDatabaseTables.add(databaseName);
        }
    }

    private void readTable(String databaseName) {
        List<String> currentDatabaseTables = tables.get(databaseName);
        if(currentDatabaseTables.size() > 0) {
            System.out.println("Tables are: ");
            for(String table : currentDatabaseTables) {
                System.out.println(table);
            }
        }
        else {
            System.out.println("0 databases found.");
        }
    }

    private void updateTable(String databaseName) {
    }

    private void deleteTable(String databaseName) {
    }
}
