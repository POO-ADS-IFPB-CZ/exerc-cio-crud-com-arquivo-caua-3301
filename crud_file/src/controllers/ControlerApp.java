package controllers;

import dao.PersonDao;
import model.entities.Person;

import java.util.Scanner;

public class ControlerApp {
    private static Scanner sc = new Scanner(System.in);

    public static void readMenuOption() {

        PersonDao personDao = new PersonDao();

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 : personDao.showPersons();
                break;
            case 2 : {
                System.out.println("Informe o email da pessoa que deseja deletar: ");
                String email = sc.nextLine();

                Person person = personDao.deleteByEmail(email);

                System.out.printf("Pessoa deletada: %s \n", person == null ? "pessoa nao existe no arquivo" : person);
            }
                break;
            case 3 : {
                System.out.println("Infrome respectivamente o nome e o email da pessoa: ");
                String nome = sc.nextLine();
                String email = sc.nextLine();

                Person person = new Person(nome, email);

                personDao.savePerson(person);
            }
                break;
            case 4 :
                System.out.println(personDao.removelAll());
                break;
            default:
                System.out.println("Operacao invalida");
        }
    }

    public static char continueOperate() {
        System.out.println("Deseja executar algo mais? (s = sim, n = nao)");
        return sc.next().charAt(0);
    }
}
