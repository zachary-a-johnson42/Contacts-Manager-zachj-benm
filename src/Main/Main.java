package Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;


public class Main {
    //    public static Path contactDirectory = Paths.get("data");
//    public static Path contactListFile = Paths.get("data", "contacts.txt");
    public static Path file = Paths.get("contacts.txt");

    public static void main(String[] args) {
    
        CreateFile();
        runOnStart();
    }
    public static void CreateFile() {
        try {
            File contacts = new File("contacts.txt");
            if (contacts.createNewFile()) {
                System.out.println("File created: " + contacts.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void runOnStart(){
        String menu = JOptionPane.showInputDialog("""
                            1. View contacts
                            2. Add a new contact
                            3. Search a contact by name
                            4. Delete an existing contact
                            5. Exit""");
        switch (menu) {
            case "1" -> getAllContacts();
            case "2" -> createContact();
            case "3" -> search();
            case "4" -> deleteContactByName();
            case "5" -> exit();
            default -> recur();
        }
    }
    public static void getAllContacts() {
        try {
            List<String> allContacts = Files.readAllLines(file);
            String x = "";
            for(String contact : allContacts) {
                x = x + contact + "\n";
                System.out.println(contact);
            }
            JOptionPane.showMessageDialog(null, "___Phone___ |___Name _________\n" + x);
            runOnStart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createContact(){
        String firstName = JOptionPane.showInputDialog("Please enter your First Name");
        String lastName = JOptionPane.showInputDialog("Please enter your Last Name");
        String phoneNumber = JOptionPane.showInputDialog("Please enter your Number");
        String showContact = (phoneNumber + " |\t " + firstName + " " + lastName);
        JOptionPane.showMessageDialog(null, showContact);
        addContact(showContact);
    }
    public static void addContact(String contact) {
        try {
            List<String> allContacts = Files.readAllLines(file);
            if(allContacts.contains(contact)) {
                return;
            }
            String[] contactInfo = new String[]{contact};
            Files.write(
                    file,
                    Arrays.asList(contactInfo),
                    StandardOpenOption.APPEND
            );
            getAllContacts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void search(){
        String USER_INPUT = JOptionPane.showInputDialog("Search for Contact");
        try {
            List<String> allContacts = Files.readAllLines(file);
            for (String contact: allContacts) {
                if(contact.toLowerCase().contains(USER_INPUT.toLowerCase())) {
                    JOptionPane.showMessageDialog(null, contact);
                    break;
                }else {
                    JOptionPane.showMessageDialog(null, "Cant find contact");
                    break;
                }
            }
            runOnStart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteContactByName() {
        String name = JOptionPane.showInputDialog("What contact do you want to delete");
        try {
            List<String> allContacts = Files.readAllLines(file);
            allContacts.removeIf(contact -> contact.contains(name));
            Files.write(file,
                    allContacts
            );
            getAllContacts();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void exit() {
        System.out.println("exiting");
    }
    public static void recur(){
        JOptionPane.showMessageDialog(null, "I don't know have that Function?");
        runOnStart();
    } 
}
