/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

/**
 *
 * @author Bijan
 */
import java.io.*;
import java.net.*;

public class ClientChat{

	ObjectOutputStream out;
	ObjectInputStream in;
	Socket s;
	BufferedReader br;
	String serMessage, clientMessage;
    private String serverMessage;
	public ClientChat(){

		try{

			s = new Socket("Localhost",8888);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			br = new BufferedReader(new InputStreamReader(System.in));

			while(true){

				System.out.println("client==>");
				clientMessage = br.readLine();
				out.writeObject(clientMessage);
				serverMessage = (String)in.readObject();
				System.out.println("server==>"+serverMessage);
				if(clientMessage.equalsIgnoreCase("bye")){

					System.exit(0);


				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		ClientChat c = new ClientChat();
	}
}
