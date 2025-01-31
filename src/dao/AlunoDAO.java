package dao;

import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {
    public String inserirAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (raAluno, nomeAluno) VALUES (?, ?)";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getRaAluno());
            stmt.setString(2, aluno.getNomeAluno());
            stmt.executeUpdate();
            return "Aluno cadastrado com sucesso!";
        } catch (SQLException e) {
            return "Erro ao cadastrar aluno.";

        }
    }

    public Aluno buscarAluno(int raAluno) {
        String sql = "SELECT * FROM aluno WHERE raAluno = ?";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, raAluno);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluno(rs.getInt("raAluno"), rs.getString("nomeAluno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                alunos.add(new Aluno(rs.getInt("raAluno"), rs.getString("nomeAluno")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET nomeAluno = ? WHERE raAluno = ?";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNomeAluno());
            stmt.setInt(2, aluno.getRaAluno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String deletarAluno(int raAluno) {
        String sql = "DELETE FROM aluno WHERE raAluno = ?";
        try (Connection conn = ConexaoDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, raAluno);
            stmt.executeUpdate();
            return "Aluno removido com sucesso!";
        } catch (SQLException e) {
            return "Erro ao remover aluno.";
            //e.printStackTrace();
        }
    }
}