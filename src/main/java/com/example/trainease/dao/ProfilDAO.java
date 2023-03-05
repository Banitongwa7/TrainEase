package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Profil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfilDAO {
    private Profil profil;
    private PreparedStatement ps;

    public boolean addProfil(Profil profil) {
        String sql = "INSERT INTO profil (libelle) VALUES (?)";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, profil.getLibelle());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Profil getProfil(int code_profil) {
        String sql = "SELECT * FROM profil WHERE code_profil = ?";
        profil = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_profil);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                profil.setCode_profil(rs.getInt("code_profil"));
                profil.setLibelle(rs.getString("libelle"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profil;
    }

    public List<Profil> getAllProfil() {
        String sql = "SELECT * FROM profil";
        List<Profil> profils = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            profils = new ArrayList<>();
            while (rs.next()) {
                Profil profil = new Profil();
                profil.setCode_profil(rs.getInt("code_profil"));
                profil.setLibelle(rs.getString("libelle"));
                profils.add(profil);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return profils;
    }

    public boolean deleteProfil(int code_profil) {
        String sql = "DELETE FROM profil WHERE code_profil = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_profil);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int updateProfil(Profil profil) {
        String sql = "UPDATE profil SET libelle = ? WHERE code_profil = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, profil.getLibelle());
            ps.setInt(2, profil.getCode_profil());
            ps.executeUpdate();
            return 1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
