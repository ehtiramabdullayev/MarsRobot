package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/24/2020
 * @project simple-works
 */
public class CounterTest {
	@Test
	public void countUpWhenStartValueIsBelowZero() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Counter().countUp(-1, 5));
	}

	@Test
	public void countUpWhenEndValueIsBelowZero() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Counter().countUp(5, -1));
	}

	@Test
	public void countUpSuccessfulCaseFromZeroToFive() {
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
		Counter counter = new Counter();
		counter.countUp(0, 5);
		List<Integer> actualResult = counter.getIntegerList();
		Assertions.assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
	}


	@Test
	public void countUpSuccessfulCaseFromThreeToSeven() {
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
		Counter counter = new Counter();
		counter.countUp(3, 7);
		List<Integer> actualResult = counter.getIntegerList();
		Assertions.assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
	}


	@Test
	public void countUpAndDownWhenStartValueIsBelowZero() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Counter().countUpAndDown(-1, 5));
	}

	@Test
	public void countUpAndDownWhenEndValueIsBelowZero() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Counter().countUpAndDown(5, -1));
	}

	@Test
	public void countUpAndDownSuccessfulCaseFromZeroToFive() {
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0));
		Counter counter = new Counter();
		counter.countUpAndDown(0, 5);
		List<Integer> actualResult = counter.getIntegerList();
		Assertions.assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
	}

	@Test
	public void countUpAndDownSuccessfulCaseFromFourToNine() {
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4));
		Counter counter = new Counter();
		counter.countUpAndDown(4, 9);
		List<Integer> actualResult = counter.getIntegerList();
		Assertions.assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
	}
}
