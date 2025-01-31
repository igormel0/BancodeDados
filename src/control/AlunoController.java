package control;

import dao.AlunoDAO;
import model.Aluno;

import java.util.ArrayList;

public class AlunoController {
    private AlunoDAO alunoDAO = new AlunoDAO();

    public String adicionarAluno(int raAluno, String nameAluno) {
        Aluno aluno = new Aluno(raAluno, nameAluno);
        return alunoDAO.inserirAluno(aluno);
    }

    public Aluno buscarAluno(int raAluno) {
        return alunoDAO.buscarAluno(raAluno);
    }

    public ArrayList<Aluno> listarAlunos() {
        return alunoDAO.listarAlunos();
    }

    public void atualizarAluno(int raAluno, String nameAluno) {
        Aluno aluno = new Aluno(raAluno, nameAluno);
        alunoDAO.atualizarAluno(aluno);
    }

    public String deletarAluno(int raAluno) {
       return alunoDAO.deletarAluno(raAluno);
    }
}