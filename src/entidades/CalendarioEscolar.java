package entidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarioEscolar {
    private final List<String> calendarioEscolar;
    private static List<List<String>> agendaEscolar = new ArrayList<>();

    public CalendarioEscolar() {

        this.calendarioEscolar = calendarioEscolar();
    }

    public List<String> getCalendarioEscolar() {
        return calendarioEscolar;
    }

    public static List<List<String>> getAgendaEscolar() {

        return agendaEscolar;
    }

    //Inicia o calendario anual, pegando o ano vigente atual
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

    //Retorna a semana escolhida
    public List<String> calendarioSemanas(Integer nSemanas) {
        List<String> listaSemanas = new ArrayList<>();

        Integer nDias = (--nSemanas * 5);//Recebe o numero da semana -1, vezes 5, para achar a semana
        for (Integer i = nDias; i < nDias + 5; i++) {

            listaSemanas.add(calendarioEscolar.get(i));//Pega os dias do calendario

        }

        return listaSemanas;//Retorna a lista da semana
    }

    //Seta nulo para os dias pegos, assim a agenda fica ocupado... bora testar essa ideia louca (FUNCIONA KKKKKKK)
    public void calendarioSemanasNull(Integer nSemanas) {

        Integer nDias = (--nSemanas * 5);//Recebe o numero da semana -1, vezes 5, para achar a semana
        for (Integer i = nDias; i < nDias + 5; i++) {
            calendarioEscolar.set(i, null);
        }

    }
    public void addAgendaEscolar(List<String> novaSemana) {

        agendaEscolar.add(novaSemana);
    }

    /*public void printaAgendaLivreOcupada() {

        for (int = 0; i < calendarioEscolar.size(); i + 5){



        }

    }*/

    public String primeiroDiaLetivo() {

        return calendarioEscolar.get(0);
    }

    public String ultimoDiaLetivo() {

        return calendarioEscolar.get(calendarioEscolar.size() - 1);
    }

    public void printaCalendario() {
        System.out.println(calendarioEscolar);
    }

    @Override
    public String toString() {
        return "CalendarioEscolar: \n" +
                calendarioEscolar
                ;
    }
}

