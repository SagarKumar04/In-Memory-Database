import java.util.*;

public class Rows {
    private static final Scanner scanner;
    private static Map<String, ArrayList<String>> rows = new HashMap<String, ArrayList<String>>();

    static {
        scanner = new Scanner(System.in);
    }

    public void rowOperations(Constants.DatabaseOperationCodes databaseOperationCodes) {
        Tables tables = new Tables();
        String tableName = tables.getTableSelected();

        switch(databaseOperationCodes) {
            case CREATE:
                createTable(tableName);
                break;
            case READ:
                readTable(tableName);
                break;
            case UPDATE:
                updateTable(tableName);
                break;
            case DELETE:
                deleteTable(tableName);
                break;
            case EXIT:
                break;
            default:
        }
    }

    private void createTable(String tableName) {
    }

    private void readTable(String tableName) {
    }

    private void updateTable(String tableName) {
    }

    private void deleteTable(String tableName) {
    }
}
