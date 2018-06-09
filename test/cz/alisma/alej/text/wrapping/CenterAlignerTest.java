package cz.alisma.alej.text.wrapping;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class CenterAlignerTest {
	@Test
	public void center() throws FileNotFoundException {
		List<String> words = new ArrayList<>();
		FileReader read = new FileReader("test.txt");
		Scanner test = new Scanner(read);
		while(test.hasNext()) {
			words.add(test.next());
		}
		assertEquals("         ﻿This is a test document for aligning. I think that this is ok.", CenterAligner(words, 62, 80));
	}

	private Object CenterAligner(List<String> words, int widthofline, int width) {
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
