public class Vehicle implements IMotorWrapper {

	private IMotor _motor;

	private Vec2f _position;
	private float _velocity;
	private float _angle;

	public Vehicle(IMotor motor) {

		_motor = motor;
		_position = new Vec2f(0f, 0f);
		_velocity = 0f;
		_angle = 0f;

	}

	public IMotor getMotor() { return _motor; }

	@Override
	public void setWrappee(IMotor motor) {

		_motor = motor;

		if (motor instanceof MotorDecorator decorator) {
			decorator.setWrapper(this);
		}

	}

	public void accelerate(float by) {

		_velocity += _motor.accelerate(_velocity, by);

	}

	public void turn(float by) {

		_angle += _motor.turn(_angle, by);

	}

	public void move() {

		Vec2f chg = _motor.move(_velocity, _angle);

		_position.x += chg.x;
		_position.y += chg.y;

	}

}
