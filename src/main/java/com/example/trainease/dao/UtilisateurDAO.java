package com.example.trainease.dao;

import com.example.trainease.model.Utilisateur;
import com.example.trainease.database.DatabaseConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    public Utilisateur getUserForLogin(String email, String password){
        String sql = "SELECT * FROM utilisateur WHERE email = ? AND password = ? ";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
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

    public List<Utilisateur> getAllUsers(){
        String sql = "SELECT * FROM utilisateur";
        List<Utilisateur> users = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            users = new ArrayList<>();
            while (rs.next()) {
                Utilisateur user = new Utilisateur();
                user.setCode_utilisateur(rs.getInt("code_utilisateur"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCode_role(rs.getInt("code_role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean deleteUser(int code_utilisateur){
        String sql = "DELETE FROM utilisateur WHERE code_utilisateur = ?";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_utilisateur);
            ps.executeUpdate();
            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Utilisateur getUser(int code_utilisateur){
        String sql = "SELECT * FROM utilisateur WHERE code_utilisateur = ?";
        user = new Utilisateur();
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_utilisateur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setCode_utilisateur(rs.getInt("code_utilisateur"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCode_role(rs.getInt("code_role"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int updateUser(Utilisateur user){
        String sql = "UPDATE utilisateur SET email = ?, password = ?, code_role = ? WHERE code_utilisateur = ?";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getCode_role());
            ps.setInt(4, user.getCode_utilisateur());
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
