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
        _height = 1000;
        _width = 1000;
    }

    /**
     * TODO:
     * @Jordi la inicialització del track l'hauràs de fer a la classe race, jo pensava fer algo de l'estil següent:
     * ArrayList<Terrain> _track;
     * for (int i = 0; i < _height (1000); i++) {
     *     if (i < 400) {
     *         _track[i] = Road;
     *     }
     *     else if (i < 600) {
     *         _track[i] = Mud;
     *     }
     *     else {
     *         _track[i] = Road;
     *     }
     * }
     *
     * nose com ho veus, ja en parlarem!
     */



    public Terrain getTerrainByPosition(Vec2f position) {
        return null;
    }
}
