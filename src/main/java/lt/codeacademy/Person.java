package lt.codeacademy;

public class Person {
    String name;
    String surname;
    String personalCode;

    public Person() {
    }

    public Person(String name, String surname, String personalCode) {
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }
}
