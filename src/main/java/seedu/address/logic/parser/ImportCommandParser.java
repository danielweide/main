package seedu.address.logic.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.ImportCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.tag.Tag;

//@@author limshunyong
/**
 * Parses input arguments as file and adds the contact into the address book
 */
public class ImportCommandParser implements Parser<ImportCommand> {

    public static final String DEFAULT_NAME = "Example name";
    public static final String DEFAULT_ADD = "13 Computing Drive";
    public static final String DEFAULT_PHONE = "11111111";
    public static final String DEFAULT_EMAIL = "@example.com";
    public static final String DEFAULT_TAG = "containsDummy";

    /**
     * Parses the given {@code String} of arguments in the context of the Import command
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ImportCommand parse(String args) {
        String filename = args.trim();
        ArrayList<ReadOnlyPerson> p = new ArrayList<ReadOnlyPerson>();
        BufferedReader br = null;
        FileReader fr = null;


        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            // Create Default values
            String currLine;
            String name = null;
            String email = null;
            String address = null;
            String phone = null;
            Set<Tag> tagList = new HashSet<Tag>();

            while ((currLine = br.readLine()) != null) {

                if (currLine.contains("FN")) {
                    name = currLine.split(":")[1];
                }

                if (currLine.contains("TEL")) {
                    phone = currLine.split(":")[1];
                }

                if (currLine.contains("ADR")) {
                    address = currLine.split(";")[2];
                }

                if (currLine.contains("EMAIL")) {
                    email = currLine.split(":")[1];
                }

                if (currLine.contains("END")) {
                    try {
                        if (email == null) {
                            email = name.replaceAll("\\s+", "") + "@example.com";
                            tagList.add(new Tag(DEFAULT_TAG + "email"));
                        }
                        if (name == null) {
                            name = DEFAULT_NAME;
                            tagList.add(new Tag(DEFAULT_TAG + "name"));
                        }
                        if (phone == null) {
                            phone = DEFAULT_PHONE;
                            tagList.add(new Tag(DEFAULT_TAG + "phone"));
                        }
                        if (address == null) {
                            address = DEFAULT_ADD;
                            tagList.add(new Tag(DEFAULT_TAG + "address"));
                        }

                        Name n = new Name(name);
                        Phone pe = new Phone(phone);
                        Email e = new Email(email);
                        Address a = new Address(address);
                        ReadOnlyPerson person = new Person(n, pe, e, a, tagList);
                        p.add(person);

                    } catch (IllegalValueException ie) {
                        ie.getMessage();
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return new ImportCommand(p);
    }


}
