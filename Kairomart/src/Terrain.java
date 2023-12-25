import java.util.HashMap;

public class Terrain {
    private String _type;
    private String _description;

    private HashMap<IMotor, Float> _adaptability;

    Terrain(String type, String desc) {
        _type = type;
        _description = desc;
    }

    void setAdaptability(IMotor m, float f) {
        _adaptability.put(m, f);
    }

    float getAdaptability(IMotor m) {
        return _adaptability.get(m);
    }
}
