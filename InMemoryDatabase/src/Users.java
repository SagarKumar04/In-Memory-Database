import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Users {
    private static final Scanner scanner;

    private static Map<String, String> users = new HashMap<String, String>();
    final private static int MAXIMUM_LOGIN_ATTEMPTS = 3;
    private static int loginAttemptsCounter = 0;

    static {
        scanner = new Scanner(System.in);

        users.put("sagar", "sagar");
        users.put("moni", "moni");
        users.put("puja", "puja");
        users.put("khushi", "khushi");
        users.put("shubham", "shubham");
    }

    private static String loggedInUser;


    public String getLoggedInUser() {
        return loggedInUser;
    }

    public Constants.LoginEventCodes loginWrapper() throws InterruptedException {
        Constants.LoginEventCodes loginEventCodes = Constants.LoginEventCodes.INITIALIZED;

        while(loginAttemptsCounter < MAXIMUM_LOGIN_ATTEMPTS) {
            loginEventCodes = login();

            if(!loginEventCodes.equals(Constants.LoginEventCodes.LOGIN_SUCCESSFUL)) {
                loginAttemptsCounter = loginAttemptsCounter + 1;
            }
            else {
                break;
            }
        }

        System.out.println(loginAttemptsCounter);
        if(loginAttemptsCounter == MAXIMUM_LOGIN_ATTEMPTS) {
            loginEventCodes = Constants.LoginEventCodes.LOGIN_UNSUCCESSFUL_MAXIMUM_RETRIES_REACHED;
        }

        return loginEventCodes;
    }

    private Constants.LoginEventCodes login() {
        Constants.LoginEventCodes loginEventCodes = Constants.LoginEventCodes.INITIALIZED;

        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        loginEventCodes = validateUsernameAndPassword(username, password);

        return loginEventCodes;
    }

    private static Constants.LoginEventCodes validateUsernameAndPassword(String username, String passwordEntered) {
        Constants.LoginEventCodes loginEventCodes;

        if(users.containsKey(username)) {
            String passwordStored = users.get(username);

            if(passwordEntered.equals(passwordStored)) {
                loginEventCodes = Constants.LoginEventCodes.LOGIN_SUCCESSFUL;
                loggedInUser = username;
            }
            else {
                loginEventCodes = Constants.LoginEventCodes.LOGIN_UNSUCCESSFUL_WRONG_PASSWORD;
            }
        }
        else {
            loginEventCodes = Constants.LoginEventCodes.LOGIN_UNSUCCESSFUL_USERNAME_DOES_NOT_EXIST;
        }

        return loginEventCodes;
    }
}
