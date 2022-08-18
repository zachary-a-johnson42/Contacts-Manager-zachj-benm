package file_io;

import contacts.Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactList {

    public Path contactDirectory = Paths.get("data");
    public Path contactListFile = Paths.get("data", "contacts.txt");

    // GET ALL FROM CONTACTS.TXT
    public void getAllContacts(Path path) {
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
//    public void addContact(Path path, Contact contact) {
//        try {
//            List<String> allContacts = Files.readAllLines(contactListFile);
//            if(allContacts.contains(contact)) {
//                return;
//            }Files.write(path, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    // GET CONTACT BY NAME

    // DELETE CONTACT BY NAME

    //STRETCH GOAL, UPDATE CONTACT BY NAME?
}