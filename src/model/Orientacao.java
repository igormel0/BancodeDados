package model;

public class Orientacao {
    private String cpfProfessor;
    private int raAluno;
    private String disciplina;

    public Orientacao(String cpfProfessor, int raAluno, String disciplina) {
        this.cpfProfessor = cpfProfessor;
        this.raAluno = raAluno;
        this.disciplina = disciplina;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public int getRaAluno() {
        return raAluno;
    }

    public String getDisciplina() {
        return disciplina;
    }
}