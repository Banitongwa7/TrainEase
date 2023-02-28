package com.example.trainease.model;

public class Formation {
    private int code_formation;
    private String intitule;
    private int nombre_jours;
    private int annee;
    private int mois;
    private int nombre_participants;
    private int code_formateur;
    private int code_domaine;

    public Formation(){

    }

    public Formation(String intitule, int nombre_jours, int annee, int mois, int nombre_participants, int code_formateur, int code_domaine) {
        this.intitule = intitule;
        this.nombre_jours = nombre_jours;
        this.annee = annee;
        this.mois = mois;
        this.nombre_participants = nombre_participants;
        this.code_formateur = code_formateur;
        this.code_domaine = code_domaine;
    }

    public int getCode_formation() {
        return code_formation;
    }

    public void setCode_formation(int code_formation) {
        this.code_formation = code_formation;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNombre_jours() {
        return nombre_jours;
    }

    public void setNombre_jours(int nombre_jours) {
        this.nombre_jours = nombre_jours;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getNombre_participants() {
        return nombre_participants;
    }

    public void setNombre_participants(int nombre_participants) {
        this.nombre_participants = nombre_participants;
    }

    public int getCode_formateur() {
        return code_formateur;
    }

    public void setCode_formateur(int code_formateur) {
        this.code_formateur = code_formateur;
    }

    public int getCode_domaine() {
        return code_domaine;
    }

    public void setCode_domaine(int code_domaine) {
        this.code_domaine = code_domaine;
    }
}
