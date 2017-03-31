package com.machinelearning.doc_classifier.knn;

import java.io.File;
import java.io.FileNotFoundException;

import com.machinelearning.doc_classifier.document.DocumentCache;
import com.machinelearning.doc_classifier.document.FileDocumentCache;
import com.machinelearning.doc_classifier.knn.core.KNNClassifier;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String dirName = null;
		String []categoryNames = null;
		int numberOfFilesToTrainForEachCategory = 0;
		int k=1;
		
		String temp;
		
		for(String s : args) {
			if(s.startsWith("-Dir=")) {
				dirName = s.replaceAll("-Dir=",""); 
			}else if(s.startsWith("-categories=")) {
				s = s.replaceAll("-categories=", "");
				categoryNames = s.split(",");
			}else if(s.startsWith("-trainingSize=")) {
				temp = s.replaceAll("-trainingSize=", "");
				numberOfFilesToTrainForEachCategory = Integer.parseInt(temp);
			}else if(s.startsWith("-k=")) {
				temp = s.replaceAll("-k=", "");
				k = Integer.parseInt(temp);
			}
		}
		
		File directoryOfFiles = new File(dirName);
		DocumentCache documentCache = new FileDocumentCache(categoryNames, directoryOfFiles, numberOfFilesToTrainForEachCategory);		
		documentCache.cacheTrainingDocuments();
		documentCache.cacheTestDocuments();	
		
		KNNClassifier nc = new KNNClassifier(categoryNames, k, documentCache);
		nc.classify();
	}
}
