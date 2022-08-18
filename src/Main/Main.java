package Main;

import contacts.Contact;
import file_io.ContactList;

public class Main {
    public static void main(String[] args) {
        // TODO: SET UP MAIN MENU FOR USER SELECTIONS

        ContactList contactList = new ContactList();

        contactList.getAllContacts();

        contactList.deleteContactByName("Zach");

        contactList.getAllContacts();
        /*  1. View contacts.
            2. Add a new contact.
            3. Search a contact by name.
            4. Delete an existing contact.
            5. Exit.
            Enter an option (1, 2, 3, 4 or 5): */
        contactList.getAllContacts();

        // TODO : SWITCH STATEMENT FOR USER INPUT

            // LOGIC FOR EACH CHOICE

        // TODO : PROMPT TO CONTINUE OR QUIT

        /* */
    }
}
