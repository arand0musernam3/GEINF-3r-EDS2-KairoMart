import java.sql.Array;
import java.util.ArrayList;

public class Track {
    private int _difficulty;
    private String _name;

    private int _height, _width;

    //this should be a matrix, in order to simplify the example we will treat the track as a one dimensional space,
    //so that only the x coordinate will have an effect on the change of terrain. In the real game this would
    //be a surface.
    private ArrayList<Terrain> _track;

    Track(String name, int difficulty) {
        _name = name;
        _difficulty = difficulty;
        _height = 10000;
        _width = 10000;
        _track = new ArrayList<>();

        Terrain road = new Terrain("Road", "Recently asphalted road.");
        Terrain mud = new Terrain("Mud", "Slippery and gets your car dirty.");

        for (int i = 0; i < _height; i++) {
            if (i < 4000) {
                _track.add(i, road);
            }
            else if (i < 6000) {
                _track.add(i, mud);
            }
            else {
                _track.add(i, road);
            }
        }
    }

    public Terrain getTerrainByPosition(Vec2f position) {
        return _track.get((int) position.x);
    }
}
