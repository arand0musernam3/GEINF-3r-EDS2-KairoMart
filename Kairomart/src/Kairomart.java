import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kairomart {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.println("Submit the initial data path:");
        String path = stdin.nextLine();

        Race race = new Race();
        readCharacters(race, path);
        readPlayers(race, path);

        menu();
        int option = readOption(stdin);

        while (option != 0) {

            switch (option) {
                case 1:
                    System.out.println("Entra el nom del jugador");
                    String name = stdin.nextLine();

                    race.listCharacters();
                    System.out.println("Entra L'ÍNDEX del personatge");
                    int character = stdin.nextInt();

                    race.listVehicles();
                    System.out.println("Entra L'ÍNDEX del vehicle");
                    int vehicle = stdin.nextInt();

                    race.addPlayer(name,character,vehicle);
                    break;
                case 2:
                    // Opcio 2
                    break;
                case 3:
                    // Opcio 3
                    break;
                default:
                    System.out.println("Opció desconeguda, entra'n una altra");
            }

            menu();
            option = readOption(stdin);

        }


    }

    private static int readOption(Scanner in) {
        int res = in.nextInt();
        in.nextLine();
        return res;
    }
    private static void menu() {

        System.out.println("Menú principal:");
        System.out.println("1. Introduir jugador");
        System.out.println("2. Moure vehicle");
        System.out.println("3. Mostrar situació de la carrera");
        System.out.println("0. Sortir");

    }

    private static void readCharacters(Race race, String path) {
        try {
            File file = new File(path + File.separator + "characters.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                String desc = reader.nextLine();
                race.addCharacter(name,desc);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer de \"characters.txt\"");
        }
    }

    private static void readPlayers(Race race, String path) {
        try {
            File file = new File(path + File.separator + "players.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                int i_character = reader.nextInt();
                int i_vehicle = reader.nextInt();
                reader.nextLine();
                race.addPlayer(name, i_character, i_vehicle);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobar el fitxer \"players.txt\"");
        }
    }

}