@SuppressWarnings("serial")
class WrongContentOfNotificationException extends Exception {
	String string;

	public WrongContentOfNotificationException(String msg) {
		super(msg);
	}

	public WrongContentOfNotificationException(String msg, String s) {
		super(msg);
		this.string = s;
	}

	public String getString() {
		return string;
	}
}
