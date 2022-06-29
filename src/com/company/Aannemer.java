package com.company;

import java.time.LocalDate;

class Aannemer extends Gebruiker implements Subscriber {

    public Aannemer(String naam, String email, String telefoon, String wachtwoord) {
        this.naam = naam;
        this.email = email;
        this.telefoon = telefoon;
        this.wachtwoord = wachtwoord;
        this.rol = "Aannemer";
    }

    public String toString() {
        return "Aannemer{" +
                ", naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", telefoon='" + telefoon + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                '}';
    }

//    ---------------------------------------------------------------------------------------------------------------------------
//                                               Aannemer methodes
//    ---------------------------------------------------------------------------------------------------------------------------

    @Override
    public void update(Opdracht opdracht) {
        System.out.println("Email naar " + email + ": Er is een opdracht aangemaakt met de titel: " + opdracht.getTitel());
    }

    @Override
    public void setAfgerond(int opdracht) {
        System.out.println("Not Allowed!");
    }

    @Override
    public void removeOpdracht(int opdracht) {
        System.out.println("Not Allowed!");
    }

    @Override
    public void newOpdracht(String type, String titel, String beschrijving, LocalDate deadline) {
        System.out.println("Not Allowed!");
    }
}
