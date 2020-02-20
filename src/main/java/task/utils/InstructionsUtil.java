package task.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/23/2020
 * @project tasks
 */
public class InstructionsUtil {

	public static List<String> convertInstructions(final String instructions) {
		if (Objects.isNull(instructions) || instructions.isEmpty()) {
			throw new IllegalArgumentException("There should be at least one instruction!!! ");
		}
		//only operations should be allowed are Left, Right, Forward as the task requires
		Set<Character> allowedInstructions = new HashSet<>(Arrays.asList('R', 'L', 'F'));

		List<String> instructionArray = new ArrayList<>(instructions.length());
		for (int i = 0; i < instructions.length(); i++) {
			if (!allowedInstructions.contains(instructions.charAt(i))) {
				throw new IllegalArgumentException("Instruction list is not clear, check it again!!! ");
			} else {
				instructionArray.add(String.valueOf(instructions.charAt(i)));
			}
		}
		return instructionArray;
	}

}
