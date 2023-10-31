import java.util.Scanner;

public class Strategy {

	public static void main(String[] args) {
		Formatter f = new Formatter();
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
				case "1" -> f.changeFormatter(new Default());
				case "2" -> f.changeFormatter(new Uppercase());
				case "3" -> f.changeFormatter(new Binary());
				case "4" -> f.changeFormatter(new Cowsay());
				default -> System.out.println(f.format(line));
			}
		}
    }
}