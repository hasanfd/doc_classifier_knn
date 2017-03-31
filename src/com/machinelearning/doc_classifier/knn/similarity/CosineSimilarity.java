package com.machinelearning.doc_classifier.knn.similarity;

import java.util.Set;

import com.machinelearning.doc_classifier.document.Document;

public class CosineSimilarity implements DocumentSimilarityMethod{

	@Override
	public double calculateSimilarity(Document testDocument, Document trainDocument) {
		Set<String> keySetOfTestDocument = testDocument.getWordVector().keySet();
		double similarity = 0.0d;
		for(String s : keySetOfTestDocument) {
			if(trainDocument.getWordVector().containsKey(s)) {
				similarity += testDocument.getFrequencyOfWord(s) + trainDocument.getFrequencyOfWord(s);
			}
		}
		similarity /= (testDocument.getNorm() + trainDocument.getNorm());
		
		return similarity;
	}

}
