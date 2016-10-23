package javastudy;

import java.util.Scanner;


public class Inch {
	public static void incnInsant (int a){
		double sant ;
		sant = a*2.54;
		System.out.println(a+" inches is "+sant+" centimeters");
	}

	public static void main(String[] args) {
		System.out.println("Enter inches");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		incnInsant(a);
	}

}
