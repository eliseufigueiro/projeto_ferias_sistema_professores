package aplicacao;

import entidades.*;
import servico.CadastrarDocente;
import servico.CadastrarTurma;
import servico.Historico;

import java.io.IOException;
import java.util.*;

public class Escola {

    public static List<Turma> turmaList = new ArrayList<>();//DB Turmas
    public static List<Docentes> docentesList = new ArrayList<>();//DB Docentes
    public static List<CalendarioEscolar> semanasList = new ArrayList<>();//DB Semanas
    public static List<Historico> historicoList = new ArrayList<>();//DB Historico

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
        List<Turma> list = new ArrayList<>();//DB

        //Base de testes
        Turma turmaA = new Turma("A", 25, List.of(Assuntos.JAVA, Assuntos.SQL));
        turmaList.add(turmaA);
        Turma turmaB = new Turma("B", 23, Collections.singletonList(Assuntos.SQL));
        turmaList.add(turmaB);

        //Teste retirar turma da LISTA GERAL e coloca na lista do docente
        List<Turma> turmaAtual = new ArrayList<>();
        for (Turma turmas : turmaList) {

            if (turmas == turmaB) {
                turmaAtual.add(turmaB);
            }
        }

        CalendarioEscolar calendarioEscolar = new CalendarioEscolar();

        Docentes docentes1 = new Docentes("Bob", "123.654.987-78");
        docentesList.add(docentes1);
        docentes1.setTurmaAtual(turmaAtual);

        System.out.println("======================================================");
        System.out.println("DEBUG");

        System.out.println(turmaList + "\n");
        System.out.println(docentes1 + "\n");
        System.out.println(docentesList + "\n");

        //System.out.println(calendarioEscolar.calendarioEscolar());
        System.out.println(turmaA.getDataInicioDasAulas());
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
