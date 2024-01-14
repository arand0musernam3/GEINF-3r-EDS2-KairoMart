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
        return _name + " (" + _character.name() + ", " + _vehicle.getMotor().name() + "): " + _vehicle.velocity() + "m/s " + _vehicle.angle() + "rad " + _vehicle.position().x + "m";
    }

    @Override
    public int compareTo(Player o) {
        int res = _vehicle.position().x < o._vehicle.position().x ? -1 : _vehicle.position().x > _vehicle.position().x ? 1 : 0;
        return res;
    }

    public Vehicle vehicle() {
        return _vehicle;
    }
    public Character character() {
        return _character;
    }
}
