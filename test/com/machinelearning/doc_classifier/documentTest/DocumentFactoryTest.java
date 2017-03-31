package com.machinelearning.doc_classifier.documentTest;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.Test;

import com.machinelearning.doc_classifier.document.Document;
import com.machinelearning.doc_classifier.document.DocumentFactory;

public class DocumentFactoryTest {

	public DocumentFactory documentFactory = new DocumentFactory();
		
	public Document createVocabulary(StringBuilder sb) throws Exception {
				
		Scanner scanner = new Scanner(sb.toString());
		
		Class<?>[] args = new Class[1];
		args[0] = Scanner.class;
				
		Method method = DocumentFactory.class.getDeclaredMethod("createForTest",args);
		method.setAccessible(true);
		Document document = (Document) method.invoke(documentFactory, scanner);
		
		return document;
	}
	
	@Test
	public void vocabularyCreatedProperly() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("junit ");
		sb.append("is ");
		sb.append("great ");
		sb.append("is ");
		sb.append("great ");
		
		Document document = createVocabulary(sb);
		assertNotNull(document);		
	}
	
	@Test
	public void whenTextIsEmptyThenDocumentCreatedEmpty() throws Exception {
		StringBuilder sb = new StringBuilder();				
		Document document = createVocabulary(sb);
		assertEquals(document.getDistinctWordPosition(), 0);
		assertEquals(document.getWordVector().size(), 0);
	}
	
}
