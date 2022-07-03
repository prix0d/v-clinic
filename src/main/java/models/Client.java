package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client {
    private int id;
    private String name;
    private Calendar registrationDate;

    public Client(int id, String name, Calendar registrationDate){
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public void Print() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String regDate =  sdf.format(registrationDate.getTime());
        System.out.printf("id: %s    reg_date: %s    name: %s\n", id, regDate, name);
    }

    public int GetId() {
        return id;
    }

    public void SetName(String name) {
        this.name = name;
    }
}
