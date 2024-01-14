import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.sound.sampled.*;

public class Kairomart {

    private static Race race = new Race();
    private static Scanner stdin = new Scanner(System.in).useLocale(Locale.FRENCH);
    private static Clip clip;

    public static void main(String[] args) {

        System.out.println("Submit the initial data path:");
        String path = stdin.nextLine();

        clip = bestoSoundEver(path);

        readCharacters(race, path);
        readPlayers(race, path);

        menu();
        int option = readOption(stdin);

        while (option != 0) {

            switch (option) {
                case 1:
                    addPlayer(stdin);
                    break;
                case 2:
                    updatePlayer(stdin);
                    break;
                case 3:
                    movePlayer();
                    break;
                case 4:
                    race.listPlayers();
                    break;
                case 5:
                    clip.stop();
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
        System.out.println("3. Executar tick");
        System.out.println("4. Mostrar situació de la carrera");

        if (clip.isActive()) {
            System.out.println("5. Para l'àudio, si us plau!");
        }

        System.out.println("0. Sortir");

    }

    private static void addPlayer(Scanner in) {
        System.out.println("Entra el nom del jugador");
        String name = in.nextLine();

        int character;
        do {
            race.listCharacters();
            System.out.println("Entra L'ÍNDEX del personatge (que no s'hagi escollit)");
            character = in.nextInt();
        } while (race.characterUsed(character));

        race.listVehicles();
        System.out.println("Entra L'ÍNDEX del vehicle");
        int vehicle = in.nextInt();

        race.addPlayer(name,character,vehicle);

        System.out.println("Jugadors inscrits:");
        race.listPlayers();
    }

    private static void updatePlayer(Scanner in) {
        System.out.println("Entra L'ÍNDEX del jugador");
        race.listPlayers();
        int index = in.nextInt();

        System.out.println("Què vols fer? (Entra el número)");
        System.out.println("1. Accelerar");
        System.out.println("2. Girar");
        int move_type = in.nextInt();

        System.out.println("Entra el factor del moviment (entre -1 i 1)");
        float factor = in.nextFloat();

        race.updateVehicle(index,factor,move_type);
        System.out.println("Moviment programat, no s'aplicarà fins que es cridi la opció 3!");
    }

    private static void movePlayer() {
        race.moveVehicles();
        race.listPlayers();
    }

    private static void readCharacters(Race race, String path) {
        try {
            File file = new File(path + File.separator + "characters.txt");
            Scanner reader = new Scanner(file).useLocale(Locale.FRENCH);
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                String desc = reader.nextLine();
                float quadriga_adapt = reader.nextFloat();
                float biga_adapt = reader.nextFloat();
                float horse_adapt = reader.nextFloat();
                reader.nextLine();
                race.addCharacter(name,desc, quadriga_adapt, biga_adapt, horse_adapt);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer de \"characters.txt\"");
        }
    }

    private static void readPlayers(Race race, String path) {
        try {
            File file = new File(path + File.separator + "players.txt");
            Scanner reader = new Scanner(file).useLocale(Locale.FRENCH);
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

    public static synchronized Clip bestoSoundEver(String path) {

        Clip clip;
        try {
            File file = new File(path + File.separator + "pipipiripipiripi.wav");
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());

            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

        return clip;
    }
}