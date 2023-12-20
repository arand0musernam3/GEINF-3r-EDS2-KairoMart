import java.util.HashMap;

public class Terrain {
    private String _type;
    private String _description;

    private HashMap<Motor, Float> _adaptability;

    Terrain(String type, String desc) {
        _type = type;
        _description = desc;
    }

    void setAdaptability(Motor m, float f) {
        _adaptability.put(m, f);
    }

    float getAdaptability(Motor m) {
        return _adaptability.get(m);
    }
}
