import java.util.*;

public class Race {

    Race() {
        _track = new Track("Computer Science Plains", 5);

        _characters = new ArrayList<>();
        _players = new ArrayList<>();

        _quadriga = new Quadriga();
        _biga = new Biga();
        _horse = new Horse();
    }

    public void addCharacter(String name, String desc) {
        _characters.add(new Character(name,desc));
    }

    public void addPlayer(String name, int i_character, int i_vehicle) {

        _players.add(new Player(name, _characters.get(i_character-1), new Vehicle(motorSwitch(i_vehicle))));

    }

    public void updateVehicle(int i_player, int factor, int move_type) {
        if (move_type == 1)
            _players.get(i_player-1).vehicle().accelerate(factor);
        else
            _players.get(i_player-1).vehicle().turn(factor);
    }

    public void moveVehicles() {
        for (Player p : _players) {
            p.vehicle().move();
        }
        Collections.sort(_players);
        Collections.reverse(_players);
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

    public void listPlayers() {
        int i = 1;
        for (Player p : _players) {
            System.out.println(i + ". " + p);
            i++;
        }
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
