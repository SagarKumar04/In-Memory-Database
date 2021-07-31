public class Main {
    private static void showOptions() {
        
    }

    public static void main(String[] args) throws InterruptedException {
        User user = new User();

        Constants.LoginEventCodes loginEventCodes = user.loginWrapper();
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
