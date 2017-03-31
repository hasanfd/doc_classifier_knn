package com.machinelearning.doc_classifier.knnTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.machinelearning.doc_classifier.knn.FileComparator;

public class FileComparatorTest {

	public FileComparator fileComparator = new FileComparator();
	
	@Test
	public void When_FirstFileNameGreaterThanSecondFileName_Expect_CompareReturnsOne() {
		int i = fileComparator.compareForTest("tech-2", "tech-1");
		assertTrue("excepted to be less than",i == 1);
	}
		
	@Test
	public void When_FirstFileNameLessThanSecondFileName_Expect_CompareReturnsMinusOne() {
		int i = fileComparator.compareForTest("tech-1", "tech-2");
		assertTrue("excepted to be less than",i == -1);
	}
}
