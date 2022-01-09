package servico;

import aplicacao.Escola;
import entidades.Docentes;

import java.util.Scanner;

public class CadastrarDocente {

    public void cadastrarDocente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n2. Cadastrar docentes\n");

        System.out.print("Nome Docente: ");
        String docente = sc.nextLine();

        System.out.print("CPF Docente: ");
        String cpf = sc.nextLine();

        Docentes docentes = new Docentes(docente, cpf);
        Escola.docentesList.add(docentes);

        System.out.println("===========================================");
        System.out.println("Docente cadastrado com sucesso!");
        System.out.println("===========================================");
    }
}
