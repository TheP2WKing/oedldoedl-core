package net.thep2wking.oedldoedlcore.util;

import java.util.List;
import java.util.Random;

/**
 * @author TheP2WKing
 */
public class ModRandomUtil {
	// select random element from a list
	public static <T> T selectRandom(Random random, List<T> list) {
		return list.get(random.nextInt(list.size()));
	}
}