package com.machinelearning.doc_classifier.knn.coreTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.Test;

import com.machinelearning.doc_classifier.document.Document;
import com.machinelearning.doc_classifier.document.DocumentCache;
import com.machinelearning.doc_classifier.documentTest.DocumentTest;
import com.machinelearning.doc_classifier.knn.core.KNNClassifier;

public class KNNClassifierTest {
	
	public MockDocumentCache documentCache = new MockDocumentCache();

	@Test
	public void classifyProperly() {
		
		class ClassificationFilter implements Filter {
	        boolean seen;
	        @Override
	        public boolean isLoggable(LogRecord record) {
	            if (record!=null && record.getMessage()!=null && record.getMessage().contains("precision:") ) {
	            	if( record.getParameters()[2].equals(50.0d)) {
		                seen = true;	
	            	}
	            }
	            return true;
	        }
	    }

	    Logger log = Logger.getLogger(KNNClassifier.class.getName());
	    ClassificationFilter tf = new ClassificationFilter();
	    log.setFilter(tf);
	    
	    try {
	    	String[] categoryNames =  {"politics","economy"};
			KNNClassifier knn = new KNNClassifier(categoryNames, 1, documentCache);
			knn.classify();		    	
	        assertTrue(tf.seen);
	    } finally {
	        log.setFilter(null);
	    }
	}
	
	class MockDocumentCache implements DocumentCache {

		@Override
		public void cacheTrainingDocuments() {
			// TODO Auto-generated method stub
		}

		@Override
		public void cacheTestDocuments() {
			// TODO Auto-generated method stub
		}

		@Override
		public Set<String> getTestDocumentNames() {
			Set<String> set = new HashSet<>();
			set.add("economy1");
			set.add("politics1");
			
			return set;
		}

		@Override
		public Set<String> getTrainDocumentNames() {
			Set<String> set = new HashSet<>();
			set.add("economy2");
			
			return set;
		}

		@Override
		public Document getTrainDocument(String documentName) {
			DocumentTest documentTest = new DocumentTest();
			Document document = documentTest.document;
			return document;
		}

		@Override
		public Document getTestDocument(String documentName) {
			DocumentTest documentTest = new DocumentTest();
			Document document = documentTest.document;
			return document;
		}
		
	}
}
