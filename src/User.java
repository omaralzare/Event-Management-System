public class User {
    protected String name;
    protected String loginStatus;  //to check if the login was from an admin or organ.. etc
    
    private int[] participantIdList = {224,113,223};
    private int[] organizerIdList = {244,112,233};
    private int[] adminIdList = {205,142};
    
    private String[] passwordList = {"224POA","113POA","POA205"};
    
    public void login(int id,String password){
        for(int i=0;i<3;i++){
            if(id == participantIdList[i] && password.equals(passwordList[i])){
                loginStatus="participant";
                return; }
            else if(id == organizerIdList[i] && password.equals(passwordList[i])){
                loginStatus="organizer";
                return; }
            else if(id == adminIdList[i] && password.equals(passwordList[i])){
                loginStatus="admin";
                return; }
        }
    }
    
    public void logout(){
        loginStatus=null;
    }
    
    public void updateProfile(String _name){
        this.name=_name;
    }
}