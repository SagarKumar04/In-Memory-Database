public class Constants {
    enum LoginEventCodes {
        INITIALIZED,
        LOGIN_SUCCESSFUL,
        LOGIN_UNSUCCESSFUL_WRONG_PASSWORD,
        LOGIN_UNSUCCESSFUL_USERNAME_DOES_NOT_EXIST,
        LOGIN_UNSUCCESSFUL_MAXIMUM_RETRIES_REACHED
    }

    enum OperationCodes {
        CREATE,
        READ,
        UPDATE,
        DELETE,
        EXIT
    }
}
