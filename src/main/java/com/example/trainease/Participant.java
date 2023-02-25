package com.example.trainease;

import java.util.Date;

public class Participant {
    private int matricule_participant;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private int code_profil;

    public Participant(){

    }

    public Participant(String nom, String prenom, Date date_naissance, int code_profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.code_profil = code_profil;
    }


}
