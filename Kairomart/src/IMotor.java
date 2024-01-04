public interface IMotor {

	/**
	 * @return change in speed. by defines player input, 1 being acceleration, 0 maintaining the last speed, -1 being
	 * braking. speed in m/s
	 */
	float accelerate(float speed, float by);

	/**
	 * @return change in angle. by defines player input, 1 being turning left, 0 maintaining the angle and -1 being
	 * turning right. angle in radians.
	 */
	float turn(float angle, float by);

	/**
	 * @return change in location. speed in m/s, angle in radians.
	 */
	Vec2f move(float speed, float angle);

}
