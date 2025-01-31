package control;

import dao.ProfessorDAO;
import model.Professor;

import java.util.ArrayList;

public class ProfessorController {
    private ProfessorDAO professorDAO = new ProfessorDAO();

    public String adicionarProfessor(String cpfProfessor, String nameProfessor) {
        Professor professor = new Professor(cpfProfessor, nameProfessor);
        return professorDAO.inserirProfessor(professor);
    }

    public Professor buscarProfessor(String cpfProfessor) {
        return professorDAO.buscarProfessor(cpfProfessor);
    }

    public ArrayList<Professor> listarProfessores() {
        return professorDAO.listarProfessores();
    }

    public void atualizarProfessor(String cpfProfessor, String nameProfessor) {
        Professor professor = new Professor(cpfProfessor, nameProfessor);
        professorDAO.atualizarProfessor(professor);
    }

    public String deletarProfessor(String cpfProfessor) {
        return professorDAO.deletarProfessor(cpfProfessor);
    }
}