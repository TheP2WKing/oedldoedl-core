package net.thep2wking.oedldoedlcore.util;

import java.util.List;
import java.util.Random;

/**
 * @author TheP2WKing
 */
public class ModRandomUtil {
	public static final Random RANDOM = new Random();

	// select random element from a list
	public static <T> T selectRandom(Random random, List<T> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(random.nextInt(list.size()));
	}
	
	public static <T> T selectRandom(List<T> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		Random newRandom = new Random();
		return list.get(newRandom.nextInt(list.size()));
	}
}