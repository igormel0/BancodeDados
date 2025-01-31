package control;

import dao.OrientacaoDAO;
import model.Orientacao;

public class OrientacaoController {
    private OrientacaoDAO orientacaoDAO = new OrientacaoDAO();

    public String adicionarOrientacao(String cpfProfessor, int raAluno, String disciplina){
    Orientacao orientacao = new Orientacao(cpfProfessor, raAluno, disciplina);    
        
        return orientacaoDAO.inserirOrientacao(orientacao);
    }

    public String listarOrientacoes() {
        return orientacaoDAO.listarOrientacoes();
    }

    public String deletarOrientacao(String cpfProfessor, int raAluno) {
        return orientacaoDAO.deletarOrientacao(cpfProfessor, raAluno);
    }

    public String atualizarOrientacao(String cpfProfessor, int raAluno, String disciplina) {
        Orientacao orientacao = new Orientacao(cpfProfessor, raAluno, disciplina);
        return orientacaoDAO.atualizarOrientacao(orientacao);
    }
}