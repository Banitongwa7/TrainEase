package com.example.trainease.model;

public class Inscription {
    private int code_formation;
    private int matricule_participant;

    public Inscription() {

    }

    public Inscription(int code_formation, int matricule_participant) {
        this.code_formation = code_formation;
        this.matricule_participant = matricule_participant;
    }

    public int getCode_formation() {
        return code_formation;
    }

    public void setCode_formation(int code_formation) {
        this.code_formation = code_formation;
    }

    public int getMatricule_participant() {
        return matricule_participant;
    }

    public void setMatricule_participant(int matricule_participant) {
        this.matricule_participant = matricule_participant;
    }
}
