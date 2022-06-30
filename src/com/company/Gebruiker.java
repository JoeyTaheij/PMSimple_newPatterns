package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

abstract class Gebruiker {
    protected String email;
    protected String wachtwoord;
    protected PersoonsGegevens persoonsGegevens;
    protected String rol;

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getNaam() {
        return persoonsGegevens.getNaam();
    }
    public String getEmail() {
        return email;
    }
    public String getTelefoon() {
        return persoonsGegevens.getTelefoon();
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNaam(String naam) {
        this.persoonsGegevens.setNaam(naam);
    }
    public void setTelefoon(String telefoon) {
        this.persoonsGegevens.setTelefoon(telefoon);
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

    public ArrayList<Opdracht> getOpdrachtLijst() {
        return OpdrachtLijst.getOpdrachtlijst();
    }

    public static void getOpdrachtlijstString() {
        for (int i = 0; i < OpdrachtLijst.getOpdrachtlijst().size(); i++) {
            System.out.println(OpdrachtLijst.getOpdrachtlijst().get(i).toString(i));
        }
    }

    public void setKlaarVoorControle(int opdracht) {
        if (opdracht < OpdrachtLijst.getOpdrachtlijst().size()) {
            OpdrachtLijst.get(opdracht).setState(new KlaarVoorControle());
        } else {
            System.out.println("");
            System.out.println("|Opdracht " + opdracht + " bestaat niet!                  |");
            System.out.println("");

        }
    }

    public abstract void update(Opdracht opdracht);
    public abstract void setAfgerond(int opdracht);
    public abstract void removeOpdracht(int opdracht);
    public abstract void newOpdracht(String type, String titel, String beschrijving, LocalDate deadline);
}


class PersoonsGegevens {
    String naam;
    String telefoon;

    public PersoonsGegevens(String naam, String telefoon) {
        this.naam = naam;
        this.telefoon = telefoon;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }
}