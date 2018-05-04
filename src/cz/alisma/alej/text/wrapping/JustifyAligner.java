package cz.alisma.alej.text.wrapping;

import java.util.List;

public class JustifyAligner implements Aligner {
	@Override
	public String format(List<String> words, int widthofline, int width) {		
		StringBuilder result = new StringBuilder();	
		int number = words.size();
		int gaps = width - widthofline;
		int gapsbetweentwo = gaps / (number - 1);		
		boolean first = true;
		int position = 1;
        for (String w : words) {        	
            if (!first) {
                result.append(" ");
            } else {
                first = false;
            }
            result.append(w);
            if (!(position == number - 1)) {
            	result.append(Repeat.repeat(' ', gapsbetweentwo));
        	}
        }
		return result.toString();
	}

}
