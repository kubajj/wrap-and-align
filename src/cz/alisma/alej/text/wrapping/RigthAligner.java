package cz.alisma.alej.text.wrapping;

import java.util.List;

public class RigthAligner implements Aligner {

	@Override
	public String format(List<String> words, int widthofline, int width) {
		StringBuilder result = new StringBuilder();	
		result.append(Repeat.repeat(' ', width - widthofline));
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
