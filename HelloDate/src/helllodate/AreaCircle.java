package helllodate;

import java.util.Scanner;

public class AreaCircle {
	public static void areaCircle (int r){
		double area = Math.PI*r*r;
		System.out.println("ѕлощадь круга: "+area);
	}

	public static void main(String[] args) {
		System.out.println("¬ведите радиус");
		Scanner radius = new Scanner(System.in);
		int r = radius.nextInt();
		areaCircle(r);
	}

}
