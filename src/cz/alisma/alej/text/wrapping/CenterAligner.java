package cz.alisma.alej.text.wrapping;

import java.util.List;

public class CenterAligner implements Aligner {

	@Override
	public String format(List<String> words, int widthofline, int width) {
		StringBuilder result = new StringBuilder();	
		int difference = width - widthofline;
		int gaps = (difference - (difference % 2)) / 2;
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
        /*if (difference % 2 == 0) {
        	result.append(Repeat.repeat(' ', gaps) + "|");
        } else {
        	result.append(Repeat.repeat(' ', gaps + 1) + "|");
        }*/
		return result.toString();
	}

}
