package com.company;

import java.time.LocalDate;

public class WaterOpdracht extends Opdracht {
    public WaterOpdracht(String title, String beschrijving, LocalDate deadline) {
        this.titel = title;
        this.beschrijving = beschrijving;
        this.deadline = deadline;
        this.type = "Water";
    }

    @Override
    void addImage() {
        System.out.println("Water Image has been added!");
    }

    @Override
    void addLocation() {
        System.out.println("Water Location has been added!");
    }

    @Override
    boolean opdrachtWantsImage() {
        return true;
    }
}
