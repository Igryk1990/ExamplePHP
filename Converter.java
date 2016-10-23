package javastudy;

import java.util.Scanner;

public class Converter {
	
	public static void convert (int rub, double convD, double convE){
		double dollars = rub/convD;
		double euro = rub/convE;
		System.out.println("The amount of dollars: "+dollars);
		System.out.println("The amount of euro: "+euro);
	}

	public static void main(String[] args) {
		System.out.println("Enter the amount of rubles");
		Scanner scanR = new Scanner(System.in);
		int rub = scanR.nextInt();
		System.out.println("Enter course dollars ($/RUB)");
		Scanner scanD = new Scanner(System.in);
		double dollars = scanD.nextDouble();
		System.out.println("Enter course euro (EUR/RUB)");
		Scanner scanE = new Scanner(System.in);
		double euro = scanE.nextDouble();
		convert(rub, dollars, euro);
		

	}

}
