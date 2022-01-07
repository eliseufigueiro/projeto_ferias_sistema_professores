package entidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarioEscolar<listaDias> {

    public List<String> listaDias = new ArrayList<>();//DB lista todos os dias do ano de segunda a sexta
    private Integer anoletivo;

    public CalendarioEscolar() {
    }

    public CalendarioEscolar(Integer anoletivo) {

        this.anoletivo = anoletivo;
    }

    public List<String> getListaDias() {
        return listaDias;
    }

    public Integer getAnoletivo() {
        return anoletivo;
    }

    public void setAnoletivo(Integer anoletivo) {
        this.anoletivo = anoletivo;
    }

    public void calendarioEscolar() {

        GregorianCalendar cg = new GregorianCalendar();
        System.out.println(cg.getWeeksInWeekYear());

        Year ano = Year.of(getAnoletivo());
        for (int dia = 1; dia <= ano.length(); dia++) {
            LocalDate data = ano.atDay(dia);

            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            if (!data.getDayOfWeek().equals(DayOfWeek.SATURDAY) &&
                    !data.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                if (data.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                    listaDias.add("SEGUNDA " + data.format(formatar));
                }
                if (data.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
                    listaDias.add("TERÇA   " + data.format(formatar));
                }
                if (data.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
                    listaDias.add("QUARTA  " + data.format(formatar));
                }
                if (data.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
                    listaDias.add("QUINTA  " + data.format(formatar));
                }
                if (data.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    listaDias.add("SEXTA   " + data.format(formatar));
                }
            }
        }
    }
}

