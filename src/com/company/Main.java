package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void mainMenu()
    {
        System.out.println("$$$$$$$$$$$$$$$$$$ DataBase by SmaQu $$$$$$$$$$$$$$$$$$");
        System.out.println("1. Przegląd danych.");
        System.out.println("2. Dopisanie nowego elementu.");
        System.out.println("3. Edycja danego elementu.");
        System.out.println("4. Wyszukanie danego elementu.");
        System.out.println("5. Sortowanie.");
        System.out.println("6. Zakończ i zapisz.");
    }

    public static void main(String[] args) throws IOException ,FileNotFoundException, InterruptedException {

        String choose="";
        int end =0;
        DataBase store =new DataBase();
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("");
            mainMenu();
            System.out.print("Twój wybór: ");
            choose=input.next();
            System.out.println("");
            switch(choose)
            {
                case "1":
                    store.readDatabase();
                    break;
                case "2":
                    store.writeEnityToDatabase();
                    break;
                case "3":
                    store.deleteOneFrame();
                    break;
                case "4":
                    store.searchFrame ();
                    break;
                case "5":
                    store.sortDatabase();
                    break;
                case "6":
                    store.endProgram();
                    System.out.println("---Program zostaje zakmniety, a dane zapisane.---");
                    end=Integer.valueOf(choose);
                    Thread.sleep(1000);
                    break;
                default:
                System.out.println("Wybierz coś z listy.");
                Thread.sleep(1000);
                    break;
            }
        }while(end!=6);

    }
}
