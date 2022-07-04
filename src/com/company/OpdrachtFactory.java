package com.company;

import java.time.LocalDate;

public class OpdrachtFactory {
    public static Opdracht newOpdracht(String type, String title, String beschrijving, LocalDate deadline) {
        switch (type) {
            case "Water":
                Opdracht opdracht = new WaterOpdracht(title, beschrijving, deadline);
                opdracht.makeOpdracht();
                return opdracht;
            case "Groen":
                opdracht = new GroenOpdracht(title, beschrijving, deadline);
                opdracht.makeOpdracht();
                return opdracht;
            case "Afval":
                opdracht = new AfvalOpdracht(title, beschrijving, deadline);
                opdracht.makeOpdracht();
                return opdracht;
            case "Berm":
                opdracht = new BermOpdracht(title, beschrijving, deadline);
                opdracht.makeOpdracht();
                return opdracht;
            default:
                return null;
        }
    }
}
