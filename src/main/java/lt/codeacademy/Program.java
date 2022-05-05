package lt.codeacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    List<Person> persons = new ArrayList<>();
    File file = new File("persons.json");
    ObjectMapper mapper = new ObjectMapper();
    Person person;

    public void fileWritter() {
        try {
            mapper.writeValue(file, persons);
            System.out.println("Irasyta");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersons() {
        System.out.println("Registruoti vartotojai:");
        for(Person p : persons) {
            System.out.printf(" %s %s %s \n", p.getName(), p.getSurname(), p.getPersonalCode());
        }
    }

    public void registration(Scanner scanner) {
        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite savo pavarde");
        String surname = scanner.nextLine();
        System.out.println("Iveskite asmens koda");
        String personalCode = scanner.nextLine();

        Person person = new Person(name, surname, personalCode);
        if(persons.contains(person)) {
            System.out.println("Toks vartotojas egzistuoja");
        }

        if(!persons.contains(person)) {
            persons.add(new Person(name, surname, personalCode));
        }
    }

    public void fileReader() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(file.length() != 0) {
            try {
                persons = mapper.readValue(file, new TypeReference<>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
