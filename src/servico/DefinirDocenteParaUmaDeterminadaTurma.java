package servico;

import aplicacao.Escola;
import entidades.Assuntos;
import entidades.CalendarioEscolar;
import entidades.Docentes;
import entidades.Turma;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class DefinirDocenteParaUmaDeterminadaTurma {

    public void docenteToTurma() throws IOException {
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
        Integer idAssunto;

        System.out.println("\n3. Definir docentes para uma determinada turma\n");

        //Mostra no letivo e data inicio das aulas
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Ano Letivo: " + dataAtual.getYear());
        System.out.println("Início das aulas: " + calendarioEscolar.primeiroDiaLetivo());

        int opcao = 0;
        do {
            System.out.println("\n" +
                    "1. Cadastrar Docente para Turma" + "\n" +
                    "2. Cadastrar Docente para Semana de Aula" +  "\n" +
                    "0. Voltar\n");

            System.out.print("Escolha um opção: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    //Listas as Docentes cadastrados e opção de escolha por ID
                    System.out.println("\nLista de Docentes cadastrados: ");

                    for (Docentes list : Escola.docentesList) {

                        System.out.println("ID: " + list.getId() + ", Nome: " + list.getNomeDocente());

                    }

                    System.out.print("\nDigite o ID do Docente: ");
                    idDocente = sc.nextInt();

                    for (Docentes docentes : Escola.docentesList) {

                        if (docentes.getId() == idDocente) docente = docentes;

                    }

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

                    //Add Docente para turma, add turma para docente
                    docente.addTurma(turma);
                    turma.addDocente(docente);

                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();

                    break;

                case 2:
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

                    System.out.println("\nLista de Assuntos cadastrados: ");

                    Integer n = 1;
                    for (int i = 0; i < turma.getAssuntos().size(); i++) {

                        System.out.println(n++ + ". " + turma.getAssuntos().get(i));

                    }

                    System.out.print("\nEscolha o Assunto para essa semana: ");
                    idAssunto = sc.nextInt();


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

                    for (Docentes list : turma.getDocentes()) {

                        System.out.println("ID: " + list.getId() + ", Nome: " + list.getNomeDocente());

                    }

                    if (nDocentes == 1) {

                        System.out.print("\nDigite o ID do Docente: ");
                        idDocente = sc.nextInt();

                        for (Docentes docentes : Escola.docentesList) {

                            if (docentes.getId() == idDocente) docente = docentes;

                        }

                        //Add agenda da semana com: (id, nome Turma, nome Docente, dias da semana)
                        List<List<String>> novaSemanaUmDocente = new ArrayList<>();
                        novaSemanaUmDocente.add((List.of(String.valueOf(nSemanas))));
                        novaSemanaUmDocente.add(List.of(turma.getNomeTurma()));
                        novaSemanaUmDocente.add(List.of(docente.getNomeDocente()));
                        novaSemanaUmDocente.add(List.of(docente.getNomeDocente()));
                        novaSemanaUmDocente.add(turma.getCalendario().calendarioSemanas(nSemanas));
                        novaSemanaUmDocente.add(turma.getAssuntos().get(--idAssunto));

                        turma.getCalendario().addAgendaEscolar(novaSemanaUmDocente);
                        Escola.semanasList.add(novaSemanaUmDocente);

                    } else if (nDocentes == 2) {

                        System.out.print("\nDigite o ID do Docente, para aulas SEGUNDA e TERÇA: ");
                        idDocente1 = sc.nextInt();

                        System.out.print("Digite o ID do Docente, para aulas QUARTA, QUINTA e SEXTA: ");
                        idDocente2 = sc.nextInt();

                        for (Docentes docentes : Escola.docentesList) {

                            if (docentes.getId() == idDocente1) docente1 = docentes;
                            if (docentes.getId() == idDocente2) docente2 = docentes;

                        }

                        //Add agenda da semana com: (id, nome Turma, nome Docente, dias da semana)
                        List<List<String>> novaSemanaDoisDocente = new ArrayList<>();
                        novaSemanaDoisDocente.add((List.of(String.valueOf(nSemanas))));
                        novaSemanaDoisDocente.add(List.of(turma.getNomeTurma()));
                        novaSemanaDoisDocente.add(List.of(docente1.getNomeDocente()));
                        novaSemanaDoisDocente.add(List.of(docente2.getNomeDocente()));
                        novaSemanaDoisDocente.add(turma.getCalendario().calendarioSemanas(nSemanas));
                        novaSemanaDoisDocente.add(turma.getAssuntos().get(--idAssunto));

                        turma.getCalendario().addAgendaEscolar(novaSemanaDoisDocente);
                        Escola.semanasList.add(novaSemanaDoisDocente);

                    }

                    System.out.println("-------------------------------------------");
                    System.out.println("      Docente atribuído com sucesso!       ");
                    System.out.println("-------------------------------------------");

                    System.out.print("\nPressione Enter para continuar!");
                    System.in.read();

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");

            }

        } while (opcao != 0);




        //DEBUG
        /*System.out.println();
        turma.getCalendario().addAgendaEscolar(turma.getCalendario().calendarioSemanas(nSemanas));
        System.out.println(turma.getCalendario().getAgendaEscolar());//Imprime todas semanas ecolhidas para a Turma

        turma.getCalendario().calendarioSemanasNull(nSemanas);//Seta null para a semana escolhida no calendario geral
        System.out.println(turma.getCalendario().calendarioSemanas(nSemanas));//Printa semana null
        System.out.println();
        turma.getCalendario().printaCalendario();//Imprime calendario geral

        System.out.println(Escola.semanasList);*/

    }

}
