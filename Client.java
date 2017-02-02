import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Client {
	JFrame frame;
	static String name;
	static String password;
	JTextArea incoming; 
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	public static void main(String[] args) throws SQLException {
		Client client = new Client();
		name = JOptionPane.showInputDialog("Enter your name");
		while(Database.getUser(name)){
			name = JOptionPane.showInputDialog("Try now enter another name");
		}
		password = JOptionPane.showInputDialog("Enter your password");
		Database.setDB(name, password);
		client.go();
	}
	public void go(){
		frame = new JFrame("Chat");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,20);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane (incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outgoing = new JTextField(15);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				try{
					writer.println(name+":"+outgoing.getText());
					writer.flush();
				} catch (Exception ex){
					ex.printStackTrace();
				}
				outgoing.setText("");
				outgoing.requestFocus();
			}
		});
		mainPanel.add(qScroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		setUpNetworking();
		Thread readerThread = new Thread(new Runnable(){
			public void run(){
				String message;
				try{
					while((message=reader.readLine())!=null){
						incoming.append(message+"\n");
						FileWriter file = new FileWriter("History.txt",true);
						file.write(message+"\n");
						file.close();
					}
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		readerThread.start();
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	private void setUpNetworking(){
		try{
			sock = new Socket("127.0.0.1",5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}