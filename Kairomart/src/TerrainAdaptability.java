import java.security.InvalidParameterException;
import java.util.HashMap;

public final class TerrainAdaptability {

    private static HashMap<Terrain, HashMap<IMotor, Float>> _adaptabilities = new HashMap<>();

    /**
     * Adds or overwrites the current Adaptability of Terrain t and Motor m with the parameter value.
     */
    public static void addAdaptability(Terrain t, IMotor m, float value) {
        if (!_adaptabilities.containsKey(t)) {
            _adaptabilities.put(t, new HashMap<>());
        }
        _adaptabilities.get(t).put(m, value);
    }

    /**
     * Returns the adaptability between Terrain t and Motor m.
     */
    public static float getAdaptability(Terrain t, IMotor m) {
        return _adaptabilities.get(t).get(m);
    }

    private TerrainAdaptability() {
        throw new UnsupportedOperationException();
    }

}