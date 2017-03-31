package com.machinelearning.doc_classifier.knn;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File>{

	@Override
	public int compare(File o1, File o2) {
		return compareForTest(o1.getName(), o2.getName());
	}
	
	public int compareForTest(String s1,String s2) {
		int startOfNumber = s1.indexOf("-") + 1;
		int i1 = Integer.parseInt(s1.substring(startOfNumber, s1.length()));
		
		startOfNumber = s2.indexOf("-") + 1;
		int i2 = Integer.parseInt(s2.substring(startOfNumber, s2.length()));
		
		return i1 > i2 ? 1 : -1;
	}

}
