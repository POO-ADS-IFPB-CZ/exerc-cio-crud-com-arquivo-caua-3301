package model.util;

import controllers.ControlerApp;

public class Menu {
    public static void activateMenu() {
        char option = 's';
        while(option == 's') {
            System.out.println("====================================");
            System.out.println("\t\tCRUD COM ARQUIVOS");
            System.out.println("==================================== \n\n");

            System.out.println("Informe a operação desejada: ");
            System.out.println("1 - Visualizar pessoas cadastradas");
            System.out.println("2 - Deletar pessoa por email");
            System.out.println("3 - Adicionar uma nova pessoa");
            System.out.println("4 - Excluir todos");

            ControlerApp.readMenuOption();

            option = ControlerApp.continueOperate();
        }

        System.out.println("Programa encerrado");
    }

}
