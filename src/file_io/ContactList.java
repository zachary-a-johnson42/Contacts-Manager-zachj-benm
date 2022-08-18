package file_io;

import contacts.Contact;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ContactList {

    public Path contactDirectory = Paths.get("data");
    public Path contactListFile = Paths.get("data", "contacts.txt");

    // GET ALL FROM CONTACTS.TXT
    public void getAllContacts() {
        try {
            List<String> allContacts = Files.readAllLines(contactListFile);
            for(String contact : allContacts) {
                System.out.println(contact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // ADD NEW CONTACT TO CONTACTS.TXT
    public void addContact(Contact contact) {
        try {
            List<String> allContacts = Files.readAllLines(contactListFile);

            if(allContacts.contains(contact)) {
                return;
            }


            String[] contactInfo = new String[]{contact.getFirstName() + " " + contact.getLastName() + " : " + contact.getPhoneNumber()};


            Files.write(
                    contactListFile,
                    Arrays.asList(contactInfo),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // GET CONTACT BY NAME

    public void getContactByName(String name) {

        try {
            List<String> allContacts = Files.readAllLines(contactListFile);
            for (String contact: allContacts) {
                if(contact.toLowerCase().contains(name.toLowerCase())) {
                    JOptionPane.showMessageDialog(null, contact);
                    break;
                }else {
                    JOptionPane.showMessageDialog(null, "Cant find contact");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE CONTACT BY NAME

    public void deleteContactByName(String name) {

        try {
            List<String> allContacts = Files.readAllLines(contactListFile);
            for (String contact : allContacts) {
                if(contact.contains(name)) {
                    allContacts.remove(contact);
                }
            }

            Files.write(contactListFile,
                    allContacts
                    );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //STRETCH GOAL, UPDATE CONTACT BY NAME?
}