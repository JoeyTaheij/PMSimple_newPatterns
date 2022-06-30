package com.company;

import java.util.ArrayList;

public class OpdrachtLijst {
    private static final ArrayList<Opdracht> opdrachtlijst = new ArrayList<>();

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
