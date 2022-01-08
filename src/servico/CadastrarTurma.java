package servico;

import aplicacao.Escola;
import entidades.Assuntos;
import entidades.Docentes;
import entidades.Turma;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CadastrarTurma {

    public void cadastrarTurma() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n1. Cadastrar turma");

        System.out.print("Nome da Turma: ");
        String novaTurma = sc.nextLine();

        System.out.print("Quantidade de Alunos: ");
        Integer qtAlunos = sc.nextInt();

        System.out.print("\nEscolha o Assunto da aula:\n" +
                "1. JAVA\n" +
                "2. JAVASCRIPT\n" +
                "3. HTML," +
                "4. CSS\n" +
                "5. GIT\n" +
                "6. SQL\n" +
                "7. DOCKER\n");
        int opcao = 0;
        do {
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            Assuntos assunto = null;
            switch (opcao) {
                case 1:
                    assunto = Assuntos.JAVA;
                    break;
                case 2:
                    assunto = Assuntos.JAVASCRIPT;
                    break;
                case 3:
                    assunto = Assuntos.HTML;
                    break;
                case 4:
                    assunto = Assuntos.CSS;
                    break;
                case 5:
                    assunto = Assuntos.GIT;
                    break;
                case 6:
                    assunto = Assuntos.SQL;
                    break;
                case 7:
                    assunto = Assuntos.DOCKER;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }

            Turma turma = new Turma(novaTurma, qtAlunos, Collections.singletonList(assunto));
            Escola.turmaList.add(turma);

        } while (opcao > 7);

        System.out.println("===========================================");
        System.out.println("Turma cadastrado com sucesso!");
        System.out.println("===========================================");
    }
}
