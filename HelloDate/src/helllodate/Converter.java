package helllodate;

import java.util.Scanner;

public class Converter {
	
	public static void convert (int rub, double convD, double convE){
		double dollars = rub/convD;
		double euro = rub/convE;
		System.out.println("Количество долларов: "+dollars);
		System.out.println("Количество евро: "+euro);
	}

	public static void main(String[] args) {
		System.out.println("Введите количество рублей");
		Scanner scanR = new Scanner(System.in);
		int rub = scanR.nextInt();
		System.out.println("Введите курс доллара ($/RUB)");
		Scanner scanD = new Scanner(System.in);
		double dollars = scanD.nextDouble();
		System.out.println("Введите курс евро (EUR/RUB)");
		Scanner scanE = new Scanner(System.in);
		double euro = scanE.nextDouble();
		convert(rub, dollars, euro);
		

	}

}
