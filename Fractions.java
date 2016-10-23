package javastudy;

import java.util.Scanner;

public class Fractions {
	public static void frac (String s, String s1,String s2){
		String [] myArray = s.split("/");
		int a = Integer.parseInt(myArray[0]);
		int b = Integer.parseInt(myArray[1]);
		String [] myArray2 = s2.split("/");
		int c = Integer.parseInt(myArray2[0]);
		int d = Integer.parseInt(myArray2[1]);
		int ch=0;
		int zn=0;
		switch(s1){
		case "+":
			 ch = a*d+c*b;
			 zn = b*d;
		break;
		case "-":
			 ch = a*d-c*b;
			 zn = b*d;
		break;
		case "*":
			 ch = a*c;
			 zn = b*d;
		break;
		case "/":
			ch = a*d;
			zn = b*c;
		break;
		default:
			System.out.println("You have entered an incorrect operation )))");
		}
		System.out.println("The resulting fraction");
		System.out.println(ch+"/"+zn);
	}

	public static void main(String[] args) {
		System.out.println("Enter the firs fraction (for example: 1/2)");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println("Enter the desired operation(+,-,*,/)");
		Scanner scan1 = new Scanner(System.in);
		String s1 = scan1.nextLine();
		System.out.println("Enter the second fraction");
		Scanner scan2 = new Scanner(System.in);
		String s2 = scan.nextLine();
		frac(s,s1,s2);
	}

}
