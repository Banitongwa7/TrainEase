package com.example.trainease.model;

import java.lang.String;

public class Participant {
    private int matricule_participant;
    private String nom;
    private String prenom;
    private String date_naissance;
    private int code_profil;

    public Participant(){

    }

    public Participant(String nom, String prenom, String date_naissance, int code_profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.code_profil = code_profil;
    }

    public int getMatricule_participant() {
        return matricule_participant;
    }

    public void setMatricule_participant(int matricule_participant) {
        this.matricule_participant = matricule_participant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getCode_profil() {
        return code_profil;
    }

    public void setCode_profil(int code_profil) {
        this.code_profil = code_profil;
    }
}
