import java.util.*;

public class Rows {
    private static final Scanner scanner;
    private static Map<String, ArrayList<ArrayList<String>>> rows = new HashMap<String, ArrayList<ArrayList<String>>>();

    static {
        scanner = new Scanner(System.in);

        ArrayList<ArrayList<String>> table11 = new ArrayList<ArrayList<String>>();
        ArrayList<String> table11Row1 = new ArrayList<>();
        table11Row1.add("column1111");
        table11Row1.add("column1112");
        table11Row1.add("column1113");
        ArrayList<String> table11Row2 = new ArrayList<>();
        table11Row2.add("column1121");
        table11Row2.add("column1122");
        table11Row2.add("column1123");
        ArrayList<String> table11Row3 = new ArrayList<>();
        table11Row3.add("column1131");
        table11Row3.add("column1132");
        table11Row3.add("column1133");
        table11.add(table11Row1);
        table11.add(table11Row2);
        table11.add(table11Row3);

        ArrayList<ArrayList<String>> table12 = new ArrayList<ArrayList<String>>();
        ArrayList<String> table12Row1 = new ArrayList<>();
        table12Row1.add("column1211");
        table12Row1.add("column1212");
        table12Row1.add("column1213");
        ArrayList<String> table12Row2 = new ArrayList<>();
        table12Row2.add("column1221");
        table12Row2.add("column1222");
        table12Row2.add("column1223");

        ArrayList<ArrayList<String>> table41 = new ArrayList<ArrayList<String>>();
        ArrayList<String> table41Row1 = new ArrayList<>();
        table41Row1.add("column4111");
        table41Row1.add("column4112");
        table41Row1.add("column4113");

        rows.put("table11", table12);
        rows.put("table12", table12);
        rows.put("table41", table41);
    }

    public void rowOperations(Constants.OperationCodes rowsOperationCodes) {
        Tables tables = new Tables();
        String tableName = tables.getTableSelected();

        switch(rowsOperationCodes) {
            case CREATE:
                createRows(tableName);
                break;
            case READ:
                readRows(tableName);
                break;
            case UPDATE:
                updateRows(tableName);
                break;
            case DELETE:
                deleteRows(tableName);
                break;
            case EXIT:
                break;
            default:
        }
    }

    private void createRows(String tableName) {
        ArrayList<ArrayList<String>> currentTableRows = rows.get(tableName);
        ArrayList<String> row = new ArrayList<String>();
        boolean isRowReady = true;
        while(isRowReady) {
            System.out.print("Enter column value: (type 'exit' to stop): ");
            String columnValue = scanner.next();

            if("exit".equalsIgnoreCase(columnValue)) {
                currentTableRows.add(row);
                rows.put(tableName, currentTableRows);
                isRowReady = false;
            }
            else {
                row.add(columnValue);
            }

        }
    }

    private void readRows(String tableName) {
        ArrayList<ArrayList<String>> currentTableRows = rows.get(tableName);
        if(currentTableRows.size() > 0) {
            System.out.println("Rows are: ");
            for(ArrayList<String> rows : currentTableRows) {
                for(String columns: rows) {
                    System.out.print(columns + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("0 rows found.");
        }
    }

    private void updateRows(String tableName) {
    }

    private void deleteRows(String tableName) {
        ArrayList<ArrayList<String>> currentTableRows = rows.get(tableName);
        System.out.println("Enter row number to be deleted: ");
        int rowNumberToBeDeleted = scanner.nextInt();

        if(currentTableRows.size() >= rowNumberToBeDeleted) {
            System.out.println("Row doesn't exist");
        }
        else {
            currentTableRows.remove(rowNumberToBeDeleted);
            rows.put(tableName, currentTableRows);
        }
    }
}
