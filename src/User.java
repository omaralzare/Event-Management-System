import java.util.*;

class User {
    protected int userID;
    protected String password;
    protected String name;
    protected boolean loginStatus;

    public User(int userID, String password, String name) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.loginStatus = false;
    }

    public boolean login(String password) {
        if (this.password.equals(password)) {
            loginStatus = true;
            System.out.println("Login successful.");
            return true;
        }
        System.out.println("Login failed. Incorrect password.");
        return false;
    }

    public void logout() {
        loginStatus = false;
        System.out.println("Logged out successfully.");
    }

    public void updateProfile(String newName, String newPassword) {
        this.name = newName;
        this.password = newPassword;
        System.out.println("Profile updated successfully.");
    }

    public void viewAllEvents(List<Event> events) {
        System.out.println("All Events:");
        for (Event event : events) {
            System.out.println(event.getEventDetails());
        }
    }

    public void myProfile() {
        System.out.println("User Profile:");
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Login Status: " + (loginStatus ? "Logged In" : "Logged Out"));
    }
}