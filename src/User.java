import java.util.ArrayList;
public class User {
    protected String currentName;
    protected char loginStatus;  //to check if the login was from an admin or organ.. etc
    
    private String[][] users={
        {"111", "pass123", "Participant"},
        {"333", "admin123", "Admin"}
    };

    protected ArrayList<String> organizerId = new ArrayList<>();
    protected ArrayList<String> organizerPass = new ArrayList<>();
    
    public User(){
        organizerId.add("222");
        organizerPass.add("organ123");
    }

    public void login(String id,String password){
        for (String[] user : users) {
            if(users[0][0].equals(id) && users[0][1].equals(password)){
                loginStatus='p';
                currentName="Participant";
            }
            else if(users[1][0].equals(id) && users[1][1].equals(password)){
                loginStatus='a';
                currentName="Admin";
            }

            for (int i=0;i<organizerId.size();i++) {
                if(organizerId.get(i).equals(id) && organizerPass.get(i).equals(password)){
                    loginStatus='o';
                    currentName="Organizer";
                }
                else 
                loginStatus=0;
            }
        }
    }
    
    public void logout(){
        loginStatus=0;
    }
    
    public void updateProfile(String _name){
        this.currentName=_name;
    }

    public char getLoginStatus(){
        return loginStatus;
    }
}