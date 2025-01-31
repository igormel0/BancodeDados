package model;

public class Aluno {
    private int raAluno;
    private String nomeAluno;

    public Aluno(int raAluno, String nameAluno) {
        this.raAluno = raAluno;
        this.nomeAluno = nameAluno;
    }

    public int getRaAluno() {
        return raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }
}