package entidades;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private static Integer idControle = 0;
    private Integer id;
    private String nomeTurma;
    private Integer qtAlunos;
    private List<Assuntos> assuntos = new ArrayList<>();
    private List<Docentes> docentes = new ArrayList<>();
    private CalendarioEscolar calendario;
    private String dataInicioDasAulas;

    public Turma() {
    }

    public Turma(String nomeTurma, Integer qtAlunos, List<Assuntos> assuntos) {
        this.id = ++idControle;
        this.nomeTurma = nomeTurma;
        this.qtAlunos = qtAlunos;
        this.assuntos = assuntos;
        setaCalendarioAnual();
        setaDataInicioDasAulas();
    }

    public Integer getId() {

        return id;
    }

    public String getNomeTurma() {

        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {

        this.nomeTurma = nomeTurma;
    }

    public Integer getQtAlunos() {

        return qtAlunos;
    }

    public void setQtAlunos(Integer qtAlunos) {

        this.qtAlunos = qtAlunos;
    }

    public List<Assuntos> getAssuntos() {

        return assuntos;
    }

    public void setAssuntos(List<Assuntos> assuntos) {

        this.assuntos = assuntos;
    }

    public List<Docentes> getDocentes() {

        return docentes;
    }

    public void setDocentes(List<Docentes> docentes) {

        this.docentes = docentes;
    }

    public CalendarioEscolar getCalendario() {

        return calendario;
    }

    public String getDataInicioDasAulas() {

        return dataInicioDasAulas;
    }

    //Metodos auxiliares
    public void setaCalendarioAnual() {

        CalendarioEscolar calendarioEscolar = new CalendarioEscolar();
        this.calendario = calendarioEscolar;
    }

    public void setaDataInicioDasAulas() {
        //CalendarioEscolar calendarioEscolar = new CalendarioEscolar();
        this.dataInicioDasAulas = calendario.primeiroDiaLetivo();
    }

    //Add Docente a lista turmaAtual do obj
    public void addDocente(Docentes novoDocente) {

        docentes.add(novoDocente);
    }

    @Override
    public String toString() {
        return
                "\nID = " + id +
                        ", TURMA = " + nomeTurma +
                        ", QT. ALUNOS = " + qtAlunos +
                        ", ASSUNTOS = " + assuntos +
                        ", DOCENTES = " + docentes +
                        ", INÍCIO DAS AULAS = " + dataInicioDasAulas + "\n"
                        ;
    }

}
