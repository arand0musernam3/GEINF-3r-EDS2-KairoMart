public abstract class Motor implements IMotor {
    protected float _max_speed;
    protected float _weight;
    protected float _acceleration;
    protected float _handling;
    protected float _braking_power;
    protected float _hit_resistance;
    protected String _name;

    @Override
    public Vec2f move(float speed, float angle) {

        float x = (float)(Math.cos(angle) * speed);
        float y = (float)(Math.sin(angle) * speed);

        return new Vec2f(x, y);
    }

}
