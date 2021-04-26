package gameElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Axis {
	LEFT, TOP, RIGHT, BOTTOM;
	
	private static final List<Axis> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Axis randomAxis()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
