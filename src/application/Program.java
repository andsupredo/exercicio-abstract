package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoaList = new ArrayList<>();

        System.out.print("Número de pagantes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do pagador #" + i + ":");
            while (true) {
                System.out.print("Pessoa Física ou Jurídica (f/j)? ");
                char select = sc.next().charAt(0);

                if (select != 'f' && select != 'j') {
                    System.out.println("Opção inválida... tente novamente");
                } else {
                    System.out.print("Nome: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.print("Renda anual: ");
                    double rendaAnual = sc.nextDouble();
                    if (select == 'f') {
                        System.out.print("Gastos com saúde: ");
                        double gastosSaude = sc.nextDouble();
                        PessoaFisica pessoaFisica = new PessoaFisica(nome, rendaAnual, gastosSaude);
                        pessoaList.add(pessoaFisica);
                        break;
                    }
                    if (select == 'j') {
                        System.out.print("Nº de Funcionários: ");
                        int qtdFuncionarios = sc.nextInt();
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, rendaAnual, qtdFuncionarios);
                        pessoaList.add(pessoaJuridica);
                        break;
                    }
                }
            }
        }
        double sum = 0;
        System.out.println();
        System.out.println("Imposto pago:");
        for (Pessoa pagante : pessoaList) {
            System.out.println(pagante);
            sum += pagante.imposto();
        }

        System.out.println();
        System.out.print("TOTAL ARRECADADO: ");
        System.out.println(sum);
        sc.close();
    }
}