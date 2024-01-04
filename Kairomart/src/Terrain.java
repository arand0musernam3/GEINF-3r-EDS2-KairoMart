import java.util.HashMap;

public class Terrain {
    public static final int ROAD = 0;
    public static final int MUD = 1;

    private String _type;
    private String _description;

    Terrain(String type, String desc) {
        _type = type;
        _description = desc;
    }

    public String type() {
        return _type;
    }

    public String description() {
        return _description;
    }
}
