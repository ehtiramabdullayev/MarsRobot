package task;

import java.util.Objects;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/23/2020
 * @project tasks
 */
public final class Coordinate {
	private final int x;
	private final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + x +
				"," + y + "]"
				;
	}

	//to compare in test classes we'll need it
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate))
			return false;
		Coordinate coordinate = (Coordinate) obj;
		return this.x == coordinate.x && this.y == coordinate.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
