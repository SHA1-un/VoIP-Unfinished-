package VoIP;

import VoIP.Client.Client;
import VoIP.Server.Server;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client;
        Server server;
        String ans;
        Scanner s;
        boolean done = true;
        while (done) {
            System.out.println("Would you like to start:");
            System.out.println("1. the Server");
            System.out.println("2. the Client");
            System.out.println("3. both");
            System.out.println("4. quit");
            s = new Scanner(System.in);
            ans = s.nextLine();
            switch (ans) {
                case "1": server = new Server(); done = false; break;
                case "2": client = new Client(); done = false; break;
                case "3":
                server = new Server();
                client = new Client();
                done = false;
                break;
                case "4": done = false; break;
                default: System.out.println("Please reply with only 1,2,3 or 4.");

            }
        }
    }
}
