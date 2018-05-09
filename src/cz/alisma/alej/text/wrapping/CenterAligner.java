package cz.alisma.alej.text.wrapping;

import java.util.List;

public class CenterAligner implements Aligner {

	@Override
	public String format(List<String> words, int widthofline, int width) {
		StringBuilder result = new StringBuilder();	
		int difference = width - widthofline;
		int gaps = (difference/ 2) - (difference % 2);
		result.append(Repeat.repeat(' ', gaps));
		boolean first = true;
        for (String w : words) {
            if (!first) {
                result.append(" ");
            } else {
                first = false;
            }
            result.append(w);
        }
		return result.toString();
	}

}
