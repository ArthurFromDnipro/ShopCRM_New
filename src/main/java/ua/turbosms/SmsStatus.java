package ua.turbosms;

/**
 * Created by Oleg on 26.09.2016.
 */
public enum SmsStatus {
    ACCEPTD, ENROUTE, DELIVRD, REJECTD, UNDELIV, EXPIRED, DELETED, UNKNOWN;

    @Override
    public String toString() {
        return name();
    }
}

