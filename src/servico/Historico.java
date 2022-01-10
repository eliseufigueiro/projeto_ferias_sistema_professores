package servico;

import aplicacao.Escola;
import entidades.Docentes;
import entidades.Turma;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    public void listaTurmas() {
        System.out.println("\n4. Listar turmas com seus respectivos assuntos, docentes e semanas");

        for (Turma turmas : Escola.turmaList) {

            System.out.println("" +
                    "-----------------------------------------------------------------------------------\n" +
                    "  TURMA: " + turmas.getNomeTurma() + "          ID: " + turmas.getId() + "\n" +
                    "-----------------------------------------------------------------------------------\n" +
                    "  QT. ALUNOS          : " + turmas.getQtAlunos() + "\n" +
                    "  ASSUNTOS            : " + turmas.getAssuntos() + "\n" +
                    "  DOCENTES            : " + turmas.getDocentes() + "\n" +
                    "  INÍCIO DAS AULAS    : " + turmas.getDataInicioDasAulas() + "\n" +
                    "  SEMANAS CADASTRADAS : " + turmas.getCalendario().getAgendaEscolar().size() + "\n" +
                    ""
            );

            for (List<List<String>> list : turmas.getCalendario().getAgendaEscolar()) {

                System.out.println("" +
                        "  SEMANA  : " + list.get(0).get(0) + "\n" +
                        "  SEGUNDA : " + list.get(4).get(0) + " | DOCENTE: " + list.get(2).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  TERÇA   : " + list.get(4).get(1) + " | DOCENTE: " + list.get(2).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  QUARTA  : " + list.get(4).get(2) + " | DOCENTE: " + list.get(3).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  QUINTA  : " + list.get(4).get(3) + " | DOCENTE: " + list.get(3).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        "  SEXTA   : " + list.get(4).get(4) + " | DOCENTE: " + list.get(3).get(0) + " | ASSUNTO: " + list.get(5) + "\n" +
                        " ");
            }

            System.out.println("-----------------------------------------------------------------------------------\n");
        }

    }

    public void listarDocentes() {

        System.out.println("\n5. Listar todos os docentes");
        System.out.println(Escola.docentesList);
    }

}
