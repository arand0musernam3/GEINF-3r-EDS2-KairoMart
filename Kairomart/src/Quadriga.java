public class Quadriga extends Motor {

    Quadriga() {
        _acceleration = 2f;
        _handling = 0.5f;
        _weight = 100f;
        _braking_power = 1f;
        _max_speed = 200f;
        _name = "Quadriga";
    }

    @Override
    public float accelerate(float speed, float by) {
        float acc = by > 0 ? _acceleration : _braking_power;
        return Math.max(Math.min(_max_speed, speed + by*acc*Race.delta_time) - speed, 0f);
    }
}
