package com.company;

import java.time.LocalDate;

public class AfvalOpdracht extends Opdracht{
    public AfvalOpdracht(String title, String beschrijving, LocalDate deadline) {
        this.titel = title;
        this.beschrijving = beschrijving;
        this.deadline = deadline;
        this.type = "Afval";
    }

    @Override
    void addImage() {
        System.out.println("Afval Image has been added!");
    }

    @Override
    void addLocation() {
        System.out.println("Afval Location has been added!");
    }

    @Override
    boolean opdrachtWantsImage() {
        return true;
    }

    @Override
    boolean opdrachtIsUrgent() {
        return true;
    }
}
