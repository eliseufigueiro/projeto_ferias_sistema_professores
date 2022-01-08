package entidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarioEscolar {
    private List<String> calendarioEscolar;

    public CalendarioEscolar() {
        this.calendarioEscolar = calendarioEscolar();
        //calendariosemanas();
    }

    public List<String> calendarioEscolar() {
        List<String> listaDias = new ArrayList<>();

        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();
        //System.out.println("Ano Atual: " + anoAtual);

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

    public void calendariosemanas() {

    }

    public String primeiroDiaLetivo() {

        return calendarioEscolar.get(0);
    }

    @Override
    public String toString() {
        return "CalendarioEscolar: \n" +
                calendarioEscolar
                ;
    }
}

