package services;

import models.Appointment;
import models.Client;

import java.util.*;

public class AppointmentService {
    private int id = 0;
    private List<Appointment> appointments = new ArrayList<Appointment>();
    private List<String> statuses = Arrays.asList("new", "in progress", "cancelled", "waiting for payment", "completed");

    public void CreateAppointment(int clientId, int doctorId, Calendar date) {
        Appointment appointment = new Appointment(id, clientId, doctorId, date);
        appointments.add(appointment);
        id++;
        System.out.println("Appointment created");
    }

    public void SetAppointmentStatus(int id, int status) {
        Optional<Appointment> appointment = appointments.stream().filter(a -> a.GetId() == id).findFirst();
        appointment.ifPresent(a -> a.SetStatus(statuses.get(status)));
        System.out.println("Status updated");
    }

    public void ShowAppointmentsOf(int clientId) {
        System.out.printf("Showing appointments of client with id %s\n", clientId);
        appointments.forEach(a -> {
            if (a.GetClientId() == clientId) a.Print();
        });
        System.out.printf("Total %s appointment(s)\n", appointments.size());
    }

    public void ParseCommand(String[] args) {
        switch (args[0]) {
            case "add" -> {
                int clientId = Integer.parseInt(args[2]);
                int doctorId = Integer.parseInt(args[3]);
                String[] parsedDate = args[4].split("-");
                String[] parsedTime = args[5].split(":");
                Calendar date = new GregorianCalendar(Integer.parseInt(parsedDate[0]), Integer.parseInt(parsedDate[1]),
                        Integer.parseInt(parsedDate[2]), Integer.parseInt(parsedTime[0]),
                        Integer.parseInt(parsedTime[0]), Integer.parseInt(parsedTime[1]));
                CreateAppointment(clientId, doctorId, date);
            }
            case "set" -> {
                int id = Integer.parseInt(args[2]);
                int status = Integer.parseInt(args[4]);
                SetAppointmentStatus(id, status);
            }
            case "list" -> {
                int clientId = Integer.parseInt(args[3]);
                ShowAppointmentsOf(clientId);
            }
        }
    }
}
