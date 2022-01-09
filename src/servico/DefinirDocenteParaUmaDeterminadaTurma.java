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
        Turma turma = new Turma();

        Integer idDocente = 0;
        Integer idDocente1 = 0;
        Integer idDocente2 = 0;
        Docentes docente = new Docentes();
        Docentes docente1 = new Docentes();
        Docentes docente2 = new Docentes();
        Integer idTurma = 0;

        System.out.println("\n3. Definir docentes para uma determinada turma\n");

        //Mostra no letivo e data inicio das aulas
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Ano Letivo: " + dataAtual.getYear());
        System.out.println("Início das aulas: " + calendarioEscolar.primeiroDiaLetivo());

        //Listas as turmas cadastradas e opção de escolha por ID
        System.out.println("\nLista de Turmas cadastrados: ");

        for (Turma list2 : Escola.turmaList) {

            System.out.println("ID: " + list2.getId() + ", Nome: " + list2.getNomeTurma());

        }

        System.out.print("\nDigite o ID da Turma: ");
        idTurma = sc.nextInt();

        for (Turma turmas : Escola.turmaList) {

            if (turmas.getId() == idTurma) turma = turmas;

        }

        /*
         * Montar calendario mostrando as semana livres e ocupadas
         *
         * */

        //Escolhe a semana para a turma
        System.out.print("Escolha entre a Semana 1 e Semana 52: ");
        Integer nSemanas = sc.nextInt();

        while (nSemanas == 52 || turma.getCalendario().calendarioSemanas(nSemanas).get(0) == null) {

            if (nSemanas == 52) {

                System.out.print("Semana de recesso escolar! Escolhar outra Semana: ");
                nSemanas = sc.nextInt();

            } else if (turma.getCalendario().calendarioSemanas(nSemanas).get(0) == null) {

                System.out.print("Já existe aulas agendadas para essa semana! Escolhar outra Semana: ");
                nSemanas = sc.nextInt();

            }

        }

        //Pega a semana de aula passada pela variavel nSemanas
        turma.getCalendario().calendarioSemanas(nSemanas);

        //Escolha de Docentes para a semana 1 ou 2 e divide por dias pares e impares
        System.out.print("Escolha o número de Docentes para a semana " + nSemanas + " : ");
        Integer nDocentes = sc.nextInt();

        System.out.println("\nLista de Docentes cadastrados: ");

        for (Docentes list : Escola.docentesList) {

            System.out.println("ID: " + list.getId() + ", Nome: " + list.getNomeDocente());

        }

        if (nDocentes == 1) {

            System.out.print("\nDigite o ID do Docente: ");
            idDocente = sc.nextInt();

            for (Docentes docentes : Escola.docentesList) {

                if (docentes.getId() == idDocente) docente = docentes;

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

            //Add Docente para turma, add turma para docente
            docente1.addTurma(turma);
            docente2.addTurma(turma);
            turma.addDocente(docente1);
            turma.addDocente(docente2);

        }

        /*
         * Aqui vai montar a agenda e gerar a lista String... boa noite!
         */

        //DEBUG
        System.out.println();
        turma.getCalendario().addAgendaEscolar(turma.getCalendario().calendarioSemanas(nSemanas));
        System.out.println(turma.getCalendario().getAgendaEscolar());//Imprime semana ecolhida

        turma.getCalendario().calendarioSemanasNull(nSemanas);//Seta null para a semana escolhida no calendario geral
        System.out.println(turma.getCalendario().calendarioSemanas(nSemanas));
        System.out.println();
        turma.getCalendario().printaCalendario();//Imprime calendario geral

    }

}
