package task;

import task.utils.InstructionsUtil;

import java.util.List;
import java.util.Objects;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/23/2020
 * @project tasks
 * <p>
 * ----------------------------------------------------------------------
 * <p>
 * <p>
 * Exercise 1
 * <p>
 * <p>
 * A robot lands on Mars, which happens to be a cartesian grid; assuming that we hand the robot these instructions,
 * such as LFFFRFFFRRFFF, where "L" is a "turn 90 degrees left", "R" is a "turn 90 degrees right", and "F" is "go forward one space,
 * please write control code for the robot such that it ends up at the appropriate-and-correct destination, and include unit tests.
 * <p>
 * Here is an example output with command "FF":
 * [0, 2]
 */

public class MarsRobot {

	public Coordinate calculateCoordinateAfterInstruction(final String instructions) {
		List<String> instructionArray = InstructionsUtil.convertInstructions(instructions);

		/* Based on the email that's sent it's safe to assume the default pole is North
		 *  because when the command of instructions were "FF" the result was  [0,2] */
		Pole currentPole = Pole.NORTH;

		// we assume the robot starts from the center
		Coordinate coordinate = new Coordinate(0, 0);

		for (int i = 0; i < instructionArray.size(); i++) {
			if (instructionArray.get(i).equals("L") || instructionArray.get(i).equals("R")) {
				currentPole = Pole.findChangedPole(currentPole, instructionArray.get(i));
			}
			if (instructionArray.get(i).equals("F")) {
				coordinate = decideCoordinateWhileMovingAlongTheGivenPole(coordinate, currentPole);
			}
		}
		return coordinate;

	}

	public Coordinate decideCoordinateWhileMovingAlongTheGivenPole(final Coordinate coordinate, final Pole currentPole) {
		Coordinate result;
		if (Objects.isNull(coordinate) || Objects.isNull(currentPole)) {
			throw new RuntimeException("Coordinate and currentPole can't be null");
		} else if (currentPole == Pole.NORTH) {
			result = new Coordinate(coordinate.getX(), coordinate.getY() + 1);
		} else if (currentPole == Pole.SOUTH) {
			result = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
		} else if (currentPole == Pole.EAST) {
			result = new Coordinate(coordinate.getX() + 1, coordinate.getY());
		} else if (currentPole == Pole.WEST) {
			result = new Coordinate(coordinate.getX() - 1, coordinate.getY());
		} else {
			throw new RuntimeException("Pole is not defined");
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new MarsRobot().calculateCoordinateAfterInstruction("FF"));
	}

}
