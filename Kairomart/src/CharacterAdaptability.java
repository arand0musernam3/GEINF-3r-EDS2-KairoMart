import java.util.HashMap;

public class CharacterAdaptability {
    private static HashMap<Character, HashMap<Motor, Float>> _adaptabilities = new HashMap<>();

    /**
     * Adds or overwrites the current Adaptability of Character c and Motor m with the parameter value.
     */
    public static void addAdaptability(Character c, Motor m, float value) {
        if (!_adaptabilities.containsKey(c)) {
            _adaptabilities.put(c, new HashMap<>());
        }
        _adaptabilities.get(c).put(m, value);
    }

    /**
     * Returns the adaptability between Character c and Motor m. If it's non-existent, returns null.
     */
    public static float getAdaptability(Character c, Motor m) {
        return _adaptabilities.get(c).get(m);
    }
}
