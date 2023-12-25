public class Vehicle implements IMotorWrapper {

	private IMotor _motor;

	private Vec2f _position;
	private float _velocity;
	private int _laps;

	public Vehicle(IMotor motor) {

		_motor = motor;

	}

	public IMotor getMotor() { return _motor; }

	@Override
	public void setWrappee(IMotor motor) {

		_motor = motor;

		if (motor instanceof MotorDecorator decorator) {
			decorator.setWrapper(this);
		}

	}

}
