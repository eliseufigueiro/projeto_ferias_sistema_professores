package servico;

import aplicacao.Escola;
import entidades.CalendarioEscolar;
import entidades.Docentes;
import entidades.Turma;

import java.time.LocalDate;
import java.util.*;

public class DefinirDocenteParaUmaDeterminadaTurma {

    public void docenteToTurma() {
        Scanner sc = new Scanner(System.in);
        CalendarioEscolar calendarioEscolar = new CalendarioEscolar();

        System.out.println("\n3. Definir docentes para uma determinada turma\n");

        LocalDate dataAtual = LocalDate.now();
        System.out.println("Ano Letivo: " + dataAtual.getYear());

        System.out.println("Início das aulas: " + calendarioEscolar.primeiroDiaLetivo() + "\n");

        System.out.println("Lista de Docentes cadastrados: ");

        for (Docentes list : Escola.docentesList) {
            System.out.println("ID: " + list.getId() + ", Nome: " + list.getNomeDocente());
        }

        System.out.print("\nDigite o ID do Docente: ");
        Integer idDocente = sc.nextInt();

        System.out.println("\nLista de Turmas cadastrados: ");

        for (Turma list2 : Escola.turmaList) {
            System.out.println("ID: " + list2.getId() + ", Nome: " + list2.getNomeTurma());
        }

        System.out.print("\nDigite o ID da Turma: ");
        Integer idTurma = sc.nextInt();

        System.out.print("Escolha entre a Semana 1 e Semana 52: ");
        Integer nSemanas = sc.nextInt();

        System.out.println(calendarioEscolar.calendariosemanas(nSemanas));//Pega a semana de aula

        //Add Docente para turma, add turma para docente
        for (Docentes docentes : Escola.docentesList) {

            for (Turma turmas : Escola.turmaList) {

                if (docentes.getId() == idDocente && turmas.getId() == idTurma) {
                    docentes.addTurma(turmas);
                    turmas.addDocente(docentes);
                }

            }

        }

    }

}
