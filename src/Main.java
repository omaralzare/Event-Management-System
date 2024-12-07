import java.util.*;
import java.time.LocalDate;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Admin admin;
    private static List<Organizer> organizers = new ArrayList<>();
    private static List<Participant> participants = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        initializeSystem();

        while (true) {
            System.out.println("******************************************");
            System.out.println("  Welcome to the Event Management System  ");
            System.out.println("******************************************");
            System.out.println("        1. Login as Admin");
            System.out.println("        2. Login as Organizer");
            System.out.println("        3. Login as Participant");
            System.out.println("        4. Exit");
            System.out.println("******************************************");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    loginAsAdmin();
                    break;
                case 2:
                    loginAsOrganizer();
                    break;
                case 3:
                    loginAsParticipant();
                    break;
                case 4:
                    System.out.println("Thank you for using the Event Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSystem() {
        admin = new Admin(1001, "admin123", "System Admin");

        Organizer org1 = new Organizer(1002, "org123", "Omar Saad");
        Organizer org2 = new Organizer(1003, "org456", "Google");
        organizers.add(org1);
        organizers.add(org2);
        admin.addOrganizer(org1);
        admin.addOrganizer(org2);

        Participant part1 = new Participant(1004, "part123", "Ahmad Ali");
        Participant part2 = new Participant(1005, "part456", "Khaled Haitham");
        participants.add(part1);
        participants.add(part2);
        admin.addParticipant(part1);
        admin.addParticipant(part2);
    }

    private static void loginAsAdmin() {
        System.out.print("Enter admin password: ");
        String password = input.nextLine();
        if (admin.login(password)) {
            adminMenu();
        }
    }

    private static void loginAsOrganizer() {
        System.out.print("Enter organizer ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        for (Organizer organizer : organizers) {
            if (organizer.userID == id && organizer.login(password)) {
                organizerMenu(organizer);
                return;
            }
        }
        System.out.println("Invalid ID or password.");
    }

    private static void loginAsParticipant() {
        System.out.print("Enter participant ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        for (Participant participant : participants) {
            if (participant.userID == id && participant.login(password)) {
                participantMenu(participant);
                return;
            }
        }
        System.out.println("Invalid ID or password.");
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("************************************");
            System.out.println("*            Admin Menu            *");
            System.out.println("************************************");
            System.out.println("*   1.  Add Organizer              *");
            System.out.println("*   2.  Remove Organizer           *");
            System.out.println("*   3.  Add Participant            *");
            System.out.println("*   4.  Remove Participant         *");
            System.out.println("*   5.  Show Events by Organizer   *");
            System.out.println("*   7.  Create Event               *");
            System.out.println("*   8.  Delete Event               *");
            System.out.println("*   9.  Update Event               *");
            System.out.println("*   10. View Reports               *");
            System.out.println("*   11. Logout                     *");
            System.out.println("************************************");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addOrganizer();
                    break;
                case 2:
                    removeOrganizer();
                    break;
                case 3:
                    addParticipant();
                    break;
                case 4:
                    removeParticipant();
                    break;
                case 5:
                    showEventsByOrganizer();
                    break;
                case 6:
                    showEventsByParticipant();
                    break;
                case 7:
                    createEvent();
                    break;
                case 8:
                    deleteEvent();
                    break;
                case 9:
                    updateEvent();
                    break;
                case 10:
                    admin.viewReports();
                    break;
                case 11:
                    admin.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addOrganizer() {
        System.out.print("Enter new organizer ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter new organizer name: ");
        String name = input.nextLine();
        System.out.print("Enter new organizer password: ");
        String password = input.nextLine();

        Organizer newOrganizer = new Organizer(id, password, name);
        organizers.add(newOrganizer);
        admin.addOrganizer(newOrganizer);
    }

    private static void removeOrganizer() {
        System.out.print("Enter organizer ID to remove: ");
        int id = input.nextInt();
        admin.removeOrganizer(id);
        organizers.removeIf(org -> org.userID == id);
    }

    private static void addParticipant() {
        System.out.print("Enter new participant ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter new participant name: ");
        String name = input.nextLine();
        System.out.print("Enter new participant password: ");
        String password = input.nextLine();

        Participant newParticipant = new Participant(id, password, name);
        participants.add(newParticipant);
        admin.addParticipant(newParticipant);
    }

    private static void removeParticipant() {
        System.out.print("Enter participant ID to remove: ");
        int id = input.nextInt();
        admin.removeParticipant(id);
        participants.removeIf(part -> part.userID == id);
    }

    private static void showEventsByOrganizer() {
        System.out.print("Enter organizer ID: ");
        int id = input.nextInt();
        admin.showEventsByOrganizer(id);
    }

    private static void showEventsByParticipant() {
        System.out.print("Enter participant ID: ");
        int id = input.nextInt();
        admin.showEventsByParticipant(id);
    }

    private static void createEvent() {
        System.out.print("Enter event ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter event name: ");
        String name = input.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(input.nextLine());
        System.out.print("Enter event location: ");
        String location = input.nextLine();
        System.out.print("Enter event description: ");
        String description = input.nextLine();
        System.out.print("Enter event organizer name: ");
        String organizerName = input.nextLine();
        System.out.print("Enter max participants: ");
        int maxParticipants = input.nextInt();

        admin.createEvent(id, name, date, location, description, organizerName, maxParticipants);
        events.add(new Event(id, name, date, location, description, organizerName, maxParticipants));
    }

    private static void deleteEvent() {
        System.out.print("Enter event ID to delete: ");
        int id = input.nextInt();
        admin.deleteEvent(id);
        events.removeIf(event -> event.getEventID() == id);
    }

    private static void updateEvent() {
        System.out.print("Enter event ID to update: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter new event name: ");
        String name = input.nextLine();
        System.out.print("Enter new event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(input.nextLine());
        System.out.print("Enter new event location: ");
        String location = input.nextLine();
        System.out.print("Enter new event description: ");
        String description = input.nextLine();
        System.out.print("Enter new max participants: ");
        int maxParticipants = input.nextInt();

        admin.updateEvent(id, name, date, location, description, maxParticipants);
        for (Event event : events) {
            if (event.getEventID() == id) {
                event.updateEvent(name, date, location, description, maxParticipants);
                break;
            }
        }
    }

    private static void organizerMenu(Organizer organizer) {
        while (true) {
            System.out.println("************************************");
            System.out.println("*          Organizer Menu          *");
            System.out.println("************************************");
            System.out.println("*   1. Create Event                *");
            System.out.println("*   2. Update Event                *");
            System.out.println("*   3. Delete Event                *");
            System.out.println("*   4. View Participants           *");
            System.out.println("*   5. View My Events              *");
            System.out.println("*   6. Logout                      *");
            System.out.println("************************************");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    createEventForOrganizer(organizer);
                    break;
                case 2:
                    updateEventForOrganizer(organizer);
                    break;
                case 3:
                    deleteEventForOrganizer(organizer);
                    break;
                case 4:
                    viewParticipantsForOrganizer(organizer);
                    break;
                case 5:
                    organizer.viewMyEvents();
                    break;
                case 6:
                    organizer.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createEventForOrganizer(Organizer organizer) {
        System.out.print("Enter event ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter event name: ");
        String name = input.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(input.nextLine());
        System.out.print("Enter event location: ");
        String location = input.nextLine();
        System.out.print("Enter event description: ");
        String description = input.nextLine();
        System.out.print("Enter max participants: ");
        int maxParticipants = input.nextInt();

        organizer.createEvent(id, name, date, location, description, maxParticipants);
        events.add(new Event(id, name, date, location, description, organizer.name, maxParticipants));
    }

    private static void updateEventForOrganizer(Organizer organizer) {
        System.out.print("Enter event ID to update: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter new event name: ");
        String name = input.nextLine();
        System.out.print("Enter new event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(input.nextLine());
        System.out.print("Enter new event location: ");
        String location = input.nextLine();
        System.out.print("Enter new event description: ");
        String description = input.nextLine();
        System.out.print("Enter new max participants: ");
        int maxParticipants = input.nextInt();

        organizer.updateEvent(id, name, date, location, description, maxParticipants);
    }

    private static void deleteEventForOrganizer(Organizer organizer) {
        System.out.print("Enter event ID to delete: ");
        int id = input.nextInt();
        organizer.deleteEvent(id);
        events.removeIf(event -> event.getEventID() == id);
    }

    private static void viewParticipantsForOrganizer(Organizer organizer) {
        System.out.print("Enter event ID to view participants: ");
        int id = input.nextInt();
        organizer.viewParticipants(id);
    }

    private static void participantMenu(Participant participant) {
        while (true) {
            System.out.println("************************************");
            System.out.println("*         Participant Menu         *");
            System.out.println("************************************");
            System.out.println("*   1. View All Events             *");
            System.out.println("*   2. Register for Event          *");
            System.out.println("*   3. Cancel Registration         *");
            System.out.println("*   4. View Registered Events      *");
            System.out.println("*   5. Update Profile              *");
            System.out.println("*   6. Logout                      *");
            System.out.println("************************************");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    participant.viewAllEvents(events);
                    break;
                case 2:
                    registerForEvent(participant);
                    break;
                case 3:
                    cancelRegistration(participant);
                    break;
                case 4:
                    participant.viewRegisteredEvents();
                    break;
                case 5:
                    updateParticipantProfile(participant);
                    break;
                case 6:
                    participant.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerForEvent(Participant participant) {
        System.out.print("Enter event ID to register: ");
        int id = input.nextInt();
        for (Event event : events) {
            if (event.getEventID() == id) {
                participant.registerForEvent(event);
                return;
            }
        }
        System.out.println("Event not found.");
    }

    private static void cancelRegistration(Participant participant) {
        System.out.print("Enter event ID to cancel registration: ");
        int id = input.nextInt();
        for (Event event : events) {
            if (event.getEventID() == id) {
                participant.cancelRegistration(event);
                return;
            }
        }
        System.out.println("Event not found.");
    }

    private static void updateParticipantProfile(Participant participant) {
        System.out.print("Enter new name: ");
        String newName = input.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = input.nextLine();
        participant.updateProfile(newName, newPassword);
    }
}
