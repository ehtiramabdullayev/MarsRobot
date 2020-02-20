package task;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/23/2020
 * @project tasks
 */
public enum Pole {

	NORTH(0), // y will be increased,
	SOUTH(2), // y will be decreased,
	WEST(3), // x will be decreased
	EAST(1); // x will be increased

	private static final Map<Integer, Pole> poleMap = new HashMap<>();
	private final int code;

	static {
		for (Pole pole : Pole.values())
			poleMap.put(pole.getCode(), pole);
	}


	Pole(Integer code) {
		this.code = code;
	}

	public static Pole getByCode(Integer code) {
		return poleMap.get(code);
	}

	public int getCode() {
		return this.code;
	}

	public static Pole findChangedPole(final Pole currentPole, final String direction) {
		Pole result;
		int finalStanding = 0;

		if ("R".equals(direction)) {
			finalStanding = currentPole.getCode() + 1;
		} else if ("L".equals(direction)) {
			finalStanding = currentPole.getCode() - 1;
		} else {
			throw new IllegalArgumentException("Not a valid direction, it can be only 'L' OR 'R'");
		}

		if (finalStanding > 3) {
			result = getByCode((finalStanding - 4));
		} else if (finalStanding < 0) {
			result = getByCode(Math.abs(4 + finalStanding));
		} else {
			result = getByCode(finalStanding);
		}

		return result;
	}

}