package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private Role role;
    private PreparedStatement ps;

    public boolean addRole(Role role){
        String sql = "INSERT INTO role (libelle) VALUES (?)";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, role.getLibelle());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Role> getAllRoles(){
        String sql = "SELECT * FROM role";
        List<Role> roles = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            roles = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role();
                role.setCode_role(rs.getInt("code_role"));
                role.setLibelle(rs.getString("libelle"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    public boolean deleteRole(int code_role){
        String sql = "DELETE FROM role WHERE code_role = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_role);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Role getRole(int code_role){
        String sql = "SELECT * FROM role WHERE code_role = ?";
        role = new Role();
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_role);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role.setCode_role(rs.getInt("code_role"));
                role.setLibelle(rs.getString("libelle"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    public static void main(String[] args) {
        RoleDAO roleDAO = new RoleDAO();
        Role role = new Role();
        role.setLibelle("Administrateur");
        Boolean result = roleDAO.addRole(role);

        if(result) {
            System.out.println("Role ajouté");
        }else {
            System.out.println("Role non ajouté");
        }


    }

}
