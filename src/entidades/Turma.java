package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private static Integer idControle = 0;
    private Integer id;
    private String nomeTurma;
    private Integer qtAlunos;
    private List<Assuntos> assuntos;
    private List<Docentes> docentes;
    private String dataInicioDasAulas;

    public Turma() {
    }

    public Turma(String nomeTurma, Integer qtAlunos, List<Assuntos> assuntos) {
        this.id = ++idControle;
        this.nomeTurma = nomeTurma;
        this.qtAlunos = qtAlunos;
        this.assuntos = assuntos;
        setaDataInicioDasAulas();
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

    public String getDataInicioDasAulas() {

        return dataInicioDasAulas;
    }

    public void setaDataInicioDasAulas() {
        CalendarioEscolar calendarioEscolar = new CalendarioEscolar();
        this.dataInicioDasAulas = CalendarioEscolar.getListaDias().get(0);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", qtAlunos=" + qtAlunos +
                ", assuntos=" + assuntos +
                ", dataInicio=" + dataInicioDasAulas +
                '}';
    }
}
