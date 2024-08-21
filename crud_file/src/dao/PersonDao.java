package dao;

import model.entities.Person;
import model.exceptions.FileDataError;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PersonDao {
    private File file;

    public PersonDao() {
        file = new File("dataPerson.ser");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                throw new FileDataError(exception.getMessage());
            }
        }
        else System.out.println("Arquivo já existe");
    }

    private Set<Person> getPerson() {
        if (file.length() > 0) {
            try(FileInputStream fileInputStream = new FileInputStream(file)) {

                //desserialização
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Set<Person> personSet = (Set<Person>) objectInputStream.readObject();

                return personSet;

            } catch (IOException | ClassNotFoundException exception) {
                throw new FileDataError(exception.getMessage());
            }

        } else return new HashSet<>();
    }

    public void showPersons() {
        Set<Person> personSet = getPerson();

        if (!personSet.isEmpty()) {
            personSet.forEach(System.out::println);
        }
        else {
            System.out.println("Arquivo vazio!");
        }
    }

    public boolean savePerson(Person person) {
        Set<Person> personSet = getPerson();
        if (personSet.add(person)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(this.file)) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(personSet);

                return true;
            } catch (IOException exception) {
                throw new FileDataError(exception.getMessage());
            }
        }
        return false;
    }

    public Person deleteByEmail(String email) {
        Set<Person> personSet = getPerson();

        if (personSet.isEmpty()) {
            return null;
        }

        Person personToDelete = personSet.stream().filter(item -> item.getEmail().equalsIgnoreCase(email)).toList().get(0);

        //removendo do set antes de salvar
        if (personSet.remove(personToDelete)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(personSet);

                return personToDelete;
            } catch (IOException exception) {
                throw new FileDataError(exception.getMessage());
            }
        }
        return null;
    }

    public String removelAll() {
        Set<Person> personSet = new HashSet<>();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personSet);

            return "Todas as pessoas do arquivo foram deletadas";
        } catch (IOException exception) {
            throw new FileDataError(exception.getMessage());
        }
    }
}
