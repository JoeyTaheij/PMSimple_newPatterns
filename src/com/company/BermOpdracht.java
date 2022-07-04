package com.company;

import java.time.LocalDate;

public class BermOpdracht extends Opdracht{
    public BermOpdracht(String title, String beschrijving, LocalDate deadline) {
        this.titel = title;
        this.beschrijving = beschrijving;
        this.deadline = deadline;
        this.type = "Berm";
    }

    @Override
    void addImage() { }

    @Override
    void addLocation() {
        System.out.println("Berm Location has been added!");
    }
}
