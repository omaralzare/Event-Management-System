public class User {
    protected String currentName;
    protected char loginStatus;  //to check if the login was from an admin or organ.. etc
    
    private String[][] users={
        {"111", "pass123", "Participant"},
        {"222", "org123", "Organizer"},
        {"333", "admin123", "Admin"}
    };
    
    public void login(String id,String password){
        for (String[] user : users) {
            if(users[0][0].equals(id) && users[0][1].equals(password)){
                loginStatus='p';
                currentName="Participant";
            }
            else if(users[1][0].equals(id) && users[1][1].equals(password)){
                loginStatus='o';
                currentName="Organizer";
            }
            else if(users[2][0].equals(id) && users[2][1].equals(password)){
                loginStatus='a';
                currentName="Admin";
            }
            else
                loginStatus=0;
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