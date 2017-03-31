package com.machinelearning.doc_classifier.document;

import java.util.HashMap;
import java.util.Set;

public class Document {
	
	private int distinctWordPosition = 0;
	private HashMap<String,Integer> wordVector;
	private Double norm;
	
	public Document() {
		wordVector = new HashMap<>();
	}
	
	public Document(int distinctWordPosition, HashMap<String, Integer> wordVector) {
		this.distinctWordPosition = distinctWordPosition;
		this.wordVector = wordVector;
	}

	public Double getFrequencyOfWord(String s) {
		if(!wordVector.containsKey(s)) {
			return null;
		}
		
		double count = (double)wordVector.get(s);		
		return count / (double)distinctWordPosition;		
	}
	
	public double getNorm() {
		if(norm != null) {
			return norm;
		}
		
		Set<String> keySet = wordVector.keySet();
		double sum = 0.0d;
		for(String key : keySet) {
			double d = getFrequencyOfWord(key);
			d *= d;
			sum += d;
		}		
		norm = Math.sqrt(sum);
		
		return norm;
	}

	public void increaseDistinctWordPosition() {
		distinctWordPosition++;
	}
	
	public void setDistinctWordPosition(int distinctWordPosition) {
		this.distinctWordPosition = distinctWordPosition;
	}

	public void setWordVector(HashMap<String, Integer> wordVector) {
		this.wordVector = wordVector;
	}

	public int getDistinctWordPosition() {
		return distinctWordPosition;
	}

	public HashMap<String,Integer> getWordVector() {
		return wordVector;
	}
}