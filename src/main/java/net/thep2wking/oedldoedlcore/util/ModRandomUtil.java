package net.thep2wking.oedldoedlcore.util;

import java.util.List;
import java.util.Random;

/**
 * @author TheP2WKing
 */
public class ModRandomUtil {
	public static Random RANDOM = new Random();

	// select random element from list
	public static <T> T selectRandom(Random r, List<T> list) {
		return list.get(r.nextInt(list.size()));
	}
}