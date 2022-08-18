package Main;

import file_io.ContactList;
import jdk.swing.interop.SwingInterOpUtils;
import javax.swing.*;

public class BenToDo{

    public static void main(String[] args) {
        runOnStart();
    }
    public static String getContact(){
        String firstName = JOptionPane.showInputDialog("Please enter your First Name");
        String lastName = JOptionPane.showInputDialog("Please enter your Last Name");
        String phoneNumber = JOptionPane.showInputDialog("Please enter your Number");
        String showContact = (phoneNumber + " | \t\t\t " + firstName + " " + lastName);
        JOptionPane.showMessageDialog(null, showContact);
        return showContact;
    }
    private static void runOnStart(){
        ContactList contactList = new ContactList();
       String menu = JOptionPane.showInputDialog("""
                            1. View contacts
                            2. Add a new contact
                            3. Search a contact by name
                            4. Delete an existing contact
                            5. Exit""");
        switch (menu) {
            case "1" -> contactList.getAllContacts();
            case "2" -> getContact();
            case "3" -> search();
            case "4" -> System.out.println("Deleting all contacts");
            case "5" -> tbreak();
            default -> recur();
        }
    }
    private static void search(){
        ContactList contactList = new ContactList();
        String USER_INPUT = JOptionPane.showInputDialog("Search for Contact");
        contactList.getContactByName(USER_INPUT);
    }
    public static void tbreak() {
        System.out.println("exiting");
    }
    public static void recur(){
        System.out.println("I don't know have that Function?");
        JOptionPane.showMessageDialog(null, "I don't know have that Function?");
        runOnStart();
    }
}
/*

Load all of the contacts by calling a method that returns a List of Contact objects.
Call a method that shows the user the main menu and returns their choice of action.
Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of Contact objects if applicable).
Keep calling the method from step two until the user chooses to exit.
Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of Contact objects.
Bonus

Format the phone numbers using dashes:

instead of 8675309, your output should display 867-5309

Allow formatting phone numbers with different lengths. For example, phone numbers can have 10 or 7 digits. You can be even more creative here and allow international phone numbers.

Warn the user when she tries to enter a contact with an existing name.


There's already a contact named Jane Doe. Do you want to overwrite it? (Yes/No)
If the answer is No allow the user to enter the information again.

Format the output of the contacts, so that all of the columns have the same width.

Name       | Phone number |
---------------------------
Jack Blank | 210-567-8923 |
Jane Doe   | 789-8902     |
Sam Space  | 210-581-8123 |
Hint: you can use format strings with the System.our.printf or String.format methods to ensure the columns have the same width. */