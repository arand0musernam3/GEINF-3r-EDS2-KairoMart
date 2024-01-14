public class Horse extends Motor {

    Horse() {
        _acceleration = 20f;
        _handling = 0.5f;
        _weight = 100f;
        _braking_power = 20f;
        _max_speed = 200f;
        _name = "Horse";
    }

    @Override
    public float accelerate(float speed, float by) {
        float acc = by > 0 ? _acceleration : _braking_power;
        return Math.min(_max_speed, speed + by*(1 + speed) * acc*Race.delta_time) - speed;
    }
}
