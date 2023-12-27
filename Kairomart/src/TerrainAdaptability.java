import java.security.InvalidParameterException;
import java.util.HashMap;

public class TerrainAdaptability {

    private static HashMap<Terrain, HashMap<Motor, Float>> _adaptabilities = new HashMap<>();

    /**
     * Adds or overwrites the current Adaptability of Terrain t and Motor m with the parameter value.
     */
    public static void addAdaptability(Terrain t, Motor m, float value) {
        if (!_adaptabilities.containsKey(t)) {
            _adaptabilities.put(t, new HashMap<>());
        }
        _adaptabilities.get(t).put(m, value);
    }

    /**
     * Returns the adaptability between Terrain t and Motor m.
     */
    public static float getAdaptability(Terrain t, Motor m) {
        return _adaptabilities.get(t).get(m);
    }
}