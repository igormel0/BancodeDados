package model;

public class Professor {
    private String cpfProfessor;
    private String nomeProfessor;

    public Professor(String cpfProfessor, String nameProfessor) {
        this.cpfProfessor = cpfProfessor;
        this.nomeProfessor = nameProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }
}