import java.util.*;
public class Organizer extends User {
    protected ArrayList<Event> eventList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    class Event {
        private int eventID;
        private String eventName;
        private String eventDate;
        private String eventLocation;
        private String eventDescription;
    
        
        public Event(int eventID, String eventName, String eventDate, String eventLocation, String eventDescription) {
            this.eventID = eventID;
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.eventLocation = eventLocation;
            this.eventDescription = eventDescription;
        }
    
        
        @Override
        public String toString() {
            return "Event ID: " + eventID + ", Name: " + eventName + ", Date: " + eventDate +
                    ", Location: " + eventLocation + ", Description: " + eventDescription;
        }
    }
    public void addEvents() {
          
            int eventID = 1; 
            String continueAdding;

            do {
                System.out.println("Enter event name: ");
                String eventName = scanner.nextLine();

                System.out.println("Enter event date (YYYY-MM-DD): ");
                String eventDate = scanner.nextLine();

                System.out.println("Enter event location: ");
                String eventLocation = scanner.nextLine();

                System.out.println("Enter event description: ");
                String eventDescription = scanner.nextLine();

                
                Event newEvent = new Event(eventID, eventName, eventDate, eventLocation, eventDescription);
                eventList.add(newEvent);

                System.out.println("Event added successfully!");
                System.out.println(newEvent);

                eventID++; 

               
                System.out.println("Do you want to add another event? (yes/no): ");
                continueAdding = scanner.nextLine();

            } while (continueAdding.equalsIgnoreCase("yes"));
        
        System.out.println("Event creation completed. Here is the list of events:");
        displayEvents();
    }
    public void displayEvents() {
        for (Event event : eventList) {
            System.out.println(event);
        }
    }
    
    public void deleteEvents() {
       
        String continueDeleting;

        do {
            
            if (eventList.isEmpty()) {
                System.out.println("No events available to delete.");
                break;
            }

            System.out.println("Here are the current events:");
            displayEvents();

            System.out.println("Enter the Event ID to delete: ");
            int eventID = scanner.nextInt();
            scanner.nextLine(); 

            
            boolean eventFound = false;
            for (int i = 0; i < eventList.size(); i++) {
                if (eventList.get(i).toString().contains("Event ID: " + eventID)) {
                    eventList.remove(i);
                    eventFound = true;
                    System.out.println("Event with ID " + eventID + " has been deleted.");
                    break;
                }
            }

            if (!eventFound) {
                System.out.println("Event with ID " + eventID + " was not found.");
            }

            
            System.out.println("Do you want to delete another event? (yes/no): ");
            continueDeleting = scanner.nextLine();

        } while (continueDeleting.equalsIgnoreCase("yes"));

        System.out.println("Deletion process completed. Remaining events:");
        displayEvents();
    }

}


