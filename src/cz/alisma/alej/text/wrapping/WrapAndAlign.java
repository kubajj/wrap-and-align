/*
 * MIT License
 * Copyright (c) 2017 Gymnazium Nad Aleji
 * Copyright (c) 2017 Vojtech Horky
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cz.alisma.alej.text.wrapping;

import java.util.Scanner;

public class WrapAndAlign {
	public static void main(String[] args) {
		int maxwidth = 0;
		Scanner input = new Scanner(System.in);
		ParagraphDetector pd = new ParagraphDetector(input);
		Aligner aligner = null;
		for (int i = 0; i < args.length; i++) {
			String position = args[i];
			String [] positions = new String[2];
			positions = position.split("=");
			switch (positions[0]) {
			case "--left":
				aligner = new LeftAligner();
				break;
			case "--right":
				aligner = new RigthAligner();
				break;
			case "--center":
				aligner = new CenterAligner();
				break;
			case "--centre":
				aligner = new CenterAligner();
				break;
			case "--justify":
				aligner = new JustifyAligner();
				break;
			case "-w":
				if (i + 1 == args.length) {
					System.out.println("You did not write a number after -w.");
					return;
				}
				maxwidth = Integer.parseInt(args[i + 1]);
				i++;
				break;
			case "--width":
				maxwidth = Integer.parseInt(positions[1]);
				break;
			default: 
				continue;
			}
			
		}/*
		switch (args[1].length()) {
		case 2:
			maxwidth = Integer.parseInt(args[2]);
			break;
		default:
			String[] deleni = args[1].split("=");
			maxwidth = Integer.parseInt(deleni[2]);
			break;
		}*/

		while (pd.hasNextParagraph()) {
			Paragraph para = pd.nextParagraph();
			LinePrinter line = new LinePrinter(System.out, maxwidth, aligner);
			while (para.hasNextWord()) {
				String word = para.nextWord();
				line.addWord(word);
			}
			line.flush();
			System.out.println();
		}
	}
}
