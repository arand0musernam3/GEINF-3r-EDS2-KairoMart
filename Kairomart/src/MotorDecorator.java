public abstract class MotorDecorator implements IMotor, IMotorWrapper {

	private IMotorWrapper _wrapper;
	private IMotor _wrappee;

	public MotorDecorator(IMotor wrappee) {

		_wrapper = null;
		_wrappee = wrappee;

	}

	@Override
	public String name() {

		return _wrappee.name();

	}

	@Override
	public float terrainAdaptability(Terrain terrain) {

		return _wrappee.terrainAdaptability(terrain);

	}

	@Override
	public float accelerate(float speed, float by) {

		return _wrappee.accelerate(speed, by);

	}

	@Override
	public float turn(float angle, float by) {

		return _wrappee.turn(angle, by);

	}

	@Override
	public Vec2f move(float speed, float angle) {

		return _wrappee.move(speed, angle);

	}

	@Override
	public void setWrappee(IMotor wrappee) {

		_wrappee = wrappee;

		if (wrappee instanceof MotorDecorator) {
			var decorator = (MotorDecorator)wrappee;
			decorator.setWrapper(this);
		}

	}

	public void setWrapper(IMotorWrapper wrapper) {

		_wrapper = wrapper;

	}

	public void remove() {

		_wrapper.setWrappee(_wrappee);

	}

}
