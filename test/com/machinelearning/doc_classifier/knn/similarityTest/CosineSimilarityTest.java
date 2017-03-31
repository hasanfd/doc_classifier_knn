package com.machinelearning.doc_classifier.knn.similarityTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.machinelearning.doc_classifier.document.Document;
import com.machinelearning.doc_classifier.documentTest.DocumentTest;
import com.machinelearning.doc_classifier.knn.similarity.CosineSimilarity;
import com.machinelearning.doc_classifier.knn.similarity.DocumentSimilarityMethod;

public class CosineSimilarityTest {

	private DocumentSimilarityMethod cosineSimilarity = new CosineSimilarity();

	@Test
	public void Given_OneEmptyDocument_Then_CalculateSimilarityZero() {
		DocumentTest dt1 = new DocumentTest();
		Document document1 = dt1.document;
		Document document2 = new Document();
		Double d = cosineSimilarity.calculateSimilarity(document1, document2);
		assertEquals(d, new Double(0));
	}
	
	@Test
	public void Given_TwoEqualDocument_Then_CalculateSimilarityRight() {
		DocumentTest dt1 = new DocumentTest();
		Document document1 = dt1.document;
		DocumentTest dt2 = new DocumentTest();
		Document document2 = dt2.document;
		
		Double d = cosineSimilarity.calculateSimilarity(document1, document2);
		assertEquals(d,new Double(1.6035674514745464d));
	}
}
