public class Character {
    private final String _name;
    private final String _description;

    Character(String name, String desc) {
        _name = name;
        _description = desc;
    }

    public String name() {
        return _name;
    }

    public String description() {
        return _description;
    }
}
