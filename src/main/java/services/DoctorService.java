package services;

import models.Doctor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorService {
    private int id = 0;
    private List<Doctor> doctors = new ArrayList<Doctor>();

    public void CreateDoctor(String name) {
        Doctor doctor = new Doctor(id, name);
        doctors.add(doctor);
        id ++;
        System.out.println("Doctor created");
    }

    public void ParseCommand(String[] args) {
        switch (args[0]) {
            case "add" -> CreateDoctor(String.join(" ", Arrays.copyOfRange(args, 2, args.length - 1)));
        }
    }
}
