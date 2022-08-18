package Main;

import contacts.Contact;
import file_io.ContactList;
public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.getAllContacts();
        contactList.deleteContactByName("Zach");
        contactList.getAllContacts();
        contactList.getAllContacts();
    }
}