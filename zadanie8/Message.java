import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Message {
	int id;
	String time;
	String msg;

	Message(int id, String s) {
		this.id = id;
		this.time = s.substring(0, 5);
		this.msg = s;
	}

	public String getString() {
		return msg;
	}

	public boolean checkTime() {
		if (ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toString().substring(11, 16).equalsIgnoreCase(time))
			return true;
		else
			return false;
	}

	public boolean isItTime(int clientID) {
		if (clientID == id && checkTime())
			return true;
		return false;

	}
}
