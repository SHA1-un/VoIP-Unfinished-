package VoIP.Client;

import java.util.Scanner;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Client {
    public Client() {
        LoginGUI lg = new LoginGUI();
        /*
	    Scanner scan = new Scanner(System.in);
		System.out.print("Server IP Address: ");
		String ip = scan.nextLine();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois;
		try {
			socket = new Socket(ip, 60010);
			System.out.println("Connected to server");
		} catch (Exception e) {
			System.out.println("Something went wrong with connecting to server: " + e);
		}

		System.out.print("What is your username: ");
		String username = scan.nextLine();
		try {
	        oos = new ObjectOutputStream(socket.getOutputStream());
    	    ois = new ObjectInputStream(socket.getInputStream());
    	} catch (Exception e) {
    		System.out.println("Could not create streams");
    	}

    	try {
            oos.writeObject(username);
    	} catch (Exception e) {
    		System.out.println("Could not Send username");
    	}
        */

    }
}
