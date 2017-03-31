package com.machinelearning.doc_classifier.knn.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.machinelearning.doc_classifier.document.Document;
import com.machinelearning.doc_classifier.document.DocumentCache;
import com.machinelearning.doc_classifier.knn.Utils;
import com.machinelearning.doc_classifier.knn.category_classifier.KNNCategoryClassifier;
import com.machinelearning.doc_classifier.knn.category_classifier.MajorityVoteClassifier;
import com.machinelearning.doc_classifier.knn.similarity.CosineSimilarity;
import com.machinelearning.doc_classifier.knn.similarity.DocumentSimilarityMethod;

public class KNNClassifier {

	private static final Logger logger = Logger.getLogger( KNNClassifier.class.getName() );
	
	private String categoryNames[];
	private int k;
	private int numberOfFalseClassified = 0;
	private int numberOfTrueClassified = 0;
	
	private DocumentCache documentCache;
	
	private KNNCategoryClassifier categoryClassifier = new MajorityVoteClassifier();
	private DocumentSimilarityMethod documentSimilarityMethod = new CosineSimilarity();
	
	public KNNClassifier(String[] categoryNames, int k, DocumentCache documentCache) {
		this.categoryNames = categoryNames;
		this.k = k;
		this.documentCache = documentCache;
	}
	
	public KNNClassifier(String[] categoryNames, int k, DocumentCache documentCache, KNNCategoryClassifier categoryClassifier,DocumentSimilarityMethod documentSimilarityMethod) {
		this.categoryNames = categoryNames;
		this.k = k;
		this.documentCache = documentCache;
		this.categoryClassifier = categoryClassifier;
		this.documentSimilarityMethod = documentSimilarityMethod;
	}

	public void classify() {
		
		Set<String> testDocuments = documentCache.getTestDocumentNames();
		for(String testDocumentName : testDocuments) {
			long startTime = System.currentTimeMillis();
			
			Document testDocument = documentCache.getTestDocument(testDocumentName);
			List<KNNClassificationInfo> results = new ArrayList<KNNClassificationInfo>();
			
			Set<String> trainDocumentNames = documentCache.getTrainDocumentNames();
			for(String trainDocumentName : trainDocumentNames) {
				Document trainDocument = documentCache.getTrainDocument(trainDocumentName);
				double similarity = documentSimilarityMethod.calculateSimilarity(testDocument,trainDocument);
				
				KNNClassificationInfo classifierResult = new KNNClassificationInfo(trainDocumentName,
						Utils.getCategoryFromFileName(testDocumentName),
						Utils.getCategoryFromFileName(trainDocumentName),
						similarity);

				results.add(classifierResult);
			}

			String estimatedCategory = categoryClassifier.estimate(results,categoryNames,k);
			checkEstimation(estimatedCategory,testDocumentName);

			logger.log(Level.INFO, "Document \t {0} \t classified as \t {1}", new Object[]{testDocumentName,estimatedCategory});
					
			long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    logger.log(Level.INFO, "{0} classified in {1} ms", new Object[]{testDocumentName,elapsedTime});
		}
		
		printResults();
	}
	
	private void checkEstimation(String estimatedCategory,String documentName) {
		if(documentName.contains(estimatedCategory)) {
			numberOfTrueClassified++;
		}else{
			numberOfFalseClassified++;
		}
	}
	
	private void printResults() {
		
		double precision = 0.0d;
		if(numberOfFalseClassified == 0) {
			precision = 100.0d;
		}else if(numberOfTrueClassified == 0) {
			precision = 0.0d;
		}else {
			precision = (double)numberOfTrueClassified / (double)(numberOfTrueClassified + numberOfFalseClassified) * 100.0d;
		}
		
		logger.log(Level.INFO,"+: \t {0} \t -: \t {1} \t precision: \t %{2}" ,new Object[]{numberOfTrueClassified,numberOfFalseClassified,precision});
	}
}