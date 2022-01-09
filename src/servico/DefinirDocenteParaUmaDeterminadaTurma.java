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

        Integer idDocente = 0;
        Integer idDocente1 = 0;
        Integer idDocente2 = 0;
        Docentes docente = null;
        Docentes docente1 = null;
        Docentes docente2 = null;
        Turma turma = null;
        Integer idTurma = 0;

        System.out.println("\n3. Definir docentes para uma determinada turma\n");

        LocalDate dataAtual = LocalDate.now();
        System.out.println("Ano Letivo: " + dataAtual.getYear());

        System.out.println("Início das aulas: " + calendarioEscolar.primeiroDiaLetivo() + "\n");

        System.out.print("Escolha entre a Semana 1 e Semana 52: ");
        Integer nSemanas = sc.nextInt();

        System.out.print("Escolha o número de Docentes para a semana " + nSemanas + " : ");
        Integer nDocentes = sc.nextInt();

        calendarioEscolar.calendariosemanas(nSemanas);//Pega a semana de aula

        System.out.println("\nLista de Docentes cadastrados: ");

        for (Docentes list : Escola.docentesList) {

            System.out.println("ID: " + list.getId() + ", Nome: " + list.getNomeDocente());

        }

        if (nDocentes == 1) {

            System.out.print("\nDigite o ID do Docente: ");
            idDocente = sc.nextInt();

            for (Docentes docentes : Escola.docentesList) {

                if (docentes.getId() == idDocente1) docente = docentes;

            }

            System.out.println("\nLista de Turmas cadastrados: ");

            for (Turma list2 : Escola.turmaList) {

                System.out.println("ID: " + list2.getId() + ", Nome: " + list2.getNomeTurma());

            }

            System.out.print("\nDigite o ID da Turma: ");
            idTurma = sc.nextInt();

            for (Turma turmas : Escola.turmaList) {

                if (turmas.getId() == idTurma) turma = turmas;

            }

            //Add Docente para turma, add turma para docente
            docente.addTurma(turma);
            turma.addDocente(docente);

        } else if (nDocentes == 2) {

            System.out.print("\nDigite o ID do Docente, para aulas SEGUNDA, QUARTA e SEXTA: ");
            idDocente1 = sc.nextInt();

            System.out.print("Digite o ID do Docente, para aulas TERÇAS e QUINTAS: ");
            idDocente2 = sc.nextInt();

            for (Docentes docentes : Escola.docentesList) {

                if (docentes.getId() == idDocente1) docente1 = docentes;
                if (docentes.getId() == idDocente2) docente2 = docentes;

            }

            System.out.println("\nLista de Turmas cadastrados: ");

            for (Turma list2 : Escola.turmaList) {

                System.out.println("ID: " + list2.getId() + ", Nome: " + list2.getNomeTurma());

            }

            System.out.print("\nDigite o ID da Turma: ");
            idTurma = sc.nextInt();

            for (Turma turmas : Escola.turmaList) {

                if (turmas.getId() == idTurma) turma = turmas;

            }

            //Add Docente para turma, add turma para docente
            docente1.addTurma(turma);
            docente2.addTurma(turma);
            turma.addDocente(docente1);
            turma.addDocente(docente2);

        }


        /*
         * Aqui vai montar a agenda e gerar a lista String... boa noite!
         */
        System.out.println(calendarioEscolar.calendariosemanas(nSemanas));

    }

}
