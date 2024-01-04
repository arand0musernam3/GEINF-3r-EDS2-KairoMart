public class Player implements Comparable<Player> {
    public Player(String name, Character character, Vehicle vehicle) {
        _name = name;
        _character = character;
        _vehicle = vehicle;
    }

    private final String _name;
    private final Character _character;
    private final Vehicle _vehicle;

    @Override
    public String toString() {
        return _name + " (" + _character.name() + ", " + _vehicle.getMotor().name() + "): " + _vehicle.position().x + "m";
    }

    @Override
    public int compareTo(Player o) {
        return (int)(_vehicle.position().x - o._vehicle.position().x);
    }

    public Vehicle vehicle() {
        return _vehicle;
    }
}
