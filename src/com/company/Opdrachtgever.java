package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

class Opdrachtgever extends Gebruiker {
    private final ArrayList<Subscriber> subscribers = new ArrayList<>();

    public Opdrachtgever(String naam, String email, String telefoon, String wachtwoord) {
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.persoonsGegevens = new PersoonsGegevens(naam, telefoon);
        this.rol = "Opdrachtgever";
    }

    public String toString() {
        return "Opdrachtgever{" +
                ", naam='" + persoonsGegevens.getNaam() + '\'' +
                ", email='" + email + '\'' +
                ", telefoon='" + persoonsGegevens.getTelefoon() + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                '}';
    }

//    ---------------------------------------------------------------------------------------------------------------------------
//                                               Opdrachtgever methodes
//    ---------------------------------------------------------------------------------------------------------------------------
    public void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    public void unSubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void notifyNieuweOpdracht(Opdracht opdracht) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(opdracht);
        }
    }

    public void newOpdracht(String type, String titel, String beschrijving, LocalDate deadline) {
        Opdracht newOpdracht = OpdrachtFactory.newOpdracht(type,titel,beschrijving,deadline);
        OpdrachtLijst.add(newOpdracht);
        notifyNieuweOpdracht(newOpdracht);
    }

    @Override
    public void update(Opdracht opdracht) {
        System.out.println("Not Allowed!");
    }

    public void setAfgerond(int opdracht) {
        if (OpdrachtLijst.get(opdracht) == null) {
            System.out.println("|Opdracht " + opdracht + " bestaat niet!");
        } else {
            OpdrachtLijst.get(opdracht).setState(new Afgerond());
        }
    }

    public void removeOpdracht(int opdracht) {
        if (OpdrachtLijst.get(opdracht) == null) {
            System.out.println("|Opdracht " + opdracht + " bestaat niet!");
        } else {
            OpdrachtLijst.getOpdrachtlijst().remove(opdracht);
        }
    }
}
