package file_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactList {
    //Set file path
    public String directory = "data";
    public String filename = "contacts.txt";

    public Path dataDirectoryPath = Paths.get(directory);
    public Path contactsFilePath = Paths.get(directory, filename);

    //If they don't exist, create.

    // GET ALL FROM CONTACTS.TXT
    public void getAllContacts(Path path) {
        try {
            List<String> allContacts = Files.readAllLines(path);
            for( String line : allContacts) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ADD NEW CONTACT TO CONTACTS.TXT



    // GET CONTACT BY NAME
    public void getContactByName(String name){
        try {
            List<String> allContacts = Files.readAllLines(contactsFilePath);
            for (String line : allContacts) {
                if (line.contains(name)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE CONTACT BY NAME



    //STRETCH GOAL, UPDATE CONTACT BY NAME?
}