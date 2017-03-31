package com.machinelearning.doc_classifier.document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocumentFactory {

	public static Document create(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		return createForTest(sc);
	}

	private static Document createForTest(Scanner sc) {
		Document document = new Document();
		while(sc.hasNext()) {
			String s = sc.next();
			if(!document.getWordVector().containsKey(s)) {
				document.getWordVector().put(s, 1);
			}else {
				int c = document.getWordVector().get(s);
				c++;
				document.getWordVector().put(s, c);
			}
			document.increaseDistinctWordPosition();
		}
		sc.close();
		
		return document;	
	}
}
