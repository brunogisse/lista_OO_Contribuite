package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("Digite os dados do " + (i + 1) + "º contribuinte:");
			System.out.print("Renda anual com salário: ");
			double rendaAnual = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double rendaServico = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double rendaCapital = sc.nextDouble();
			System.out.print("Gastos médicos ");
			double gastosMedicos = sc.nextDouble();
			System.out.print("Gastos educacionais ");
			double gastosEducacionais = sc.nextDouble();
			System.out.println();

			list.add(new TaxPayer(rendaAnual, rendaServico, rendaCapital, gastosMedicos, gastosEducacionais));
		}

		for (int i = 0; i < n; i++) {
			System.out.println("Resumo do " + (i + 1) + " contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n", list.get(i).grossTax());
			System.out.printf("Abatimento: %.2f%n", list.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", list.get(i).netTax());
			System.out.println();
		}

		sc.close();

	}

}
