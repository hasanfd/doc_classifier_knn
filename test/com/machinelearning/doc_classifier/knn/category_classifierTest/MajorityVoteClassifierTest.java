package com.machinelearning.doc_classifier.knn.category_classifierTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.machinelearning.doc_classifier.knn.category_classifier.KNNCategoryClassifier;
import com.machinelearning.doc_classifier.knn.category_classifier.MajorityVoteClassifier;
import com.machinelearning.doc_classifier.knn.core.KNNClassificationInfo;

public class MajorityVoteClassifierTest {

	public List<KNNClassificationInfo> result = new ArrayList<KNNClassificationInfo>();
	public String[] categoryNames = {"economy","tech","sport","politics"};
	
	public MajorityVoteClassifierTest() {
		KNNClassificationInfo kci = new KNNClassificationInfo("sport1", "sport", "tech", 1.0d);
		result.add(kci);		
	}
	
	@Test
	public void givenOneClassificationInfoExpectReturnRightClassification() {
		KNNCategoryClassifier classifier = new MajorityVoteClassifier();
		String estimatedCategory = classifier.estimate(result, categoryNames, 3);
		assertEquals(estimatedCategory,"tech");
	}
	
	@Test
	public void givenManyClassificationInfoExpectReturnRightClassification() {
		KNNClassificationInfo kci1 = new KNNClassificationInfo("economy2", "economy", "economy", 2.0d);
		result.add(kci1);
		KNNClassificationInfo kci2 = new KNNClassificationInfo("politics1", "politics", "economy", 2.2d);
		result.add(kci2);
		KNNClassificationInfo kci3 = new KNNClassificationInfo("tech1", "tech", "tech", 1.2d);
		result.add(kci3);
		KNNClassificationInfo kci4 = new KNNClassificationInfo("tech2", "tech", "tech", 1.1d);
		result.add(kci4);
		
		KNNCategoryClassifier classifier = new MajorityVoteClassifier();
		String estimatedCategory = classifier.estimate(result, categoryNames, 3);
		assertEquals(estimatedCategory,"economy");
	}

}
