import java.util.*;

public class Race {

    public Race() {
        ArrayList<Terrain> terrains = new ArrayList<>();
        terrains.add(Terrain.ROAD, new Terrain("Road", "Recently asphalted road."));
        terrains.add(Terrain.MUD, new Terrain("Mud", "Slippery and gets your car dirty."));

        _track = new Track("Computer Science Plains", 5, terrains);

        _characters = new ArrayList<>();
        _players = new ArrayList<>();
        _terrain_control = new HashMap<>();

        _quadriga = new Quadriga();
        _biga = new Biga();
        _horse = new Horse();

        // Terrain adaptabilities
        float[] adaptabilities = {0.9F,0.8f,0.7F,0.8F,0.7F,0.6F};
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                TerrainAdaptability.addAdaptability(terrains.get(i), motorSwitch(j+1), adaptabilities[i*3+j]);
    }

    public void addCharacter(String name, String desc, float q_adapt, float b_adapt, float h_adapt) {
        Character aux = new Character(name,desc);
        _characters.add(aux);
        CharacterAdaptability.addAdaptability(aux,motorSwitch(1),q_adapt);
        CharacterAdaptability.addAdaptability(aux,motorSwitch(2),b_adapt);
        CharacterAdaptability.addAdaptability(aux,motorSwitch(3),h_adapt);
    }

    public boolean characterUsed(int c) {
        Character aux = _characters.get(c-1);
        for (Player p : _players)
            if (p.character() == aux) return true;
        return false;
    }

    public void addPlayer(String name, int i_character, int i_vehicle) {

        Character c = _characters.get(i_character-1);
        IMotor motor = motorSwitch(i_vehicle);

        motor = new AdaptabilityDecorator(motor,CharacterAdaptability.getAdaptability(c, motor));
        AdaptabilityDecorator terrain_adaptability = new AdaptabilityDecorator(motor,motor.terrainAdaptability(_track.getTerrainByPosition(new Vec2f(0,0)))); // Snup doggggg

        Vehicle v = new Vehicle(terrain_adaptability);

        _players.add(new Player(name, c, v));

        _terrain_control.put(v,terrain_adaptability);
    }

    public void updateVehicle(int i_player, float factor, int move_type) {
        if (move_type == 1)
            _players.get(i_player-1).vehicle().accelerate(factor);
        else if (move_type == 2)
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
            if (characterUsed(i)) {
                System.out.print("SELECCIONAT // ");
            }
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
            System.out.println(i + ". " + p + "(" + Math.max(Math.min(100,(int)(p.vehicle().position().x * 100 / Track.WIDTH)),0) + "%)");
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

    private final Track _track;
    private final ArrayList<Character> _characters;
    private final ArrayList<Player> _players;

    private final HashMap<Vehicle, AdaptabilityDecorator> _terrain_control;

    private final Quadriga _quadriga;
    private final Biga _biga;
    private final Horse _horse;

    public static float delta_time = 5;
}
