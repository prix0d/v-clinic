package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Appointment {
    private int id;
    private int clientId;
    private int doctorId;
    private Calendar date;
    public String status;

    public Appointment(int id, int clientId, int doctorId, Calendar date) {
        this.id = id;
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = "new";
    }

    public int GetId() {
        return id;
    }

    public void SetStatus(String status) {
        this.status = status;
    }

    public int GetClientId() {
        return clientId;
    }

    public void Print() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String regDate =  sdf.format(date.getTime());
        System.out.printf("id: %s    client_id: %s    doctor_id: %s    date: %s    status: %s\n", id, clientId, doctorId, regDate, status);
    }
}
