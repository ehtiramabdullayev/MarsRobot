package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/24/2020
 * @project tasks
 */
public class PoleTest {

	@Test
	public void findChangedPoleWhenArgumentIsNotValid() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> Pole.findChangedPole(Pole.NORTH, "I"));
	}

	@Test
	public void findChangedPoleWhenArgumentIsEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> Pole.findChangedPole(Pole.NORTH, ""));
	}

	@Test
	public void findChangedPoleWhenArgumentIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> Pole.findChangedPole(Pole.NORTH, null));
	}

	@Test
	public void findPoleWhenCurrentPoleIsNORTHAndDirectionIsLeft() {
		Pole expectedPole = Pole.WEST;
		Pole resultPole = Pole.findChangedPole(Pole.NORTH, "L");
		Assertions.assertEquals(expectedPole, resultPole);
	}

	@Test
	public void findPoleWhenCurrentPoleIsWESTAndDirectionIsRight() {
		Pole expectedPole = Pole.NORTH;
		Pole resultPole = Pole.findChangedPole(Pole.WEST, "R");
		Assertions.assertEquals(expectedPole, resultPole);
	}
	@Test
	public void findPoleWhenCurrentPoleIsEASTAndDirectionIsRight() {
		Pole expectedPole = Pole.SOUTH;
		Pole resultPole = Pole.findChangedPole(Pole.EAST, "R");
		Assertions.assertEquals(expectedPole, resultPole);
	}
	@Test
	public void findPoleWhenCurrentPoleIsEASTAndDirectionIsLeft() {
		Pole expectedPole = Pole.NORTH;
		Pole resultPole = Pole.findChangedPole(Pole.EAST, "L");
		Assertions.assertEquals(expectedPole, resultPole);
	}
	@Test
	public void findPoleWhenCurrentPoleIsSOUTHAndDirectionIsLeft() {
		Pole expectedPole = Pole.EAST;
		Pole resultPole = Pole.findChangedPole(Pole.SOUTH, "L");
		Assertions.assertEquals(expectedPole, resultPole);
	}
}