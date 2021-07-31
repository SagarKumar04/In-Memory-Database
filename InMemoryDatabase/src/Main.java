import java.util.Scanner;

public class Main {
    private static void showOptions() {
        Scanner scanner = new Scanner(System.in);
        Databases database = new Databases();

        boolean isLoggedOut = false;
        int usersChoice = 0;

        while(!isLoggedOut) {
            System.out.println("Below are your options: ");
            System.out.println("1. Create databases");
            System.out.println("2. Read databases");
            System.out.println("3. Update databases");
            System.out.println("4. Delete databases");
            System.out.println("5. Exit database");
            System.out.println("6. Logout");
            System.out.println("Choice: ");
            usersChoice = scanner.nextInt();

            switch(usersChoice) {
                case 1:
                    database.databaseOperations(Constants.OperationCodes.CREATE);
                    break;
                case 2:
                    database.databaseOperations(Constants.OperationCodes.READ);
                    break;
                case 3:
                    database.databaseOperations(Constants.OperationCodes.UPDATE);
                    break;
                case 4:
                    database.databaseOperations(Constants.OperationCodes.DELETE);
                    break;
                case 5:
                    database.databaseOperations(Constants.OperationCodes.EXIT);
                    break;
                case 6:
                    isLoggedOut = true;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Users users = new Users();

        Constants.LoginEventCodes loginEventCodes = users.loginWrapper();
        System.out.println(loginEventCodes);

        switch(loginEventCodes) {
            case INITIALIZED:
                break;
            case LOGIN_SUCCESSFUL:
                showOptions();
                break;
            case LOGIN_UNSUCCESSFUL_WRONG_PASSWORD:
                break;
            case LOGIN_UNSUCCESSFUL_MAXIMUM_RETRIES_REACHED:
                break;
            case LOGIN_UNSUCCESSFUL_USERNAME_DOES_NOT_EXIST:
                break;
            default:

        }
    }
}
