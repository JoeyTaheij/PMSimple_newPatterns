package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//    ---------------------------------------------------------------------------------------------------------------------------
//                               Initialiseren van de Eerste opdrachtgever, aannemer en Opdrachten
//    ---------------------------------------------------------------------------------------------------------------------------

        Opdrachtgever opdrachtgever1 = new Opdrachtgever(1, "Danny", "test@test.nl", "0634225234", "WWOpdrachtgever");
        Aannemer aannemer1 = new Aannemer(1, "Joey", "test@test.nl", "0613234493", "WWAannemer");
        opdrachtgever1.newOpdracht(0, "opdracht 1", "test Opdracht 1", "2022-05-04");
        opdrachtgever1.newOpdracht(1, "opdracht 2", "test Opdracht 2", "2022-05-05");
        opdrachtgever1.newOpdracht(2, "opdracht 3", "test Opdracht 3", "2022-05-06");

//    ---------------------------------------------------------------------------------------------------------------------------
//                                                      Wat er mogelijk is
//    ---------------------------------------------------------------------------------------------------------------------------

        System.out.println("\nAannemer kan de Klaar voor controle variable naar true zetten");
        aannemer1.setKlaarVoorControle(0);
        System.out.println(aannemer1.getOpdracht(0));


        System.out.println("\nOpdrachtLijst Uitprinten vanuit een aannemer");
        aannemer1.printOpdrachtLijst();


        System.out.println("\nOpdrachtgever kan een nieuwe opdracht aanmaken");
        opdrachtgever1.newOpdracht(3, "opdracht 4", "test Opdracht 4", "2022-05-07");
        System.out.println(opdrachtgever1.getOpdracht(3));

        System.out.println("\nOpdrachtLijst Uitprinten vanuit een opdrachtgever");
        opdrachtgever1.printOpdrachtLijst();


        System.out.println("\nOpdrachtgever kan de afgerond variable naar true zetten");
        opdrachtgever1.setAfgerond(0);
        System.out.println(opdrachtgever1.getOpdracht(0));


        System.out.println("\nOpdrachtgever kan een opdracht aanroepen");
        System.out.println(opdrachtgever1.getOpdracht(0));

        System.out.println("\nOpdrachtgever kan een opdracht aanpassen");
        opdrachtgever1.getOpdracht(0).setTitel("Nieuwe titel");
        opdrachtgever1.getOpdracht(0).setBeschrijving("Nieuwe bescrijving");
        opdrachtgever1.getOpdracht(0).setDeadline("2022-06-07");
        System.out.println(opdrachtgever1.getOpdracht(0));
    }
}

abstract class Gebruiker {
    protected int id;
    protected String naam;
    protected String email;
    protected String telefoon;
    protected String wachtwoord;

    public int getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefoon() {
        return telefoon;
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

//    ---------------------------------------------------------------------------------------------------------------------------
//                                               Algemene gebruikers methodes
//    ---------------------------------------------------------------------------------------------------------------------------

    public Opdracht getOpdracht(int opdracht) {
        return OpdrachtLijst.get(opdracht);
    }

    public void printOpdrachtLijst() {
        for (int i = 0; i < OpdrachtLijst.getOpdrachtlijst().size(); i++) {
            System.out.println(OpdrachtLijst.get(i));
        }
    }
}

class Opdrachtgever extends Gebruiker {

    public Opdrachtgever(int id, String naam, String email, String telefoon, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.telefoon = telefoon;
        this.wachtwoord = wachtwoord;
    }

    public String toString() {
        return "Opdrachtgever{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", telefoon='" + telefoon + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                '}';
    }

//    ---------------------------------------------------------------------------------------------------------------------------
//                                               Opdrachtgever methodes
//    ---------------------------------------------------------------------------------------------------------------------------

    public void newOpdracht(int id, String titel, String beschrijving, String deadline) {
        OpdrachtLijst.add(new Opdracht(id,titel, beschrijving, deadline));
    }

    public void setAfgerond(int opdracht) {
        getOpdracht(opdracht).setAfgerond(true);
    }
}

class Aannemer extends Gebruiker {

    public Aannemer(int id, String naam, String email, String telefoon, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.telefoon = telefoon;
        this.wachtwoord = wachtwoord;
    }

    public String toString() {
        return "Aannemer{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", telefoon='" + telefoon + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                '}';
    }

//    ---------------------------------------------------------------------------------------------------------------------------
//                                               Aannemer methodes
//    ---------------------------------------------------------------------------------------------------------------------------

    public void setKlaarVoorControle(int opdracht) {
        getOpdracht(opdracht).setKlaarVoorControle(true);
    }
}

abstract class OpdrachtLijst {
    private static final ArrayList<Opdracht> opdrachtlijst = new ArrayList<Opdracht>();

    public static ArrayList<Opdracht> getOpdrachtlijst() {
        return opdrachtlijst;
    }

    public static void add(Opdracht opdracht) {
        opdrachtlijst.add(opdracht);
    }

    public static Opdracht get(int id) {
        return opdrachtlijst.get(id);
    }
}

class Opdracht extends OpdrachtLijst{
    private int id;
    private String titel;
    private String beschrijving;
    private String deadline;
    private Boolean klaarVoorControle = false;
    private Boolean afgerond = false;

    public Opdracht(int id, String titel, String beschrijving, String deadline) {
        this.id = id;
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.deadline = deadline;
    }

    public String toString() {
        return "Opdracht{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", deadline='" + deadline + '\'' +
                ", klaarVoorControle=" + klaarVoorControle +
                ", afgerond=" + afgerond +
                '}';
    }

    public int getId() {
        return id;
    }
    public Boolean getAfgerond() {
        return afgerond;
    }
    public Boolean getKlaarVoorControle() {
        return klaarVoorControle;
    }
    public String getBeschrijving() {
        return beschrijving;
    }
    public String getDeadline() {
        return deadline;
    }
    public String getTitel() {
        return titel;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAfgerond(Boolean afgerond) {
        this.afgerond = afgerond;
    }
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
    public void setKlaarVoorControle(Boolean klaarVoorControle) {
        this.klaarVoorControle = klaarVoorControle;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}