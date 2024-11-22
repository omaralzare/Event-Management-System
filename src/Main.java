import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
       Scanner input = new Scanner(System.in);
       User user1 = new User();
       
       String id;
       String password;
       
       System.out.print("\t**** Welcome To the Event orgnaizer programm ****\n\t--Please enter your ID and password\n");   //Missing Loop
       id = input.nextLine();
       password = input.nextLine();
          
       user1.login(id,password);
       
       char loginStatus=user1.getLoginStatus();
       
       switch(loginStatus){
           case 'p':
               System.out.println("\t**** participant menu ****");    //Missing Loop
               break;
           case 'o':
               System.out.println("\t**** organizer menu ****");  //Missing Loop
               break;
           case 'a':
               System.out.println("\t**** admin menu ****");  //Missing Loop
               break;
           default:
               System.out.println("\t**** The id or password you typed is incorrect. ****");
               break;
       }
       
       input.close();
    }
}
