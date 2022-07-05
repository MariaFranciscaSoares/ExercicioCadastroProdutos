package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> listProduct = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int number = sc.nextInt();

		for (int i = 1; i <= number; i++) {
			System.out.println("Product 0" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char option = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (option == 'u') {
				System.out.println("Manufacture date ");
				System.out.print("Year of manufacture: ");
				int year = sc.nextInt();
				System.out.print("Month of manufacture: ");
				int month = sc.nextInt();
				System.out.print("Manufacturing day: ");
				int day = sc.nextInt();
				LocalDate date = LocalDate.of(year, month, day);

				listProduct.add(new UsedProduct(name, price, date));
			}
			else if (option == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				listProduct.add(new ImportedProduct(name, price, customsFee));
			} else
				listProduct.add(new Product(name, price));
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : listProduct) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
