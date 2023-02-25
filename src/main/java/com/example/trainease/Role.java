package com.example.trainease;

public class Role {
    private int code_role;
    private String libelle;

    public Role() {
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }


    public int getCode_role() {
        return code_role;
    }

    public void setCode_role(int code_role) {
        this.code_role = code_role;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
