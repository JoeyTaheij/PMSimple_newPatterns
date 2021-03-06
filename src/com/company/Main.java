package com.company;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean logedIn = false;
    static boolean exit = false;
    static Gebruiker activeGebruiker = null;

    public static void main(String[] args) {
//    ---------------------------------------------------------------------------------------------------------------------------
//                               Initialiseren van de Eerste opdrachtgever, aannemers en Opdrachten
//    ---------------------------------------------------------------------------------------------------------------------------

        init();

//    ---------------------------------------------------------------------------------------------------------------------------
//                                                           Code
//    ---------------------------------------------------------------------------------------------------------------------------

        login();
        menu();
    }

    public static void init() {
        Opdrachtgever dannyTaheij = new Opdrachtgever("Danny", "Danny", "0634225234", "test");
        Aannemer joeyTaheij = new Aannemer("Joey", "Joey", "0613234493", "test");
        Aannemer test = new Aannemer("test", "test", "0613234493", "test");
        GebruikerLijst.add(dannyTaheij);
        GebruikerLijst.add(joeyTaheij);
        GebruikerLijst.add(test);
        dannyTaheij.subscribe(joeyTaheij);
        dannyTaheij.subscribe(test);
        OpdrachtLijst.add(OpdrachtFactory.newOpdracht("Water", "Test1", "Test beschrijving 1", LocalDate.of(2022, 2, 15)));
        OpdrachtLijst.add(OpdrachtFactory.newOpdracht("Groen", "Test2", "Test beschrijving 2", LocalDate.of(2022, 2, 22)));
        OpdrachtLijst.add(OpdrachtFactory.newOpdracht("Afval", "Test3", "Test beschrijving 3", LocalDate.of(2022, 2, 23)));
        OpdrachtLijst.add(OpdrachtFactory.newOpdracht("Berm", "Test4", "Test beschrijving 4", LocalDate.of(2022, 2, 25)));

    }

    public static void login() {
        while (!logedIn) {
            System.out.println("|------------------------------------------|");
            System.out.println("|                  Login                   |");
            System.out.println("|------------------------------------------|");
            System.out.println("|E-mail:                                   |");
            String email = scanner.nextLine();
            System.out.println("|Password:                                 |");
            String password = scanner.nextLine();
            for (int i = 0; i < GebruikerLijst.getGebruikerLijst().size(); i++) {
                if (email.equals(GebruikerLijst.getGebruikerLijst().get(i).email)) {
                    if (password.equals(GebruikerLijst.getGebruikerLijst().get(i).wachtwoord)) {
                        logedIn = true;
                        activeGebruiker = GebruikerLijst.get(i);
                    } else {
                        System.out.println("|Password is incorrect                     |");
                    }
                }
            }
        }
    }
    public static void menu() {
        while (!exit) {
            System.out.println("|------------------------------------------|");
            System.out.println("               Welcome " + activeGebruiker.persoonsGegevens.getNaam());
            System.out.println("|------------------------------------------|");
            System.out.println("|Alle opdrachten:                          |");
            System.out.println("");
            activeGebruiker.getOpdrachtlijstString();
            System.out.println("|------------------------------------------|");
            System.out.println("|Kies uit ????n van de volgende opties:      |");
            System.out.println("|1. Opdracht markeren klaar voor controle  |");
            if (activeGebruiker.getRol().equals("Opdrachtgever")) {
                menuOpdrachtGever();
            } else {
                menuAannemer();
            }
        }
    }

    public static void menuOpdrachtGever() {
        System.out.println("|2. Opdracht afgerond                      |");
        System.out.println("|3. Nieuwe Opdracht aanmaken               |");
        System.out.println("|4. Opdracht verwijderen                   |");
        System.out.println("|5. Afsluiten                              |");
        System.out.println("|------------------------------------------|");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> menuOne();
            case 2 -> menuOpdrachtgeverTwo();
            case 3 -> menuOpdrachtgeverThree();
            case 4 -> menuOpdrachtgeverFour();
            case 5 -> menuExit();
        }
    }

    public static void menuAannemer() {
        System.out.println("|2. Afsluiten                              |");
        System.out.println("|------------------------------------------|");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> menuOne();
            case 2 -> menuExit();
        }
    }

    public static void menuExit() {
        exit = true;
    }

    public static void menuOne() {
        System.out.println("|------------------------------------------|");
        System.out.println("|       Opdracht klaar voor controle       |");
        System.out.println("|------------------------------------------|");
        System.out.println("|Opdracht nummer:                          |");
        int nummerKlaarVoorControle = scanner.nextInt();
        activeGebruiker.setKlaarVoorControle(nummerKlaarVoorControle);
    }
    public static void menuOpdrachtgeverTwo() {
        System.out.println("|------------------------------------------|");
        System.out.println("|             Opdracht afronden            |");
        System.out.println("|------------------------------------------|");
        System.out.println("|Opdracht nummer:                          |");
        int nummerAfgerond = scanner.nextInt();
        activeGebruiker.setAfgerond(nummerAfgerond);
    }
    public static void menuOpdrachtgeverThree() {
        System.out.println("|------------------------------------------|");
        System.out.println("|         Nieuwe Opdracht aanmaken         |");
        System.out.println("|------------------------------------------|");
        System.out.println("|Title :                                   |");
        String title = scanner.nextLine();
        System.out.println("|Beschrijving:                             |");
        String beschrijving = scanner.nextLine();
        System.out.println("|Deadline jaar:                            |");
        int year = scanner.nextInt();
        System.out.println("|Deadline maand:                           |");
        int month = scanner.nextInt();
        System.out.println("|Deadline dag:                             |");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate deadline = LocalDate.of(year, month, day);
        System.out.println("|Type (Water/Groen/Afval/Berm):            |");
        String type = scanner.nextLine();
        activeGebruiker.newOpdracht(type, title, beschrijving, deadline);
    }
    public static void menuOpdrachtgeverFour() {
        System.out.println("|------------------------------------------|");
        System.out.println("|           Opdracht verwijderen           |");
        System.out.println("|------------------------------------------|");
        System.out.println("|Opdracht nummer:                          |");
        int nummerVerwijderen = scanner.nextInt();
        scanner.nextLine();
        System.out.println("|------------------------------------------|");
        System.out.println("| Weet u zeker dat u opdracht " + nummerVerwijderen + " wilt verwijderen |");
        System.out.println("|------------------------------------------|");
        System.out.println("|Ja of Nee (y/n):                          |");
        String keuzen = scanner.nextLine();
        if (keuzen.equals("y") || keuzen.equals("Y")) {
            activeGebruiker.removeOpdracht(nummerVerwijderen);
        }
    }
}