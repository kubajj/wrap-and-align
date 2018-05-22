

public class Repeat {
	public static String repeat(char repeat, int number) {
		String ret = "";
		while (number > 0) {
			number--;
			ret += repeat;
		}
		return ret;
	}
}
