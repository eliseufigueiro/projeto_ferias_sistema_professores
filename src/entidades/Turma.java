package entidades;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private static Integer idControle = 0;
    private Integer id;
    private String nomeTurma;
    private Integer qtAlunos;
    private Assuntos assuntos;
    private List<String> dataInicio;
    private List<Docentes> docentes;
    private CalendarioEscolar calendarioEscolars;

    public Turma() {
    }

    public Turma(String nomeTurma, Integer qtAlunos, Assuntos assuntos) {
        this.id = ++idControle;
        this.nomeTurma = nomeTurma;
        this.qtAlunos = qtAlunos;
        this.assuntos = assuntos;
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

    public Assuntos getAssuntos() {

        return assuntos;
    }

    public void setAssuntos(Assuntos assuntos) {

        this.assuntos = assuntos;
    }

    public List<String> getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(List<String> dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<Docentes> getDocentes() {

        return docentes;
    }

    public void setDocentes(List<Docentes> docentes) {

        this.docentes = docentes;
    }

    public CalendarioEscolar getCalendarioEscolars() {

        return calendarioEscolars;
    }

    public void setCalendarioEscolars(CalendarioEscolar calendarioEscolars) {

        this.calendarioEscolars = calendarioEscolars;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", qtAlunos=" + qtAlunos +
                ", assuntos=" + assuntos +
                ", dataInicio=" + dataInicio +
                '}';
    }
}
