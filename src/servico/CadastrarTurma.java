package servico;

import aplicacao.Escola;
import entidades.Assuntos;
import entidades.CalendarioEscolar;
import entidades.Turma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CadastrarTurma {

    public void cadastrarTurma() {

        Scanner sc = new Scanner(System.in);
        CalendarioEscolar calendarioEscolar = new CalendarioEscolar();
        String novaTurma;

        System.out.println("-------------------------------------------");
        System.out.println("            1. Cadastrar turma             ");
        System.out.println("-------------------------------------------");

        LocalDate dataAtual = LocalDate.now();
        System.out.println("Ano Letivo: " + dataAtual.getYear());

        System.out.println("Início ano Letivo: " + calendarioEscolar.primeiroDiaLetivo() + "\nFim ano letivo: " + calendarioEscolar.ultimoDiaLetivo() + "\n");

        boolean valida;
        do {
            valida = false;
            System.out.print("Nome da Turma: ");
            novaTurma = sc.nextLine();

            for (int i = 0; i < Escola.turmaList.size(); i++) {

                if (novaTurma == Escola.turmaList.get(i).getNomeTurma()) {

                    System.out.println("Turma cadastrada!");
                    valida = true;

                } else {

                    valida = false;

                }
            }
        } while (valida);

        System.out.print("Quantidade de Alunos: ");
        Integer qtAlunos = sc.nextInt();


        int opcao;
        Assuntos assunto = null;
        List<Assuntos> assuntosList = new ArrayList<>();
        do {
            System.out.print("\nEscolha o Assunto da aula:\n" +
                    "1. JAVA\n" +
                    "2. JAVASCRIPT\n" +
                    "3. HTML\n" +
                    "4. CSS\n" +
                    "5. GIT\n" +
                    "6. SQL\n" +
                    "7. DOCKER\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

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

            assuntosList.add(assunto);

            System.out.print("Deseja cadastrar mais um Assunto? (s/n): ");
            char simOuNao = sc.next().charAt(0);

            if (simOuNao == 's') {
                opcao = 8;
            }

        } while (opcao > 7);

        Turma turma = new Turma(novaTurma, qtAlunos, assuntosList);
        Escola.turmaList.add(turma);

        System.out.println("-------------------------------------------");
        System.out.println("       Turma cadastrado com sucesso!       ");
        System.out.println("-------------------------------------------");
    }
}
