import java.util.*;
import java.time.LocalDate;

class Admin extends User {
    private List<Organizer> organizers;
    private List<Participant> participants;
    private List<Event> allEvents;

    public Admin(int userID, String password, String name) {
        super(userID, password, name);
        this.organizers = new ArrayList<>();
        this.participants = new ArrayList<>();
        this.allEvents = new ArrayList<>();
    }

    public void addOrganizer(Organizer organizer) {
        organizers.add(organizer);
        System.out.println("Organizer added successfully.");
    }

    public void removeOrganizer(int organizerID) {
        organizers.removeIf(org -> org.userID == organizerID);
        System.out.println("Organizer removed successfully.");
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
        System.out.println("Participant added successfully.");
    }

    public void removeParticipant(int participantID) {
        participants.removeIf(part -> part.userID == participantID);
        System.out.println("Participant removed successfully.");
    }

    public void showEventsByOrganizer(int organizerID) {
        System.out.println("Events by Organizer (ID: " + organizerID + "):");
        for (Event event : allEvents) {
            if (event.getEventDetails().contains("Organizer: " + getOrganizerName(organizerID))) {
                System.out.println(event.getEventDetails());
            }
        }
    }

    public void showEventsByParticipant(int participantID) {
        System.out.println("Events for Participant (ID: " + participantID + "):");
        for (Event event : allEvents) {
            for (Participant participant : event.getParticipants()) {
                if (participant.userID == participantID) {
                    System.out.println(event.getEventDetails());
                    break;
                }
            }
        }
    }

    public void createEvent(int eventID, String eventName, LocalDate eventDate, String eventLocation,
            String eventDescription, String eventOrganizer, int maxParticipants) {
        Event newEvent = new Event(eventID, eventName, eventDate, eventLocation, eventDescription, eventOrganizer,
                maxParticipants);
        allEvents.add(newEvent);
        System.out.println("Event created successfully: " + newEvent.getEventDetails());
    }

    public void deleteEvent(int eventID) {
        allEvents.removeIf(event -> event.getEventID() == eventID);
        System.out.println("Event deleted successfully.");
    }

    public void updateEvent(int eventID, String eventName, LocalDate eventDate, String eventLocation,
            String eventDescription, int maxParticipants) {
        for (Event event : allEvents) {
            if (event.getEventID() == eventID) {
                event.updateEvent(eventName, eventDate, eventLocation, eventDescription, maxParticipants);
                System.out.println("Event updated successfully: " + event.getEventDetails());
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void viewReports() {
        System.out.println("Event Management System Report");
        System.out.println("Total Organizers: " + organizers.size());
        System.out.println("Total Participants: " + participants.size());
        System.out.println("Total Events: " + allEvents.size());

        System.out.println("\nEvents by Participant Count:");
        for (Event event : allEvents) {
            System.out.println(event.getEventDetails());
        }
    }

    private String getOrganizerName(int organizerID) {
        for (Organizer organizer : organizers) {
            if (organizer.userID == organizerID) {
                return organizer.name;
            }
        }
        return "Unknown";
    }
}