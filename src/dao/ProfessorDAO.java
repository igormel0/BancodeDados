package dao;

import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO {
    public String inserirProfessor(Professor professor) {
        String sql = "INSERT INTO professor (cpfProfessor, nomeProfessor) VALUES (?, ?)";
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getCpfProfessor());
            stmt.setString(2, professor.getNomeProfessor());
            stmt.executeUpdate();
            return "Professor cadastrado com sucesso!";
        } catch (SQLException e) {
            return "Erro ao cadastrar professor.";
            //e.printStackTrace();
        }
    }

    public Professor buscarProfessor(String cpfProfessor) {
        String sql = "SELECT * FROM professor WHERE cpfProfessor = ?";
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpfProfessor);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Professor(rs.getString("cpfProfessor"), rs.getString("nomeProfessor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Professor> listarProfessores() {
        ArrayList<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professor";
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                professores.add(new Professor(rs.getString("cpfProfessor"), rs.getString("nomeProfessor")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public String atualizarProfessor(Professor professor) {
        String sql = "UPDATE professor SET nomeProfessor = ? WHERE cpfProfessor = ?";
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getNomeProfessor());
            stmt.setString(2, professor.getCpfProfessor());
            stmt.executeUpdate();
            return "Professor atualizado com sucesso!";
        } catch (SQLException e) {
            return "Erro ao atualizar professor.";
           // e.printStackTrace();
        }
    }

    public String deletarProfessor(String cpfProfessor) {
        String sql = "DELETE FROM professor WHERE cpfProfessor = ?";
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpfProfessor);
            stmt.executeUpdate();
            return "Professor removido com sucesso!";
        } catch (SQLException e) {
            return "Erro ao remover professor.";
           // e.printStackTrace();
        }
    }
}