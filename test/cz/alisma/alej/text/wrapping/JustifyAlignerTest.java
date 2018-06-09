package cz.alisma.alej.text.wrapping;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class JustifyAlignerTest {
	@Test
	public void justify() throws FileNotFoundException {
		List<String> words = new ArrayList<>();
		FileReader read = new FileReader("test.txt");
		Scanner test = new Scanner(read);
		while(test.hasNext()) {
			words.add(test.next());
		}
		assertEquals("﻿This   is   a   test   document   for   aligning.  I  think  that  this  is  ok.", JustifyAligner(words, 62, 80));
	}

	private Object JustifyAligner(List<String> words, int widthofline, int width) {
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
