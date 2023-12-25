public interface IMotor {

	/**
	 * @return change in speed.
	 */
	float accelerate(float speed, float by);

	/**
	 * @return change in angle.
	 */
	float turn(float angle, float by);

	/**
	 * @return change in location.
	 */
	Vec2f move(float speed, float angle);

}
