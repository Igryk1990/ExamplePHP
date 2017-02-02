import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) {
		Server server = new Server();
		server.go();
	}
	ServerSocket serverSock;
	ArrayList clientOutputStreams;
	class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		public ClientHandler(Socket clientSocket){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		public void run(){
			String message;
			try{
				while((message = reader.readLine())!=null){
					tellEveryone(message);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void go(){
		clientOutputStreams = new ArrayList();
		try{
	    	serverSock = new ServerSocket(5000);
			while(true){
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				Thread t = new Thread (new ClientHandler(clientSocket));
				t.start();
			}
		}catch (Exception ex){
			ex.printStackTrace();
			}
	}
	public void tellEveryone(String message){
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer = (PrintWriter)it.next();
				writer.println(message);
				writer.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
