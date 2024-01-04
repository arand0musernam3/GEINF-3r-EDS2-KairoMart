import java.util.HashMap;

public class Terrain {
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
