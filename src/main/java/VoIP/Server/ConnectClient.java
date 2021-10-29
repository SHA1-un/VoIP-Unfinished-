package VoIP.Server;

import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

class ConnectClient {
    public ConnectClient(Socket socket) {
    	try {
	        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
	        System.out.println("Waiting for new user's username");
	        String username = (String) ois.readObject();
	        System.out.println("Username received: " + username);
	        // Client Object;
		} catch (Exception e) {
			System.out.println("Something went wrong with receiving the username.");
		}
    }
}
