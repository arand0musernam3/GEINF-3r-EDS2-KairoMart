public class Cowsay implements TextFormatter {
	@Override
	public String format(String str) {
		int cnt = str.length() + 4;
		String res = "";
		for (int i = 0; i < cnt; i++) res += '-';
		res += "\n< " + str + " >\n";
		for (int i = 0; i < cnt; i++) res += '-';
		res += '\n';
		return res +
				"        \\   ^__^\n" +
				"         \\  (oo)\\___\n" +
				"            (__)\\       )\\/\n" +
				"                ||----w |\n" +
				"                ||     ||";
	}
}
