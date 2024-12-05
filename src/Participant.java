import java.util.*;

class Participant extends User {
    private List<Event> registeredEvents;

    public Participant(int userID, String password, String name) {
        super(userID, password, name);
        this.registeredEvents = new ArrayList<>();
    }

    public boolean registerForEvent(Event event) {
        if (event.addParticipant(this)) {
            registeredEvents.add(event);
            System.out.println("Successfully registered for the event: " + event.getEventDetails());
            return true;
        }
        System.out.println("Failed to register for the event. It may be full.");
        return false;
    }

    public boolean cancelRegistration(Event event) {
        if (event.removeParticipant(this) && registeredEvents.remove(event)) {
            System.out.println("Successfully canceled registration for the event: " + event.getEventDetails());
            return true;
        }
        System.out.println("Failed to cancel registration. You may not be registered for this event.");
        return false;
    }

    public void viewRegisteredEvents() {
        System.out.println("Registered Events:");
        for (Event event : registeredEvents) {
            System.out.println(event.getEventDetails());
        }
    }
}