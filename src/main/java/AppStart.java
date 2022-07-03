import services.AppointmentService;
import services.ClientService;
import services.DoctorService;

import java.util.Scanner;

public class AppStart {
    private static String input;
    private static final ClientService clientService = new ClientService();
    private static final DoctorService doctorService = new DoctorService();
    private static final AppointmentService appointmentService = new AppointmentService();
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                    add doctor [name]
                    add client [name] [optional: date]
                    // requires name longer, then 1 word
                    remove client [id]
                    list clients
                    set client [id] name [name]
                    add appointment [client_id] [doctor_id] [date time]
                    // add appointment 0 0 2022-01-01 12:53
                    list appointments of [id]
                    set appointment [id] status [status]
                    """);
        while (true) {
            input = scanner.nextLine();
            String[] args = input.split("\s");
            switch (args[1]) {
                case "client", "clients" -> clientService.ParseCommand(args);
                case "appointment", "appointments", "app", "apps" -> appointmentService.ParseCommand(args);
                case "doctor" -> doctorService.ParseCommand(args);
                default -> System.out.println("Invalid command");
            }

        }
    }
}
