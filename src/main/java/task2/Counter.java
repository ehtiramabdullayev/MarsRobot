package task2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ehtiram Etibarovich Abdullayev on 1/24/2020
 * @project tasks
 * <p>
 * Part 1:
 * <p>
 * Write a program that counts in sequential order
 * when given a start and end value - without using any iterative programming
 * loops, i.e. while, for, do, for-each, etc.
 * You can assume that both the start and end values will always be positive and that
 * the start value will always be less then the end value.
 * There should only be one method with the following signature:
 * <p>
 * void countUp(int start, int end) {
 * // All code exercise code should go here
 * }
 * Here is example output with start=0 and end=5:
 */
public class Counter {

	private final List<Integer> integerList = new ArrayList<>();

	public List<Integer> getIntegerList() {
		return integerList;
	}

	public void countUp(int start, int end) {
		if (start < 0 || end < 0) {
			throw new IllegalArgumentException("start and end values should be positive! ");
		}

		if (start > end) {
			return;
		}
		System.out.println(start);
		integerList.add(start);
		start = start + 1;
		countUp(start, end);

	}


	/**/
	public void countUpAndDown(int start, int end) {
		if (start < 0 || end < 0) {
			throw new IllegalArgumentException("start and end values should be positive! ");
		}
		System.out.println(start);
		integerList.add(start);
		if (end == start) {
			return;
		}
		countUpAndDown(start + 1, end);
		integerList.add(start);
		System.out.println(start);

	}

	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.countUpAndDown(0,5);
		System.out.println(counter.integerList);
//		new Counter().countUpAndDown(0, 5);
//		new Counter().countDown(0, 5);
	}
}
