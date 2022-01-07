package entidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarioEscolar {

    public static List<String> listaDias = new ArrayList<>();//DB lista todos os dias do ano de segunda a sexta

    public CalendarioEscolar() {
        calendarioEscolar();
    }

    public static List<String> getListaDias() {

        return listaDias;
    }

    public void calendarioEscolar() {

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
    }
}

