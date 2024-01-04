public class Biga extends Motor {

    Biga() {
        _acceleration = 1f;
        _handling = 0.5f;
        _weight = 100f;
        _braking_power = 1f;
        _max_speed = 200f;
        _hit_resistance = 0.1f;//TODO CHANGE VALUES
        _name = "Biga";
    }

    @Override
    public float accelerate(float speed, float by) {
        return 0; //TODO
    }

    @Override
    public float turn(float angle, float by) {
        return 0; //TODO
    }

    @Override
    public Vec2f move(float speed, float angle) {
        return null; //TODO
    }
}
