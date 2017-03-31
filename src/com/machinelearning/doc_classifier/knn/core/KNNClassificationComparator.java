package com.machinelearning.doc_classifier.knn.core;

import java.util.Comparator;

public class KNNClassificationComparator implements Comparator<KNNClassificationInfo>{

	@Override
	public int compare(KNNClassificationInfo o1, KNNClassificationInfo o2) {
		return o2.getSimilarity().compareTo(o1.getSimilarity());
	}

}
