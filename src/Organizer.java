import java.util.*;
import java.time.LocalDate;

class Organizer extends User {
    private List<Event> eventList;

    public Organizer(int userID, String password, String name) {
        super(userID, password, name);
        this.eventList = new ArrayList<>();
    }

    public void createEvent(int eventID, String eventName, LocalDate eventDate, String eventLocation,
            String eventDescription, int maxParticipants) {
        Event newEvent = new Event(eventID, eventName, eventDate, eventLocation, eventDescription, this.name,
                maxParticipants);
        eventList.add(newEvent);
        System.out.println("Event created successfully: " + newEvent.getEventDetails());
    }

    public void updateEvent(int eventID, String eventName, LocalDate eventDate, String eventLocation,
            String eventDescription, int maxParticipants) {
        for (Event event : eventList) {
            if (event.getEventID() == eventID) {
                event.updateEvent(eventName, eventDate, eventLocation, eventDescription, maxParticipants);
                System.out.println("Event updated successfully: " + event.getEventDetails());
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void deleteEvent(int eventID) {
        eventList.removeIf(event -> event.getEventID() == eventID);
        System.out.println("Event deleted successfully.");
    }

    public void viewParticipants(int eventID) {
        for (Event event : eventList) {
            if (event.getEventID() == eventID) {
                System.out.println("Participants for event: " + event.getEventDetails());
                for (Participant participant : event.getParticipants()) {
                    System.out.println("User ID: " + participant.userID + ", Name: " + participant.name);
                }
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void viewMyEvents() {
        System.out.println("My Events:");
        for (Event event : eventList) {
            System.out.println(event.getEventDetails());
        }
    }
}
