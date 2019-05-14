import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Queue;

public class ServerThread implements Runnable {

	Server server;
	Socket socket;
	BufferedReader bufferedReader;
	PrintStream printStream;
	int clientID;
	Queue<Message> queue;

	ServerThread(int ID, Socket socket, Server server, Queue<Message> queue) throws IOException {
		this.server = server;
		this.socket = socket;
		this.clientID = ID;
		this.queue = queue;
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		printStream = new PrintStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		String str;

		try {
			while (true) {
				str = bufferedReader.readLine();

				if (str.equalsIgnoreCase("q")) {
					System.out.println("Client " + clientID + " has disconnected");
					break;
				}

				System.out.println("Client " + clientID + ": " + str);

				queue.add(new Message(clientID, str));

				while (!queue.element().isItTime(clientID)) {
					Thread.sleep(10000);
				}

				printStream.println(queue.remove().toString());

			}
			printStream.close();
			socket.close();
			bufferedReader.close();

		} catch (IOException | InterruptedException e) {
			System.out.println("Client " + clientID + " has disconnected.");
		}

	}

}
