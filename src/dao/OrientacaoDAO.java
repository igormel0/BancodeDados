package dao;

import model.Orientacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class OrientacaoDAO {
    public String inserirOrientacao(Orientacao orientacao) {
        String sql = "INSERT INTO orientacao (professor_cpfProfessor, aluno_raAluno, disciplina) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, orientacao.getCpfProfessor());
            stmt.setInt(2, orientacao.getRaAluno());
            stmt.setString(3, orientacao.getDisciplina());
            stmt.executeUpdate();
            return "Orientação cadastrada com sucesso.";
        } catch (SQLIntegrityConstraintViolationException e) {
            return "Erro: Professor ou aluno não encontrado. Verifique os dados e tente novamente.";
        } catch (SQLException e) {
            return "Erro ao cadastrar orientação: " + e.getMessage();
        } catch (Exception e) {
            return "Erro inesperado ao cadastrar orientação: " + e.getMessage();
        }
    }

    public String listarOrientacoes() {
        StringBuilder resultado = new StringBuilder();
        String sql = "SELECT o.professor_cpfProfessor, p.nomeProfessor, " +
                     "o.aluno_raAluno, a.nomeAluno, o.disciplina " +
                     "FROM orientacao o " +
                     "JOIN professor p ON o.professor_cpfProfessor = p.cpfProfessor " +
                     "JOIN aluno a ON o.aluno_raAluno = a.raAluno";
        
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                resultado.append("CPF do Professor: ").append(rs.getString("professor_cpfProfessor")).append("\n")
                         .append("Nome do Professor: ").append(rs.getString("nomeProfessor")).append("\n")
                         .append("RA do Aluno: ").append(rs.getInt("aluno_raAluno")).append("\n")
                         .append("Nome do Aluno: ").append(rs.getString("nomeAluno")).append("\n")
                         .append("Disciplina: ").append(rs.getString("disciplina")).append("\n")
                         .append("-----------------------------------\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao recuperar orientações.";
        }
        
        return resultado.toString();
    }

    public String deletarOrientacao(String cpfProfessor, int raAluno) {
        String sql = "DELETE FROM orientacao WHERE professor_cpfProfessor = ? AND aluno_raAluno = ?";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpfProfessor);
            stmt.setInt(2, raAluno);
            stmt.executeUpdate();
            return "Orientação deletada com sucesso.";
        } catch (SQLException e) {
            return "Erro ao deletar orientação: " + e.getMessage();
        }
    }

    public String atualizarOrientacao(Orientacao orientacao) {
        String sql = "UPDATE orientacao SET disciplina = ? WHERE professor_cpfProfessor = ? AND aluno_raAluno = ?";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, orientacao.getDisciplina());
            stmt.setString(2, orientacao.getCpfProfessor());
            stmt.setInt(3, orientacao.getRaAluno());
            stmt.executeUpdate();
            return "Orientação atualizada com sucesso.";
        } catch (SQLException e) {
            return "Erro ao atualizar orientação: " + e.getMessage();
        }
    }
}