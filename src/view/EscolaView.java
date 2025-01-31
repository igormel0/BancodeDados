package view;

import control.AlunoController;
import control.ProfessorController;
import control.OrientacaoController;
import model.Aluno;
import model.Professor;
import java.util.ArrayList;
import java.util.Scanner;

public class EscolaView {
    private static AlunoController alunoController = new AlunoController();
    private static ProfessorController professorController = new ProfessorController();
    private static OrientacaoController orientacaoController = new OrientacaoController();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Alterar Aluno");
            System.out.println("3 - Listar Alunos");
            System.out.println("4 - Remover Aluno");
            System.out.println("5 - Cadastrar Professor");
            System.out.println("6 - Alterar Professor");
            System.out.println("7 - Listar Professores");
            System.out.println("8 - Remover Professor");
            System.out.println("9 - Cadastrar Orientação");
            System.out.println("10 - Alterar Orientação");
            System.out.println("11 - Listar Orientações");
            System.out.println("12 - Remover Orientação");
            System.out.println("13 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    alterarAluno();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    cadastrarProfessor();
                    break;
                case 6:
                    alterarProfessor();
                    break;
                case 7:
                    listarProfessores();
                    break;
                case 8:
                    removerProfessor();
                    break;
                case 9:
                    cadastrarOrientacao();
                    break;
                case 10:
                    alterarOrientacao();
                case 11:
                    listarOrientacoes();
                    break;
                case 12:
                    removerOrientacao();
                    break;
                case 13:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarAluno() {
        System.out.print("RA do Aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        alunoController.adicionarAluno(ra, nome);
        System.out.println("Aluno cadastrado com sucesso!");
    }
    
    private static void alterarAluno() {
        System.out.print("RA do Aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        alunoController.atualizarAluno(ra, nome);
        System.out.println("Aluno alterado com sucesso!");
    }

    private static void removerAluno() {
        System.out.print("RA do Aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println(alunoController.deletarAluno(ra));

    }

    private static void listarAlunos() {
        ArrayList<Aluno> alunos = alunoController.listarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println("RA: " + aluno.getRaAluno() + ", Nome: " + aluno.getNomeAluno());
        }
    }

    private static void cadastrarProfessor() {
        System.out.print("CPF do Professor: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        professorController.adicionarProfessor(cpf, nome);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void alterarProfessor() {
        System.out.print("CPF do Professor: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        professorController.atualizarProfessor(cpf, nome);
        System.out.println("Professor alterado com sucesso!");
    }

    private static void removerProfessor() {
        System.out.print("CPF do Professor: ");
        String cpf = scanner.nextLine();

        System.out.println(professorController.deletarProfessor(cpf));
    }

    private static void listarProfessores() {
        ArrayList<Professor> professores = professorController.listarProfessores();
        for (Professor professor : professores) {
            System.out.println("CPF: " + professor.getCpfProfessor() + ", Nome: " + professor.getNomeProfessor());
        }
    }

    private static void cadastrarOrientacao() {
        System.out.print("CPF do Professor: ");
        String cpf = scanner.nextLine();
        System.out.print("RA do Aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();

        System.out.println(orientacaoController.adicionarOrientacao(cpf, ra, disciplina));
    }

    private static void alterarOrientacao() {
        System.out.print("CPF do Professor: ");
        String cpf = scanner.nextLine();
        System.out.print("RA do Aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();

        System.out.println(orientacaoController.atualizarOrientacao(cpf, ra, disciplina));       
    }

    private static void removerOrientacao() {
        System.out.print("CPF do Professor: ");
        String cpf = scanner.nextLine();
        System.out.print("RA do Aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println(orientacaoController.deletarOrientacao(cpf, ra));
    }

    private static void listarOrientacoes() {
        System.out.println(orientacaoController.listarOrientacoes());
        
    }
}