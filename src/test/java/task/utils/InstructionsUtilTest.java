package task.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/24/2020
 * @project tasks
 */
public class InstructionsUtilTest {

	@Test
	public void testConvertInstructionsWhenUnwantedCharacterIsInText() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> InstructionsUtil.convertInstructions("iLlEgAl"));
	}

	@Test
	public void testConvertInstructionsWhenInstructionIsEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> InstructionsUtil.convertInstructions(""));
	}

	@Test
	public void testConvertInstructionsWhenInstructionINull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> InstructionsUtil.convertInstructions(null));
	}

	@Test
	public void testConvertInstructionsWhenInstructionsArePassedSuccessfully() {
		String instructions = "LLRF";
		List<String> expectedResult = new ArrayList<>(Arrays.asList("L", "L", "R", "F"));
		List<String> result = InstructionsUtil.convertInstructions(instructions);
		Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
	}


}
