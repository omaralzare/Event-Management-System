import java.util.*;
import java.time.LocalDate;

class Event {
    private int eventID;
    private String eventName;
    private LocalDate eventDate;
    private String eventLocation;
    private String eventDescription;
    private String eventOrganizer;
    private int maxParticipants;
    private List<Participant> participants;

    public Event(int eventID, String eventName, LocalDate eventDate, String eventLocation,
            String eventDescription, String eventOrganizer, int maxParticipants) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventOrganizer = eventOrganizer;
        this.maxParticipants = maxParticipants;
        this.participants = new ArrayList<>();
    }

    public String getEventDetails() {
        return String.format(
                "Event ID: %d, Name: %s, Date: %s, Location: %s, Description: %s, Organizer: %s, Max Participants: %d, Current Participants: %d",
                eventID, eventName, eventDate, eventLocation, eventDescription, eventOrganizer, maxParticipants,
                participants.size());
    }

    public boolean addParticipant(Participant participant) {
        if (participants.size() < maxParticipants) {
            participants.add(participant);
            return true;
        }
        return false;
    }

    public boolean removeParticipant(Participant participant) {
        return participants.remove(participant);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int getEventID() {
        return eventID;
    }

    public void updateEvent(String eventName, LocalDate eventDate, String eventLocation,
            String eventDescription, int maxParticipants) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.maxParticipants = maxParticipants;
    }
}