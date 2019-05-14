import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Klient {
	public static final int PORT = 5010;
	public static final String IP = "127.0.0.1";
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public static void main(String[] args) {
		Klient klient = new Klient();
		klient.startKlient();
	}

	public void startKlient() {
		Scanner sc = new Scanner(System.in);

		try {
			Socket socket = new Socket(IP, PORT);
			System.out.println("Po³¹czono do: " + socket);

			printWriter = new PrintWriter(socket.getOutputStream(), true);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				try {
					System.out.print("\n>>");
					String str = sc.nextLine();

					if (str.equalsIgnoreCase("q")) {
						printWriter.println(str);
						System.out.println("Connection ended by client");
						break;
					}
					if (checkTimeInNotification(str)) {
						printWriter.println(str);
						System.out.println("The notification was sent to the server.\nWaiting for response.");
					}

					str = bufferedReader.readLine();
					System.out.println(str);

				} catch (WrongContentOfNotificationException e) {
					e.printStackTrace(System.err);
					System.err.println(e.toString() + " doesn't match HH:MM");
				}

			}
			printWriter.close();
			sc.close();
			socket.close();
			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean checkTimeInNotification(String s) throws WrongContentOfNotificationException {
		if (s.length() <= 5)
			throw new WrongContentOfNotificationException("Wrong time in notifiaction", s);

		if (s.substring(0, 5).matches("^(([0-1]{0,1}[0-9])|(2[0-3])):[0-5]{0,1}[0-9]$") && !timePassed(s))
			return true;
		else
			throw new WrongContentOfNotificationException("Wrong time in notification", s.substring(0, 5));
	}

	public boolean timePassed(String s) {

		String actualTime = ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toString();
		String actualHour = actualTime.substring(11, 13);
		String actualMinutes = actualTime.substring(14, 16);
		
		// aktualny czas w minutach
		int time1 = Integer.parseInt(actualHour) * 60 + Integer.parseInt(actualMinutes);
		// czas z notyfikacji w minutach
		int time2 = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));

		if (time1 > time2){
			System.out.println("time passed");
			return true;
		} else
			return false;
	}
}
