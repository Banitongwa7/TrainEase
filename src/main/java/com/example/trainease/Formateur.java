package com.example.trainease;

public class Formateur {
    private int code_formateur;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

    public Formateur() {

    }

    public Formateur(String nom, String prenom, String email, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }

    public int getCode_formateur() {
        return code_formateur;
    }

    public void setCode_formateur(int code_formateur) {
        this.code_formateur = code_formateur;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
