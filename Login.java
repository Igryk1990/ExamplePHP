package javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String log=null;
		String pass=null;
		System.out.println("Enter your login");
		try {
			log = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (log.equals("Igor")){
			System.out.println("Enter your password");
			try{
				pass=in.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			if(pass.equals("1111")){
				System.out.println("You are logged in");
			}else{
				System.out.println("You entered the incorrect password");
			}
		}else {
			System.out.println("You entered the incorrect login");
		}
	}

}
