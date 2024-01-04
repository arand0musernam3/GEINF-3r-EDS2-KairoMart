import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Kairomart {
    public static void main(String[] args) {


        Scanner stdin = new Scanner(System.in);
        System.out.println("Submit the initial data path:");
        String path = stdin.nextLine();

        bestoSoundEver(path);

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

                    System.out.println("Jugadors inscrits:");
                    race.listPlayers();
                    break;
                case 2:
                    System.out.println("Entra L'ÍNDEX del jugador");
                    race.listPlayers();
                    int index = stdin.nextInt();

                    System.out.println("Què vols fer? (Entra el número)");
                    System.out.println("1. Accelerar");
                    System.out.println("2. Girar");
                    int move_type = stdin.nextInt();

                    System.out.println("Entra el factor del moviment (entre -1 i 1)");
                    int factor = stdin.nextInt();

                    race.updateVehicle(index,factor,move_type);
                    System.out.println("Moviment programat, no s'aplicarà fins que es cridi la opció 3!");
                    break;
                case 3:
                    race.moveVehicles();
                    race.listPlayers();
                    break;
                case 4:
                    race.listPlayers();
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
        System.out.println("0. Sortir");

    }

    private static void readCharacters(Race race, String path) {
        try {
            File file = new File(path + File.separator + "characters.txt");
            Scanner reader = new Scanner(file);
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

    public static synchronized void bestoSoundEver(String path) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    File file = new File(path + File.separator + "pipipiripipiripi.wav");
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());

                    Clip clip = AudioSystem.getClip();
                    clip.open(inputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}