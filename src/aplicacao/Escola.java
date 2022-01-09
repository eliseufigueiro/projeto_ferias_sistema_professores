package aplicacao;

import entidades.*;
import servico.CadastrarDocente;
import servico.CadastrarTurma;
import servico.DefinirDocenteParaUmaDeterminadaTurma;
import servico.Historico;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Escola {

    public static List<Turma> turmaList = new ArrayList<>();//DB Turmas
    public static List<Docentes> docentesList = new ArrayList<>();//DB Docentes
    public static List<String> semanasList = new ArrayList<>();//DB Semanas
    //public static List<Historico> historicoList = new ArrayList<>();//DB Historico

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);

        Escola escola = new Escola();
        escola.debug();

        int opcao = 0;
        do {
            escola.menu();

            System.out.print("Escolha um opção: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    CadastrarTurma cadastrarTurma = new CadastrarTurma();
                    cadastrarTurma.cadastrarTurma();
                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();
                    break;
                case 2:
                    CadastrarDocente cadastrarDocente = new CadastrarDocente();
                    cadastrarDocente.cadastrarDocente();
                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();
                    break;
                case 3:
                    DefinirDocenteParaUmaDeterminadaTurma definirDocenteParaUmaDeterminadaTurma = new DefinirDocenteParaUmaDeterminadaTurma();
                    definirDocenteParaUmaDeterminadaTurma.docenteToTurma();
                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();
                    break;
                case 4:
                    Historico historicoT = new Historico();
                    historicoT.listaTurmas();
                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();
                    break;
                case 5:
                    Historico historicoD = new Historico();
                    historicoD.listarDocentes();
                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();
                    break;
                case 6:
                    System.out.println();
                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");

            }

        } while (opcao != 0);

    }

    public void debug() {
        //Base de testes
        Turma turmaA = new Turma("A", 25, List.of(Assuntos.JAVA, Assuntos.SQL));
        turmaList.add(turmaA);
        Turma turmaB = new Turma("B", 23, List.of(Assuntos.SQL));
        turmaList.add(turmaB);
        Turma turmaC = new Turma("C", 28, List.of(Assuntos.JAVA, Assuntos.SQL, Assuntos.GIT));
        turmaList.add(turmaC);

        Docentes docentes1 = new Docentes("Bob", "123.654.987-78");
        Docentes docentes2 = new Docentes("Tom", "666.654.977-12");

        docentes1.addTurma(turmaA);// List.of add 1 ou mais obj em uma lista
        docentes1.addTurma(turmaB);

        docentesList.add(docentes1);
        docentesList.add(docentes2);

        System.out.println(docentes1.getTurmaAtual());

        System.out.println("======================================================");
        System.out.println("DEBUG\n");

        System.out.println("TURMAS TESTE");
        System.out.println(turmaList + "\n");

        System.out.println("DOCENTES TESTE");
        System.out.println(docentesList + "\n");

        System.out.println("TURMA TESTE PRIMEIRA DA LISTA");
        System.out.println(turmaList.get(0));

        System.out.println("TESTE ANO LETIVO");
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Ano Letivo: " + dataAtual.getYear() + "\n");

        System.out.println("TESTE DATA INICIO AULAS");
        System.out.println(turmaA.getDataInicioDasAulas() + "\n");

        System.out.println("TESTE CALENDARIO TODOS OS DIAS DO ANO");
        System.out.println(turmaA.getCalendario());
        System.out.println("======================================================");

    }//Para testes

    public void menu() {

        System.out.println("\n * SISTEMA GERENCIAMENTO DE PROFESSORES *\n\n" +
                "1. Cadastrar turma\n" +
                "2. Cadastrar docentes\n" +
                "3. Definir docentes para uma determinada turma\n" +
                "4. Listar turmas com seus respectivos assuntos, docentes e semanas\n" +
                "5. Listar todos os docentes\n" +
                "6. Listar um docente e suas semanas de aula já definidas\n" +
                "0. Sair\n");
    }//Menu principal

}
