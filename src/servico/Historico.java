package servico;

import aplicacao.Escola;
import entidades.Docentes;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    public void listarDocentes() {

        System.out.println("\n5. Listar todos os docentes");
        System.out.println(Escola.docentesList);
    }
}
