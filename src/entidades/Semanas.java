package entidades;

import java.util.ArrayList;
import java.util.List;

public class Semanas {

    private Integer numeroDaSemana;
    private String segunda;
    private String terca;
    private String Quarta;
    private String quinta;
    private String sexta;

    public Semanas() {
    }

    public Semanas(Integer numeroDaSemana) {
        this.numeroDaSemana = numeroDaSemana;
    }

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    public String getTerca() {
        return terca;
    }

    public void setTerca(String terca) {
        this.terca = terca;
    }

    public String getQuarta() {
        return Quarta;
    }

    public void setQuarta(String quarta) {
        Quarta = quarta;
    }

    public String getQuinta() {
        return quinta;
    }

    public void setQuinta(String quinta) {
        this.quinta = quinta;
    }

    public String getSexta() {
        return sexta;
    }

    public void setSexta(String sexta) {
        this.sexta = sexta;
    }

    @Override
    public String toString() {
        return "Semanas{" +
                "numeroDaSemana=" + numeroDaSemana +
                ", segunda='" + segunda + '\'' +
                ", terca='" + terca + '\'' +
                ", Quarta='" + Quarta + '\'' +
                ", quinta='" + quinta + '\'' +
                ", sexta='" + sexta + '\'' +
                '}';
    }
}
