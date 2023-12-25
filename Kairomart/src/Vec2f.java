public class Vec2f {

	public float x;
	public float y;

	public Vec2f(float x, float y) {

		this.x = x;
		this.y = y;

	}

	public static Vec2f add(Vec2f v1, Vec2f v2) {

		return new Vec2f(
			v1.x + v1.x,
			v1.y + v2.y
		);

	}

	public static Vec2f sub(Vec2f v1, Vec2f v2) {

		return new Vec2f(
			v1.x - v2.x,
			v1.y - v2.y
		);

	}

}
