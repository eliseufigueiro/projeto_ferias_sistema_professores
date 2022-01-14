package servico;

import aplicacao.Escola;
import entidades.Docentes;
import entidades.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Historico {
    Scanner sc = new Scanner(System.in);

    public void listaTurmas() {

        System.out.println("\n4. Listar turmas com seus respectivos assuntos, docentes e semanas\n");

        for (Turma turmas : Escola.turmaList) {

            System.out.println("" +
                    "-----------------------[ TURMAS ]-----------------------\n" +
                    "  TURMA: " + turmas.getNomeTurma() + "          ID: " + turmas.getId() + "\n" +
                    "--------------------------------------------------------\n" +
                    "  QT. ALUNOS          : " + turmas.getQtAlunos() + "\n" +
                    "  ASSUNTOS            : " + turmas.getAssuntos() + "\n" +
                    "  DOCENTES            : " + turmas.getDocentes() + "\n" +
                    "  INÍCIO DAS AULAS    : " + turmas.getDataInicioDasAulas() + "\n" +
                    "  SEMANAS CADASTRADAS : " + turmas.getCalendario().getAgendaEscolar().size()
            );

            //Monta o calendário das semanas por número
            String semanaAtual[] = new String[52];
            for (int i = 0; i < 52; i++) {

                semanaAtual[i] = "X";

                if (!turmas.getCalendario().getAgendaEscolar().isEmpty()) {

                    for (List<List<String>> list : turmas.getCalendario().getAgendaEscolar()) {

                        if (i == Integer.parseInt(list.get(0).get(0))) {

                            semanaAtual[i - 1] = String.valueOf(Integer.parseInt(list.get(0).get(0)));

                        }

                    }

                }

            }

            for (int i = 0; i < 52; i++) {

                System.out.println("[" + semanaAtual[i] + "]");

            }

            for (List<List<String>> list : turmas.getCalendario().getAgendaEscolar()) {

                System.out.println("" +
                        "  SEMANA  : " + list.get(0).get(0) + "\n" +
                        "  SEGUNDA : " + list.get(4).get(0) + " | DOCENTE: " + list.get(2).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  TERÇA   : " + list.get(4).get(1) + " | DOCENTE: " + list.get(2).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  QUARTA  : " + list.get(4).get(2) + " | DOCENTE: " + list.get(3).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  QUINTA  : " + list.get(4).get(3) + " | DOCENTE: " + list.get(3).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  SEXTA   : " + list.get(4).get(4) + " | DOCENTE: " + list.get(3).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "--------------------------------------------------------\n");
            }

        }

    }

    public void listarDocentes() {

        System.out.println("\n5. Listar todos os docentes\n");

        for (Docentes docentes : Escola.docentesList) {

            System.out.println("" +
                    "------------------------------[ DOCENTES ]------------------------------\n" +
                    "  ID: " + docentes.getId() + "\n" +
                    "  DOCENTE: " + docentes.getNomeDocente() + "\n" +
                    "  CPF: " + docentes.getCpf() + "\n" +
                    "  TURMA: " + docentes.getTurmaAtual() + "\n" +
                    "------------------------------------------------------------------------\n"

            );

        }

    }

    public void listarDocenteESuasSemanas() {

        System.out.println("\n6. Listar um docente e suas semanas de aula já definidas");

        if (Escola.semanasList.isEmpty()) {

            System.out.println("\nLista vazia!");

        } else {

            System.out.println("\nLista de Docentes com Semanas cadastradas: \n");

            System.out.println("--------------------[ DOCENTES ]--------------------");
            for (List<List<String>> docentes : Escola.semanasList) {

                System.out.println("" +
                        "  ID: " + docentes.get(0) +
                        "  DOCENTE: " + docentes.get(2) +
                        "  TURMA: " + docentes.get(1)
                );

            }
            System.out.println("----------------------------------------------------");

            System.out.print("\nDigite o ID do Docente: ");
            Integer idDocente = sc.nextInt();

            Docentes docenteAtual = null;
            for (Docentes list : Escola.docentesList) {

                if (list.getId() == idDocente) {

                    docenteAtual = list;

                }

            }

            for (List<List<String>> semanasList : Escola.semanasList) {

                if (docenteAtual == null || semanasList.get(2).get(0) != docenteAtual.getNomeDocente()) {

                    System.out.println("Docente não tem semanas de aula cadastradas!");

                } else if (semanasList.get(2).get(0) == docenteAtual.getNomeDocente()) {

                    List<String> list = new ArrayList<>();
                    list.add(semanasList.get(0).get(0));
                    System.out.println("DOCENTES: " + semanasList.get(2).get(0) + " | SEMANA: " + list);

                }

            }


        }

    }

}

