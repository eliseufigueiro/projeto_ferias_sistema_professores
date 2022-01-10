package entidades;

import java.util.ArrayList;
import java.util.List;

public class Docentes {

    private static Integer idControle = 0;
    private Integer id;
    private String nomeDocente;
    private String cpf;
    private List<Turma> turmaAtual = new ArrayList<>();

    public Docentes() {
    }

    public Docentes(String nomeDocente, String cpf) {
        this.id = ++idControle;
        this.nomeDocente = nomeDocente;
        this.cpf = cpf;
    }

    public Integer getId() {

        return id;
    }

    public String getNomeDocente() {

        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {

        this.nomeDocente = nomeDocente;
    }

    public String getCpf() {

        return cpf;
    }

    public List<Turma> getTurmaAtual() {

        return turmaAtual;
    }

    public void setTurmaAtual(List<Turma> turmaAtual) {

        this.turmaAtual = turmaAtual;
    }

    //Add Turma a lista turmaAtual do obj
    public void addTurma(Turma novaTurma) {

        turmaAtual.add(novaTurma);
    }

    @Override
    public String toString() {
        return
                "[ID: " + id +
                        ", DOCENTE: " + nomeDocente +
                        ", CPF: " + cpf + "]"
                ;
    }
}
