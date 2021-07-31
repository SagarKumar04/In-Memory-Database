import java.util.*;

public class Tables {
    private static final Scanner scanner;
    private static Map<String, ArrayList<String>> tables = new HashMap<String, ArrayList<String>>();

    static {
        scanner = new Scanner(System.in);
        ArrayList<String> database1 = new ArrayList<>();
        database1.add("table11");
        database1.add("table12");
        database1.add("table13");

        ArrayList<String> database2 = new ArrayList<>();
        database2.add("table21");
        database2.add("table22");

        ArrayList<String> database4 = new ArrayList<>();
        database2.add("table41");
        database2.add("table42");

        ArrayList<String> database6 = new ArrayList<>();
        database2.add("table61");

        tables.put("database1", database1);
        tables.put("database2", database2);
        tables.put("database4", database4);
        tables.put("database6", database6);
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
        System.out.println("Enter table name: ");
        String tableName = scanner.next();
        ArrayList<String> currentDatabaseTables = tables.get(tableName);
        if(currentDatabaseTables.contains(databaseName)) {
            System.out.println("Table with the name '" + tableName + "' already exists.");
        }
        else {
            currentDatabaseTables.add(databaseName);
            tables.put(databaseName, currentDatabaseTables);
        }
    }

    private void readTable(String databaseName) {
        System.out.println("databaseName: " + databaseName);
        ArrayList<String> currentDatabaseTables = tables.get(databaseName);
        if(currentDatabaseTables.size() > 0) {
            System.out.println("Tables are: ");
            for(String table : currentDatabaseTables) {
                System.out.println(table);
            }
        }
        else {
            System.out.println("0 tables found.");
        }
    }

    private void updateTable(String databaseName) {
    }

    private void deleteTable(String databaseName) {
        System.out.println("Enter table name: ");
        String tableName = scanner.next();
        ArrayList<String> currentDatabaseTables = tables.get(databaseName);
        if(currentDatabaseTables.contains(databaseName)) {
            currentDatabaseTables.remove(databaseName);
            tables.put(tableName, currentDatabaseTables);
            System.out.println("Table with the name '" + tableName + "' deleted.");
        }
        else {
            System.out.println("0 tables with name '" + tableName + "' found.");
        }
    }
}
