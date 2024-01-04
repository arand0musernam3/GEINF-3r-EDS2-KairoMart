import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Race {

    Race() {
        _characters = new ArrayList<>();
        _players = new ArrayList<>();

        _quadriga = new Quadriga();
        _biga = new Biga();
        _horse = new Horse();
    }

    public void addCharacter(String name, String desc) {
        _characters.add(new Character(name,desc));
    }

    void addPlayer(String name, int i_character, int i_vehicle) {

        _players.add(new Player(name, _characters.get(i_character-1), new Vehicle(motorSwitch(i_vehicle))));

    }

    //TODO
    Iterator<Player> getClassification() {
        return null;
    }

    public void listCharacters() {
        int i = 1;
        for (Character c : _characters) {
            System.out.println(i + ". " + c.name() + ": " + c.description());
            i++;
        }
    }
    public void listVehicles() {

        for (int i = 1; i <= 3; i++)
            System.out.println(i + ". " + motorSwitch(i).name());

    }

    private Motor motorSwitch(int i) {
        switch (i) {
            case 2: return _biga;
            case 3: return _horse;
            default: return _quadriga;
        }
    }

    private Track _track;
    private ArrayList<Character> _characters;
    private ArrayList<Player> _players;

    private Quadriga _quadriga;
    private Biga _biga;
    private Horse _horse;

    public static float delta_time = 1;
}
