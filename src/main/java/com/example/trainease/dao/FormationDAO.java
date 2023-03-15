package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Formation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormationDAO {
    private Formation formation;
    private PreparedStatement ps;

    public int addFormation(Formation formation) {
        String sql = "INSERT INTO formation (intitule,nombre_jours,annee,mois,nombre_participants,code_formateur,code_domaine) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, formation.getIntitule());
            ps.setInt(2, formation.getNombre_jours());
            ps.setInt(3, formation.getAnnee());
            ps.setInt(4, formation.getMois());
            ps.setInt(5, formation.getNombre_participants());
            ps.setInt(6, formation.getCode_formateur());
            ps.setInt(7, formation.getCode_domaine());
            ps.executeUpdate();
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteFormation(int code_formation) {
        String sql = "DELETE FROM formation WHERE code_formation = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int updateFormation(Formation formation) {
        String sql = "UPDATE formation SET intitule = ?, nombre_jours = ?, annee = ?, mois = ?, nombre_participants = ?, code_formateur = ?, code_domaine = ? WHERE code_formation = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, formation.getIntitule());
            ps.setInt(2, formation.getNombre_jours());
            ps.setInt(3, formation.getAnnee());
            ps.setInt(4, formation.getMois());
            ps.setInt(5, formation.getNombre_participants());
            ps.setInt(6, formation.getCode_formateur());
            ps.setInt(7, formation.getCode_domaine());
            ps.setInt(8, formation.getCode_formation());
            ps.executeUpdate();
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Formation getFormation(int code_formation) {
        String sql = "SELECT * FROM formation WHERE code_formation = ?";
        formation = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                formation.setCode_formation(rs.getInt("code_formation"));
                formation.setIntitule(rs.getString("intitule"));
                formation.setNombre_jours(rs.getInt("nombre_jours"));
                formation.setAnnee(rs.getInt("annee"));
                formation.setMois(rs.getInt("mois"));
                formation.setNombre_participants(rs.getInt("nombre_participants"));
                formation.setCode_formateur(rs.getInt("code_formateur"));
                formation.setCode_domaine(rs.getInt("code_domaine"));
            }else {
                return null;
            }
    }catch (SQLException e) {
            e.printStackTrace();
        }
        return formation;
    }

    public List<Formation> getAllFormation() {
        String sql = "SELECT * FROM formation";
        List<Formation> formations = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            formations = new ArrayList<>();
            while (rs.next()) {
                Formation formation = new Formation();
                formation.setCode_formation(rs.getInt("code_formation"));
                formation.setIntitule(rs.getString("intitule"));
                formation.setNombre_jours(rs.getInt("nombre_jours"));
                formation.setAnnee(rs.getInt("annee"));
                formation.setMois(rs.getInt("mois"));
                formation.setNombre_participants(rs.getInt("nombre_participants"));
                formation.setCode_formateur(rs.getInt("code_formateur"));
                formation.setCode_domaine(rs.getInt("code_domaine"));
                formations.add(formation);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return formations;
    }

    public int getNbFormation() {
        String sql = "SELECT COUNT(*) FROM formation";
        try {
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
