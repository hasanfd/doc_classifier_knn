package com.machinelearning.doc_classifier.knn.core;

public class KNNClassificationInfo {
	
	private String fileName;
	private String realCategory;
	private String estimatedCategory;
	private boolean result;
	private Double similarity;
		
	public KNNClassificationInfo(String fileName, String realCategory, String estimatedCategory, Double similarity) {
		super();
		this.fileName = fileName;
		this.realCategory = realCategory;
		this.estimatedCategory = estimatedCategory;
		this.similarity = similarity;
		this.result = realCategory.compareTo(estimatedCategory) == 0;
	}
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRealCategory() {
		return realCategory;
	}
	public void setRealCategory(String realCategory) {
		this.realCategory = realCategory;
	}
	public String getEstimatedCategory() {
		return estimatedCategory;
	}
	public void setEstimatedCategory(String estimatedCategory) {
		this.estimatedCategory = estimatedCategory;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}
	
	@Override
	public String toString() {
		return "KNNResult [fileName=" + fileName + ", realCategory=" + realCategory + ", estimatedCategory="
				+ estimatedCategory + ", similarity=" + similarity + ", result=" + result + "]";
	}
	
}
