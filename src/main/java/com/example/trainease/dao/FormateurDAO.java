package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Formateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormateurDAO {
    private Formateur formateur;
    private PreparedStatement ps;

    public int addFormateur(Formateur formateur) {
        String sql = "INSERT INTO formateur (nom, prenom, code_formateur, email, telephone) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, formateur.getNom());
            ps.setString(2, formateur.getPrenom());
            ps.setInt(3, formateur.getCode_formateur());
            ps.setString(4, formateur.getEmail());
            ps.setString(5, formateur.getPhone());
            ps.executeUpdate();
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Formateur getFormateur(int code_formateur) {
        String sql = "SELECT * FROM formateur WHERE code_formateur = ?";
        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formateur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                formateur = new Formateur();
                formateur.setCode_formateur(rs.getInt("code_formateur"));
                formateur.setNom(rs.getString("nom"));
                formateur.setPrenom(rs.getString("prenom"));
                formateur.setCode_formateur(rs.getInt("code_formateur"));
                formateur.setEmail(rs.getString("email"));
                formateur.setPhone(rs.getString("telephone"));
            }else {
                return null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return formateur;
    }

    public boolean deleteFormateur(int code_formateur) {
        String sql = "DELETE FROM formateur WHERE code_formateur = ?";
        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formateur);
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateFormateur(Formateur formateur) {
        String sql = "UPDATE formateur SET nom = ?, prenom = ?, code_formateur = ?, email = ?, telephone = ? WHERE code_formateur = ?";
        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, formateur.getNom());
            ps.setString(2, formateur.getPrenom());
            ps.setInt(3, formateur.getCode_formateur());
            ps.setString(4, formateur.getEmail());
            ps.setString(5, formateur.getPhone());
            ps.setInt(6, formateur.getCode_formateur());
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Formateur> getAllFormateurs() {
        String sql = "SELECT * FROM formateur";
        List<Formateur> formateurs = null;
        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            formateurs = new ArrayList<>();
            while (rs.next()) {
                formateur = new Formateur();
                formateur.setCode_formateur(rs.getInt("code_formateur"));
                formateur.setNom(rs.getString("nom"));
                formateur.setPrenom(rs.getString("prenom"));
                formateur.setCode_formateur(rs.getInt("code_formateur"));
                formateur.setEmail(rs.getString("email"));
                formateur.setPhone(rs.getString("telephone"));
                formateurs.add(formateur);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return formateurs;
    }

    public int getNbFormateur() {
        String sql = "SELECT COUNT(*) FROM formateur";
        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
