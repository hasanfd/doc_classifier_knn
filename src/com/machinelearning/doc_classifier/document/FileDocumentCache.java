package com.machinelearning.doc_classifier.document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

import com.machinelearning.doc_classifier.knn.Utils;

public class FileDocumentCache implements DocumentCache{

	private String[] categoryNames;
	private File directoryOfFiles;
	private int numberOfFilesToTrainForEachCategory;
	
	private HashMap<String,Document> trainingDocuments = new HashMap<>();
	private HashMap<String,Document> testDocuments = new HashMap<>();
	
	public FileDocumentCache(String[] categoryNames,File directoryOfFiles,int numberOfFilesToTrainForEachCategory) {
		this.categoryNames = categoryNames;
		this.directoryOfFiles = directoryOfFiles;
		this.numberOfFilesToTrainForEachCategory = numberOfFilesToTrainForEachCategory;
	}
	
	public void cacheTrainingDocuments() {
		File[] testFiles = Utils.getAllTrainFiles(categoryNames, directoryOfFiles, numberOfFilesToTrainForEachCategory);
		for(File file : testFiles) {
			Document document = null;
			try {
				document = DocumentFactory.create(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			trainingDocuments.put(file.getName(), document);
		}
	}
	
	public void cacheTestDocuments()  {
		File[] testFiles = Utils.getAllTestFiles(categoryNames, directoryOfFiles, numberOfFilesToTrainForEachCategory);
		for(File file : testFiles) {
			Document document = null;
			try {
				document = DocumentFactory.create(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			testDocuments.put(file.getName(), document);
		}		
	}
	
	public Set<String> getTestDocumentNames() {
		return testDocuments.keySet();
	}
	
	public Set<String> getTrainDocumentNames() {
		return trainingDocuments.keySet();
	}
	
	public Document getTrainDocument(String fileName) {
		return trainingDocuments.get(fileName);
	}
	
	public Document getTestDocument(String fileName) {
		return testDocuments.get(fileName);
	}
}
