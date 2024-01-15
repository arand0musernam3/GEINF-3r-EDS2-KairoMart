import java.awt.event.WindowFocusListener;
import java.sql.Array;
import java.util.ArrayList;

public class Track {
    private int _difficulty;
    private String _name;

    public static final int HEIGHT = 10000, WIDTH = 10000;

    //this should be a matrix, in order to simplify the example we will treat the track as a one dimensional space,
    //so that only the x coordinate will have an effect on the change of terrain. In the real game this would
    //be a surface.
    private final ArrayList<Terrain> _track;

    Track(String name, int difficulty, ArrayList<Terrain> terrains) {
        _name = name;
        _difficulty = difficulty;
        _track = new ArrayList<>();

        for (int i = 0; i < WIDTH; i++) {
            if (i < 4000) {
                _track.add(i, terrains.get(Terrain.ROAD));
            }
            else if (i < 6000) {
                _track.add(i, terrains.get(Terrain.MUD));
            }
            else {
                _track.add(i, terrains.get(Terrain.ROAD));
            }
        }
    }

    public Terrain getTerrainByPosition(Vec2f position) {
        int index = Math.max((int)position.x, 0);
        return _track.get(index);
    }
}
