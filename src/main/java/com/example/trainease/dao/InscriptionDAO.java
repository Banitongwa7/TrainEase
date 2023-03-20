package com.example.trainease.dao;

import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Formation;
import com.example.trainease.model.Inscription;
import com.example.trainease.model.Participant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InscriptionDAO {
    private Inscription inscription;
    private PreparedStatement ps;

    public int addInscription(Inscription inscription) {
        String sql = "INSERT INTO formation_participant (code_formation, matricule_participant) VALUES (?,?)";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, inscription.getCode_formation());
            ps.setInt(2, inscription.getMatricule_participant());
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Inscription getInscription(int code_formation, int matricule_participant) {
        String sql = "SELECT * FROM formation_participant WHERE code_formation = ? AND matricule_participant = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ps.setInt(2, matricule_participant);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.inscription = new Inscription(rs.getInt("code_formation"), rs.getInt("matricule_participant"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inscription;
    }

    public List<Inscription> getAllInscriptions() {
        String sql = "SELECT * FROM formation_participant";
        List<Inscription> inscriptions = new ArrayList<>();

        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                inscriptions.add(new Inscription(rs.getInt("code_formation"), rs.getInt("matricule_participant")));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return inscriptions;
    }

    public boolean deleteInscription(int code_formation, int matricule_participant) {
        String sql = "DELETE FROM formation_participant WHERE code_formation = ? AND matricule_participant = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ps.setInt(2, matricule_participant);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateInscriptions(Inscription inscription) {
        String sql = "UPDATE formation_participant SET code_formation = ?, matricule_participant = ? WHERE code_formation = ? AND matricule_participant = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, inscription.getCode_formation());
            ps.setInt(2, inscription.getMatricule_participant());
            ps.setInt(3, inscription.getCode_formation());
            ps.setInt(4, inscription.getMatricule_participant());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map<Integer, Inscription> getInscriptionsByFormation(int code_formation) {
        String sql = "SELECT * FROM formation_participant WHERE code_formation = ?";
        Map<Integer, Inscription> inscriptions = new HashMap<>();
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                inscriptions.put(rs.getInt("code_formation"), new Inscription(rs.getInt("code_formation"), rs.getInt("matricule_participant")));
            }

        }catch (Exception e) {

        }
        return inscriptions;
    }

    public List<Participant> getParticipantsByFormation(int code_formation) {
        String sql = "SELECT * FROM formation_participant WHERE code_formation = ?";
        List<Integer> idParticipant = new ArrayList<>();
        List<Participant> participants = new ArrayList<>();
        ParticipantDAO participantDAO = new ParticipantDAO();

        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idParticipant.add(rs.getInt("matricule_participant"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        for(int id : idParticipant) {
            Participant participant = participantDAO.getParticipant(id);
            participants.add(participant);
        }
        return participants;
    }

    public List<Formation> getFormationsByParticipant(int matricule_participant) {
        String sql = "SELECT * FROM formation_participant WHERE matricule_participant = ?";
        List<Integer> idFormation = new ArrayList<>();
        List<Formation> formations = new ArrayList<>();
        FormationDAO formationDAO = new FormationDAO();

        try{
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, matricule_participant);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idFormation.add(rs.getInt("code_formation"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        for(int id : idFormation) {
            Formation formation = formationDAO.getFormation(id);
            formations.add(formation);
        }
        return formations;
    }

    public int getNumberOfParticipantsByFormation(int code_formation) {
        String sql = "SELECT COUNT(*) FROM formation_participant WHERE code_formation = ?";
        try {
            ps = DatabaseConnect.getConnection().prepareStatement(sql);
            ps.setInt(1, code_formation);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
