package com.example.trainease;

public class Utilisateur {
    private int code_utilisateur;
    private String email;
    private String password;
    private int code_role;

    public Utilisateur(){

    }

    public Utilisateur(String email, String password, int code_role) {
        this.email = email;
        this.password = password;
        this.code_role = code_role;
    }

    public int getCode_utilisateur() {
        return code_utilisateur;
    }

    public void setCode_utilisateur(int code_utilisateur) {
        this.code_utilisateur = code_utilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCode_role() {
        return code_role;
    }

    public void setCode_role(int code_role) {
        this.code_role = code_role;
    }
}
