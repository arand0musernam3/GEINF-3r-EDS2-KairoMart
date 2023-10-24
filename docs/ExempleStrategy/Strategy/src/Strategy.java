import java.util.Scanner;

public class Strategy {

	public static void main(String[] args) {
		TextFormatter formatter = new Default();
		Scanner scanner = new Scanner(System.in);

		System.out.println("0. Exit");
		System.out.println("1. Default");
		System.out.println("2. Uppercase");
		System.out.println("3. Binary");
		System.out.println("4. Cowsay");
		System.out.println("Type anything else to format");

		while (true) {

			if (!scanner.hasNext()) break;
			String line = scanner.nextLine();

			switch (line) {
				case "0" -> System.exit(0);
				case "1" -> formatter = new Default();
				case "2" -> formatter = new Uppercase();
				case "3" -> formatter = new Binary();
				case "4" -> formatter = new Cowsay();
				default -> System.out.println(formatter.format(line));
			}
		}
    }
}