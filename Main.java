import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Contacts> contacts = new ArrayList<>();
    private static ArrayList<Messages> messages = new ArrayList<>();

    public static void main(String args[]){

        System.out.println("Hello sir Welcome! :) <3 :-)");
        Initoptions();
    }
    private static void Initoptions(){
        System.out.println("1 . Manage Contacts\n2 . Messages\n3 . Quit");
        int a = sc.nextInt();
        switch (a){
            case 1:
                Managecontact();
                break;
            case 2:
                Messages();
                break;
            case 3:
                break;
        }
    }
    private static void Managecontact(){
        boolean flag;
        System.out.println("1 . Show All Contacts\n2 . Add a new Contact\n3 . Search for a Contact\n4 . Delete a Contact\n5 . MENU");
        int a = sc.nextInt();
        switch (a){
            case 1:
                for(Contacts c : contacts){
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Name \t: "+c.getName());
                    System.out.println("Number \t: "+c.getNumber());
                    System.out.println("Mail \t: "+c.getMail());
                    System.out.println("-----------------------------------------------------------------------------------");
                }

                Managecontact();
                break;
            case 2:
                System.out.println("Enter the Name : ");
                String name  = sc.next();
                System.out.println("Enter the Number : ");
                String num = sc.next();
                System.out.println("Enter the Mail : ");
                String mail = sc.next();
                contacts.add(new Contacts(name, num, mail));
                Managecontact();
                break;
            case 3:
                flag = false;
                System.out.println("Enter the name : ");
                String ans = sc.next();
                for(Contacts c : contacts) {
                    if (Objects.equals(c.getName(), ans)) {
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Name \t: " + c.getName());
                        System.out.println("Number \t: " + c.getNumber());
                        System.out.println("Mail \t: " + c.getMail());
                        System.out.println("-----------------------------------------------------------------------------------");
                        flag = true;
                        break;
                    }
                    else {
                        flag = false;
                    }
                }
                if (flag==false){
                    System.out.println("There is no contact saved by this name.");
                }
                Managecontact();
                break;
            case 4:
                flag = false;
                System.out.println("Enter the name : ");
                String ans2 = sc.next();
                for(Contacts c : contacts) {
                    if (Objects.equals(c.getName(), ans2)) {
                        contacts.remove(c);
                        flag = true;
                        break;
                    }
                    else {
                        flag = false;
                    }
                }
                if (flag==false){
                    System.out.println("There is no contact saved by this name.");
                }
                Managecontact();
                break;
            case 5:
                Initoptions();
                break;
            default:
                System.out.println("Invalid input please enter correct value");
                Managecontact();
                break;
        }
    }

    private static void Messages(){
        boolean flag;
        System.out.println("1 . Send a new Message\n2 . See the list of all messages\n3 . MENU");
        int a  = sc.nextInt();
        switch (a){
            case 1:
                flag = false;
                System.out.println("Enter the name of the recipient : ");
                String name = sc.next();
                System.out.println("Body : ");
                sc.nextLine();
                String msg = sc.nextLine();
                for(Contacts c : contacts) {
                    if(Objects.equals(c.getName(),name)) {
                        messages.add(new Messages(c, msg, c.getName()));
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("no contact found by the given name.");
                }
                Messages();
                break;
            case 2:
                flag = false;
                System.out.println("Enter the name : ");
                String ans2 = sc.next();
                int i = 0;
                for(Messages m : messages) {
                    if (Objects.equals(m.getC().getName(), ans2)) {
                        i++;
                        msg = m.getText();
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println(i+"-> "+msg);
                        System.out.println("--------------------------------------------------------------------------------------");
                        flag = true;
                    }

                }
                if (flag==false){
                    System.out.println("There are no messages under this name.");
                }
                Messages();
                break;
            case 3:
                Initoptions();
                break;
            default:
                System.out.println("Invalid input please enter correct value");
                Messages();
                break;
        }
    }
}
