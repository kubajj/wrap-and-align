package cz.alisma.alej.text.wrapping;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class RightAlignerTest {
	@Test
	public void right() throws FileNotFoundException {
		List<String> words = new ArrayList<>();
		FileReader read = new FileReader("test.txt");
		Scanner test = new Scanner(read);
		while(test.hasNext()) {
			words.add(test.next());
		}
		assertEquals("                  ﻿This is a test document for aligning. I think that this is ok.", RightAligner(words, 62, 80));
	}

	private Object RightAligner(List<String> words, int widthofline, int width) {
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
        //result.append("|");
		return result.toString();
	}

	
}
