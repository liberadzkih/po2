import java.util.Comparator;

public class QueueTimeComparator implements Comparator<Message> {

	@Override
	public int compare(Message a, Message b) {

		String x1 = a.toString().substring(0, 2);
		String x2 = a.toString().substring(3, 5);
		String y1 = b.toString().substring(0, 2);
		String y2 = b.toString().substring(3, 5);

		// Czasy w minutach
		int time1 = Integer.parseInt(x1) * 60 + Integer.parseInt(x2);
		int time2 = Integer.parseInt(y1) * 60 + Integer.parseInt(y2);

		return time1 - time2;
	}

}
