package Main;

import contacts.Contact;
import file_io.ContactList;

import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        // Make Contact List
        ContactList contactList = new ContactList();

        //Checking for directory
        if(Files.notExists(contactList.contactDirectory)){
            try {
                Files.createDirectories(contactList.contactDirectory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //Checking for actual file
        if(Files.notExists(contactList.contactListFile)) {
            try {
                Files.createFile(contactList.contactListFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // Used for testing.
        contactList.getAllContacts();
        contactList.deleteContactByName("Zach");
        contactList.getAllContacts();
        contactList.getAllContacts();
    }
}