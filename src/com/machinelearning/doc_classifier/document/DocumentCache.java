package com.machinelearning.doc_classifier.document;

import java.util.Set;

public interface DocumentCache {
	
	void cacheTrainingDocuments();
	void cacheTestDocuments();
	Set<String> getTestDocumentNames();
	Set<String> getTrainDocumentNames();
	Document getTrainDocument(String documentName);
	Document getTestDocument(String documentName);

}
