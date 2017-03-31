package com.machinelearning.doc_classifier.knn.similarity;

import com.machinelearning.doc_classifier.document.Document;

public interface DocumentSimilarityMethod {

	 double calculateSimilarity(Document testDocument,Document trainDocument);
	
}
