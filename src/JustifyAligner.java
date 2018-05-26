

import java.util.List;

public class JustifyAligner implements Aligner {
	@Override
	public String format(List<String> words, int widthofline, int width) {		
		StringBuilder result = new StringBuilder();	
		int number = words.size();
		int gaps = width - widthofline;
		int gapsbetweentwo = 0;
		int onemore = 0;
		if (number > 1) {
			onemore = gaps % (number - 1);		
			gapsbetweentwo = (gaps - (onemore))/ (number - 1);		
		} else {
			onemore = 0;
						
		}
		boolean first = true;
		int position = 1;
        for (String w : words) {        	
            if (!first) {
                result.append(" ");
            } else {
                first = false;
            }
            result.append(w);
            if (!(position == number)) {
            	result.append(Repeat.repeat(' ', gapsbetweentwo));
        	}
            position++;
            if (onemore > 0) {
            	result.append(" ");
            	onemore--;
            }
        }
        //result.append("|");
		return result.toString();
	}

}
