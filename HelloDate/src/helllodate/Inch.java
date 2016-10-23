package helllodate;

import java.util.Scanner;


public class Inch {
	public static void incnInsant (int a){
		double sant ;
		sant = a*2.54;
		System.out.println(a+" дюймов равно "+sant+" сантиметра");
	}

	public static void main(String[] args) {
		System.out.println("¬ведите число дюймов");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		incnInsant(a);
	}

}
