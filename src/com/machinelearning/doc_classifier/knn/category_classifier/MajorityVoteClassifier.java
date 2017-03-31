package com.machinelearning.doc_classifier.knn.category_classifier;

import java.util.List;

import com.machinelearning.doc_classifier.knn.core.KNNClassificationComparator;
import com.machinelearning.doc_classifier.knn.core.KNNClassificationInfo;

public class MajorityVoteClassifier implements KNNCategoryClassifier{

	@Override
	public String estimate(List<KNNClassificationInfo> results, String[] categoryNames, int k) {
		KNNClassificationComparator comparator = new KNNClassificationComparator();
		results.sort(comparator);
		
		int max = -1;
		String estimatedCategory = "";

		for(String currentCategory : categoryNames) {
			int countOfCurrentCategory = 0;
			for(int i = 0 ; i < results.size() && i < k ; i++ ) {
				if(results.get(i).getEstimatedCategory().equals(currentCategory)) {
					countOfCurrentCategory++;
				}
			}
			if(countOfCurrentCategory > max) {
				max = countOfCurrentCategory;
				estimatedCategory = currentCategory;
			}
		}

		return estimatedCategory;
	}

}
