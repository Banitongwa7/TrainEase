package com.example.trainease.dao;

import com.example.trainease.model.Utilisateur;
import com.example.trainease.database.DatabaseConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {
    private Utilisateur user;
    private PreparedStatement ps;

    public boolean addUser(Utilisateur user){
        String sql = "INSERT INTO utilisateur (email, password, code_role) VALUES (?, ?, ?)";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getCode_role());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Utilisateur getUserForLogin() {
        String sql = "SELECT * FROM utilisateur WHERE email = ? AND password = ? ";
        user = new Utilisateur();
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setCode_utilisateur(rs.getInt("code_utilisateur"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCode_role(rs.getInt("code_role"));
            }else {
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
