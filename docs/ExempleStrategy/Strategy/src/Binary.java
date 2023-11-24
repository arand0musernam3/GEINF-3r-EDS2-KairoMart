public class Binary implements TextFormatter {
	@Override
	public String format(String str) {
		char[] array = str.toCharArray();
		String res = new String();
		for (char c : array) {
			res += Integer.toBinaryString(c) + ' ';
		}
		return res;
	}
}
