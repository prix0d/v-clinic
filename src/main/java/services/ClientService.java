package services;

import models.Appointment;
import models.Client;
import java.util.*;

public class ClientService {
    private int id = 0;
    private List<Client> clients = new ArrayList<Client>();

    public void CreateClient(String name, Calendar registrationDate) {
        Client client = new Client(id, name, registrationDate);
        clients.add(client);
        id ++;
        System.out.println("Client created");
    }

    public void ShowClients() {
        clients.forEach(Client::Print);
        System.out.printf("Total %s client(s)\n", clients.size());
    }

    public void SetClientName(int id, String name) {
        Optional<Client> client = clients.stream().filter(c -> c.GetId() == id).findFirst();
        client.ifPresent(value -> value.SetName(name));
        System.out.println("Name changed");
    }

    public void RemoveClient(int id) {
        clients.removeIf(c -> c.GetId() == id);
        System.out.println("Client removed");
    }

    public void ParseCommand(String[] args) {
        switch (args[0]) {
            case "add" -> {
                Calendar date;
                String[] parsedDate = args[args.length-1].split("-");
                if (parsedDate.length == 1) {
                    date = Calendar.getInstance();
                    CreateClient(String.join(" ", Arrays.copyOfRange(args, 2, args.length - 2)), date);
                }
                else {
                    date = new GregorianCalendar(Integer.parseInt(parsedDate[0]), Integer.parseInt(parsedDate[1]), Integer.parseInt(parsedDate[2]));
                    CreateClient(String.join(" ", Arrays.copyOfRange(args, 2, args.length - 1)), date);
                }

            }
            case "list" -> ShowClients();
            case "set" -> SetClientName(Integer.parseInt(args[2]), String.join(" ", Arrays.copyOfRange(args, 4, args.length - 1)));
            case "remove", "rm" -> RemoveClient(Integer.parseInt(args[2]));
        }
    }
}
