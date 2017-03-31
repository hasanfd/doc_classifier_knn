package com.machinelearning.doc_classifier.knn.category_classifier;

import java.util.List;

import com.machinelearning.doc_classifier.knn.core.KNNClassificationInfo;

public interface KNNCategoryClassifier {

	String estimate(List<KNNClassificationInfo> result,String[] categoryNames,int k);
}
