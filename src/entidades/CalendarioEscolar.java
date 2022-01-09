package entidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarioEscolar {
    private final List<String> calendarioEscolar;

    public CalendarioEscolar() {
        this.calendarioEscolar = calendarioEscolar();
    }

    public List<String> calendarioEscolar() {
        List<String> listaDias = new ArrayList<>();

        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();

        Year ano = Year.of(anoAtual);

        for (int dia = 1; dia <= ano.length(); dia++) {
            LocalDate data = ano.atDay(dia);

            if (!data.getDayOfWeek().equals(DayOfWeek.SATURDAY) &&
                    !data.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                listaDias.add(data.format(formatar));
            }

        }
        return listaDias;
    }

    public List<String> calendariosemanas(Integer nSemanas) {
        List<String> listaSemanas = new ArrayList<>();

        Integer nDias = (--nSemanas * 5);//Recebe o numero da semana -1, vezes 5, para achar a semana
        for (Integer i = nDias; i < nDias + 5; i++) {
            listaSemanas.add(calendarioEscolar.get(i));
        }

        return listaSemanas;
    }

    public String primeiroDiaLetivo() {

        return calendarioEscolar.get(0);
    }

    public String ultimoDiaLetivo() {

        return calendarioEscolar.get(calendarioEscolar.size() - 1);
    }

    @Override
    public String toString() {
        return "CalendarioEscolar: \n" +
                calendarioEscolar
                ;
    }
}

