import java.util.Comparator;

public class QueueTimeComparator implements Comparator<Message> {

	@Override
	public int compare(Message a, Message b) {

		String x = a.getString();
		String y = b.getString();

		int time1 = Integer.parseInt(x.substring(0, 2)) * 60 + Integer.parseInt(x.substring(3, 5));// czas w minutach
		int time2 = Integer.parseInt(y.substring(0, 2)) * 60 + Integer.parseInt(y.substring(3, 5));

		return time1 - time2;
	}

}
