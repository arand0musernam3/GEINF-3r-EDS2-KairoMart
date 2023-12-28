
public class AdaptabilityDecorator extends MotorDecorator {

	private float _adaptability;

	public AdaptabilityDecorator(IMotor motor, float adaptability) {
		super(motor);

		_adaptability = adaptability;

	}

	@Override
	public float accelerate(float speed, float by) {

		float inc = super.accelerate(speed, by);

		return inc * _adaptability;
	}

	@Override
	public float turn(float angle, float by) {

		float inc = super.turn(angle, by);

		return inc * _adaptability;
	}

	@Override
	public Vec2f move(float speed, float angle) {

		Vec2f inc = super.move(speed, angle);
		inc.x *= _adaptability;
		inc.y *= _adaptability;

		return inc;
	}

}
