public class Formatter {

	public Formatter() {
		tf = new Default();
	}

	public String format(String str) {
		return tf.format(str);
	}

	public void changeFormatter(TextFormatter t) {
		tf = t;
	}

	private TextFormatter tf;
}
