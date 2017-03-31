package com.machinelearning.doc_classifier.documentTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.machinelearning.doc_classifier.document.Document;

public class DocumentTest {

	public Document document = new Document();
	
	public DocumentTest() {
		HashMap<String,Integer> wordVector = new HashMap<>();
		wordVector.put("junit", 1);
		wordVector.put("is", 2);
		wordVector.put("great", 3);
		
		document.setWordVector(wordVector);
		document.setDistinctWordPosition(3);
	}
		
	@Test
	public void whenGetFrequencyOfAWordThatNotInVocabularyExpectNull() {
		Double f = document.getFrequencyOfWord("c#");
		assertNull(f);
	}
	
	@Test
	public void When_GetFrequencyOfAWordThatInVocabulary_Expect_RigthResult() {
		Double f = document.getFrequencyOfWord("junit");
		assertTrue("expected to be " + 1/3, f.equals(1.0/3.0));
	}
	
	@Test
	public void When_GetNormOfVocabulary_Expect_RigthResult() {
		Double norm1 = document.getNorm();
		Double norm2 = document.getNorm();
		assertEquals(norm1,norm2);
		assertTrue("excepted to be " + 1.247219128924647, norm1.equals(1.247219128924647d));
	}
}
