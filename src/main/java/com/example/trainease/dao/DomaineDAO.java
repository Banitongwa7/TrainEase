package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Domaine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DomaineDAO {
    private Domaine domaine;
    private PreparedStatement ps;

    public int addDomaine(Domaine domaine) {
        String sql = "INSERT INTO domaine (libelle) VALUES (?)";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, domaine.getLibelle());
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Domaine getDomaine(int code_domaine) {
        String sql = "SELECT * FROM domaine WHERE code_domaine = ?";
        domaine = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_domaine);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                domaine.setCode_domaine(rs.getInt("code_domaine"));
                domaine.setLibelle(rs.getString("libelle"));
            }else {
                return null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return domaine;
    }

    public List<Domaine> getAllDomaine() {
        String sql = "SELECT * FROM domaine";
        List<Domaine> domaines = null;

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            domaines = new ArrayList<>();
            while (rs.next()) {
                Domaine domaine = new Domaine();
                domaine.setCode_domaine(rs.getInt("code_domaine"));
                domaine.setLibelle(rs.getString("libelle"));
                domaines.add(domaine);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return domaines;
    }

    public int updateDomaine(Domaine domaine) {
        String sql = "UPDATE domaine SET libelle = ? WHERE code_domaine = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, domaine.getLibelle());
            ps.setInt(2, domaine.getCode_domaine());
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteDomaine(int code_domaine) {
        String sql = "DELETE FROM domaine WHERE code_domaine = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_domaine);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
