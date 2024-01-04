public abstract class Motor implements IMotor {
    protected float _max_speed;
    protected float _weight;
    protected float _acceleration;
    protected float _handling;
    protected float _braking_power;
    protected String _name;

    @Override
    public final Vec2f move(float speed, float angle) {

        float x = (float)(Math.cos(angle) * speed);
        float y = (float)(Math.sin(angle) * speed);

        return new Vec2f(x, y);
    }

    @Override
    public final float turn(float angle, float by) {
        return angle + by*_handling/_weight*100f;
    }

    @Override
    public String name() {
        return _name;
    }

    @Override
    public float terrainAdaptability(Terrain terrain) {

        return TerrainAdaptability.getAdaptability(terrain, this);

    }

}
