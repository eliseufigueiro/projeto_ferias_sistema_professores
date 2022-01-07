package entidades;

import java.util.ArrayList;
import java.util.List;

public class Docentes {

    private static Integer idControle = 0;
    private Integer id;
    private String nomeDocente;
    private String cpf;
    private List<Turma> turmaAtual;

    public Docentes() {
    }

    public Docentes(String nomeDocente, String cpf) {
        this.id = ++idControle;
        this.nomeDocente = nomeDocente;
        this.cpf = cpf;
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

    public Turma getTurmaAtual() {

        return (Turma) turmaAtual;
    }

    public void setTurmaAtual(List<Turma> turmaAtual) {

        this.turmaAtual = turmaAtual;
    }

    @Override
    public String toString() {
        return "Docentes{" +
                "id=" + id +
                ", nomeDocente='" + nomeDocente + '\'' +
                ", cpf='" + cpf + '\'' +
                ", turmaAtual=" + turmaAtual +
                '}' + "\n";
    }
}
