package models;

public enum AppointmentStatus {
    NEW("NEW"),
    IN_PROCESS("IN PROGRESS"),
    CANCELLED("CANCELLED"),
    AWAITING_PAYMENT("WAITING FOR PAYMENT"),
    COMPLETED("COMPLETED");
    private final String text;
    AppointmentStatus(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
