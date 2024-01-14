public class Quadriga extends Motor {

    Quadriga() {
        _acceleration = 30f;
        _handling = 0.5f;
        _weight = 400f;
        _braking_power = 50f;
        _max_speed = 500f;
        _name = "Quadriga";
    }

    @Override
    public float accelerate(float speed, float by) {
        float acc = by > 0 ? _acceleration : _braking_power;
        return Math.min(_max_speed, speed + by*acc*Race.delta_time) - speed;
    }
}
