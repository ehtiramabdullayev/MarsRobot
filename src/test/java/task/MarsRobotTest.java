package task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/24/2020
 * @project tasks
 */
public class MarsRobotTest {

	private MarsRobot marsRobot;


	@BeforeEach
	public void executedBeforeEach() {
		marsRobot = new MarsRobot();
	}

	@AfterEach
	public void executedAfterEach() {
		marsRobot = null;

	}

	@Test
	public void decideCoordinateWhileMovingAlongTheGivenPoleWhenPoleIsNull() {
		Coordinate coordinate = new Coordinate(0, 0);
		Assertions.assertThrows(RuntimeException.class,
				() -> marsRobot.decideCoordinateWhileMovingAlongTheGivenPole(coordinate, null));
	}

	@Test
	public void decideCoordinateWhileMovingAlongTheGivenPoleWhenPoleAndCoordinateIsNull() {
		Coordinate coordinate = null;
		Assertions.assertThrows(RuntimeException.class,
				() -> marsRobot.decideCoordinateWhileMovingAlongTheGivenPole(null, null));
	}

	@Test
	public void decideCoordinateWhileMovingAlongTheGivenPoleWhenPoleIsNorth() {
		Coordinate coordinate = new Coordinate(0, 0);
		Coordinate resultCoordinate = marsRobot.decideCoordinateWhileMovingAlongTheGivenPole(coordinate, Pole.NORTH);
		Assertions.assertEquals(1, resultCoordinate.getY());

	}

	@Test
	public void decideCoordinateWhileMovingAlongTheGivenPoleWhenPoleIsSouth() {
		Coordinate coordinate = new Coordinate(0, 0);
		Coordinate resultCoordinate = marsRobot.decideCoordinateWhileMovingAlongTheGivenPole(coordinate, Pole.SOUTH);
		Assertions.assertEquals(-1, resultCoordinate.getY());
	}

	@Test
	public void decideCoordinateWhileMovingAlongTheGivenPoleWhenPoleIsEast() {
		Coordinate coordinate = new Coordinate(0, 0);
		Coordinate resultCoordinate = marsRobot.decideCoordinateWhileMovingAlongTheGivenPole(coordinate, Pole.EAST);
		Assertions.assertEquals(1, resultCoordinate.getX());
	}

	@Test
	public void decideCoordinateWhileMovingAlongTheGivenPoleWhenPoleIsWest() {
		Coordinate coordinate = new Coordinate(0, 0);
		Coordinate resultCoordinate = marsRobot.decideCoordinateWhileMovingAlongTheGivenPole(coordinate, Pole.WEST);
		Assertions.assertEquals(-1, resultCoordinate.getX());
	}


	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsAreNotValid() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> marsRobot.calculateCoordinateAfterInstruction("nOtVaLid"));
	}

	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> marsRobot.calculateCoordinateAfterInstruction(""));
	}

	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> marsRobot.calculateCoordinateAfterInstruction(null));
	}


	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsAre_FF() {
		Coordinate expectedCoordinate = new Coordinate(0, 2);
		Coordinate resultCoordinate = marsRobot.calculateCoordinateAfterInstruction("FF");
		Assertions.assertEquals(expectedCoordinate, resultCoordinate);
	}

	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsAre_LFFRRFF() {
		Coordinate expectedCoordinate = new Coordinate(0, 0);
		Coordinate resultCoordinate = marsRobot.calculateCoordinateAfterInstruction("LFFRRFF");
		Assertions.assertEquals(expectedCoordinate, resultCoordinate);
	}

	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsAre_LFFRFF() {
		Coordinate expectedCoordinate = new Coordinate(-2, 2);
		Coordinate resultCoordinate = marsRobot.calculateCoordinateAfterInstruction("LFFRFF");
		Assertions.assertEquals(expectedCoordinate, resultCoordinate);
	}

	@Test
	public void calculateCoordinateAfterInstructionWhenInstructionsAre_LFFFRFFFRRFFF() {
		Coordinate expectedCoordinate = new Coordinate(-3, 0);
		Coordinate resultCoordinate = marsRobot.calculateCoordinateAfterInstruction("LFFFRFFFRRFFF");
		Assertions.assertEquals(expectedCoordinate, resultCoordinate);
	}
}
