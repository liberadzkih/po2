import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Server {
	int port = 5010;
	int clientCount = 0;
	Comparator<Message> comparator = new QueueTimeComparator();
	Queue<Message> queue = new PriorityQueue<Message>(10, comparator);

	public static void main(String[] args) {
		Server server = new Server();
		server.startServer();
	}

	public void startServer() {
		try {
			// tworzenie gniazda serwerowego
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server started.");
			while (true) {
				// oczekiwanie na polaczenie i tworzenie gniazda sieciowego
				Socket socket = serverSocket.accept(); // akceptuje wszystkie polaczenia na porcie 5000
				System.out.println("Listening: " + serverSocket);
				System.out.println("Connected: " + socket);
				clientCount++;
				Thread t = new Thread(new ServerThread(clientCount, socket, this, queue));
				t.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
