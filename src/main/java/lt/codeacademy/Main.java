package lt.codeacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Person> persons = new ArrayList<>();
    public static void main(String[] args) {
        Main main = new Main();
        Program program = new Program();
        Scanner scanner = new Scanner(System.in);
        program.fileReader();
        main.actions(scanner, program);
        program.fileWritter();




    }


    public void actions(Scanner scanner, Program program) {
        String action;

        do {
            menu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> program.registration(scanner);
                case "2" -> program.showPersons();
                case "3" -> System.out.println("Programa baigta");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("3"));


    }

    public void menu () {
        System.out.println("""
                MENU
                [1] Registruotis
                [2]Atspausdinti visus vartotojus
                [3] Uzdaryti programa
                """);
    }




}



