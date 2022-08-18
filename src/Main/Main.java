package Main;

import file_io.ContactList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO: SET UP MAIN MENU FOR USER SELECTIONS
        ContactList contacts = new ContactList();
        //Working as intender
        contacts.getAllContacts(contacts.contactsFilePath);

        //EXPECT 1 line
        contacts.getContactByName("Ben");
        /*  1. View contacts.
            2. Add a new contact.
            3. Search a contact by name.
            4. Delete an existing contact.
            5. Exit.
            Enter an option (1, 2, 3, 4 or 5): */

        // TODO : SWITCH STATEMENT FOR USER INPUT

            // LOGIC FOR EACH CHOICE

        // TODO : PROMPT TO CONTINUE OR QUIT

        /* */
    }
}
