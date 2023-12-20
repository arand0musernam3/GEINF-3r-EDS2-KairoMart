import java.sql.Array;
import java.util.ArrayList;

public class Track {
    private int _difficulty;
    private String _name;

    private int _height, _width;

    //this should be a matrix, in order to simplify the example we will treat the track as a one dimensional space,
    //so that only the x coordinate will have an effect on the change of terrain. In the real game this would
    //be a surface with different terrains.
    private ArrayList<Terrain> _track;

    Track() {
        _height = 1000;
        _width = 1000;

        _track = new ArrayList<>(_height);
        for (int i = 0; i < 1000; i++) {
            if ((i / 200) % 2 == 0) {

            }
        }
    }

    public Terrain getTerrainByPosition(Position p) {

    }
}
