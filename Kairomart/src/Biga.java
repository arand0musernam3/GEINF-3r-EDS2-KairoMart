public class Biga extends Motor {

    Biga() {
        _acceleration = 10f;
        _handling = 0.5f;
        _weight = 100f;
        _braking_power = 1f;
        _max_speed = 200f;
        _name = "Biga";
    }

    @Override
    public float accelerate(float speed, float by) {
        float acc = by > 0 ? _acceleration : _braking_power;
        return Math.max(Math.min(_max_speed, speed + by/(1 + speed) * acc*Race.delta_time) - speed, 0f);
    }

}
