import java.util.*;

public class Race {

    Race() {
        _terrains = new ArrayList<>();
        _terrains.add(Terrain.ROAD, new Terrain("Road", "Recently asphalted road."));
        _terrains.add(Terrain.MUD, new Terrain("Mud", "Slippery and gets your car dirty."));

        _track = new Track("Computer Science Plains", 5, _terrains);

        _characters = new ArrayList<>();
        _players = new ArrayList<>();
        _terrain_control = new HashMap<>();

        _quadriga = new Quadriga();
        _biga = new Biga();
        _horse = new Horse();

        // Terrain adaptabilities
        for (int i = 0; i < 2; i++)
            for (int j = 1; j <= 3; j++)
                TerrainAdaptability.addAdaptability(_terrains.get(i), motorSwitch(j), ((float)j*(i+1))/6); //Per dir algo, fantasia
    }

    public void addCharacter(String name, String desc, float q_adapt, float b_adapt, float h_adapt) {
        Character aux = new Character(name,desc);
        _characters.add(aux);
        CharacterAdaptability.addAdaptability(aux,motorSwitch(1),q_adapt);
        CharacterAdaptability.addAdaptability(aux,motorSwitch(2),b_adapt);
        CharacterAdaptability.addAdaptability(aux,motorSwitch(3),h_adapt);
    }

    public void addPlayer(String name, int i_character, int i_vehicle) {

        Character c = _characters.get(i_character-1);
        Motor motor = motorSwitch(i_vehicle);
        Vehicle v = new Vehicle(motor);

        _players.add(new Player(name, c, v));

        IMotor m = v.getMotor();
        v.setWrappee(new AdaptabilityDecorator(m, CharacterAdaptability.getAdaptability(c, motor)));

        m = v.getMotor();
        AdaptabilityDecorator terrain_adaptability = new AdaptabilityDecorator(m, TerrainAdaptability.getAdaptability(_track.getTerrainByPosition(v.position()),motor));

        _terrain_control.put(v,terrain_adaptability);
        v.setWrappee(terrain_adaptability);
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
        for (Vehicle v : _terrain_control.keySet())
            _terrain_control.get(v).updateAdaptability(v.getMotor().terrainAdaptability(_track.getTerrainByPosition(v.position())));
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

    private ArrayList<Terrain> _terrains;
    private Track _track;
    private ArrayList<Character> _characters;
    private ArrayList<Player> _players;

    private HashMap<Vehicle, AdaptabilityDecorator> _terrain_control;

    private final Quadriga _quadriga;
    private final Biga _biga;
    private final Horse _horse;

    public static float delta_time = 1;
}
