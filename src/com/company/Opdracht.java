package com.company;

import java.time.LocalDate;

abstract class Opdracht {
    protected String titel;
    protected String beschrijving;
    protected LocalDate deadline;
    protected String type;
    protected State state = new Nieuw();

    public String toString(int position) {
        return "Opdracht: " + position + '\n' +
                "Type: " + type + '\n' +
                "Titel: " + titel + '\n' +
                "Beschrijving: " + beschrijving + '\n' +
                "Deadline: " + deadline.toString() + '\n' +
                "States: " + state.getState() + '\n';
    }

    final void makeOpdracht() {
        if (opdrachtWantsImage()) {
            addImage();
        }

        if (opdrachtWantsLocation()) {
            addLocation();
        }

        if (opdrachtIsUrgent()) {
            addUrgentie();
        }

        addOpdracht();
    }

    public String getBeschrijving() {
        return beschrijving;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public String getTitel() {
        return titel;
    }
    public State getState() {
        return state;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setType(String type) {
        this.type = type;
    }

    abstract void addImage();
    abstract void addLocation();
    public void addUrgentie() {
        System.out.println("Deze opdracht is urgent!!");
    }

    boolean opdrachtWantsImage() {return false;}
    boolean opdrachtWantsLocation() {return true;}
    boolean opdrachtIsUrgent() {return false;}

    public void addOpdracht() {
        System.out.println("De opdracht met titel: "+ titel +", is aangemaakt!");
    }
}

