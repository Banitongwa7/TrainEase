package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Participant;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    private Participant participant;
    private PreparedStatement ps;

    public boolean addParticipant(Participant participant) {
        String sql = "INSERT INTO participant (nom, prenom, date_naissance, code_profil) VALUES (?, ?, ?, ?)";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, participant.getNom());
            ps.setString(2, participant.getPrenom());
            ps.setString(3, participant.getDate_naissance());
            ps.setInt(4, participant.getCode_profil());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Participant getParticipant(int matricule_participant) {
        String sql = "SELECT * FROM participant WHERE matricule_participant = ?";
        participant = new Participant();
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, matricule_participant);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                participant.setMatricule_participant(rs.getInt("matricule_participant"));
                participant.setNom(rs.getString("nom"));
                participant.setPrenom(rs.getString("prenom"));
                participant.setDate_naissance(rs.getString("date_naissance"));
                participant.setCode_profil(rs.getInt("code_profil"));
            }else {
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return participant;
    }

    public Boolean deleteParticipant(int matricule_participant) {
        String sql = "DELETE FROM participant WHERE matricule_participant = ?";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, matricule_participant);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int updateParticipant(Participant participant) {
        String sql = "UPDATE participant SET nom = ?, prenom = ?, date_naissance = ?, code_profil = ? WHERE matricule_participant = ?";

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setString(1, participant.getNom());
            ps.setString(2, participant.getPrenom());
            ps.setString(3, participant.getDate_naissance());
            ps.setInt(4, participant.getCode_profil());
            ps.setInt(5, participant.getMatricule_participant());
            ps.executeUpdate();
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Participant> getAllParticipant() {
        String sql = "SELECT * FROM participant";
        List<Participant> participants = null;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            participants = new ArrayList<>();
            while (rs.next()) {
                Participant participant = new Participant();
                participant.setMatricule_participant(rs.getInt("matricule_participant"));
                participant.setNom(rs.getString("nom"));
                participant.setPrenom(rs.getString("prenom"));
                participant.setDate_naissance(rs.getString("date_naissance"));
                participant.setCode_profil(rs.getInt("code_profil"));
                participants.add(participant);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }

    public int getNbParticipant() {
        String sql = "SELECT COUNT(*) FROM participant";
        int nbParticipant = 0;
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nbParticipant = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return nbParticipant;
    }
}
