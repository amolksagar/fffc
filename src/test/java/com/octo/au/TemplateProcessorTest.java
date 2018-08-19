package com.octo.au;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.octo.au.domain.model.format.Structure;
import com.octo.au.domain.service.processor.contract.TemplateProcessor;
import com.octo.au.domain.service.processor.impl.TemplateProcessorImpl;
import com.octo.au.exception.CustomException;

public class TemplateProcessorTest {
	 private TemplateProcessor templateProcessor;
	 private ClassLoader classLoader;
	 @Rule
	 public ExpectedException exceptionRule = ExpectedException.none();
	 
		@BeforeClass
		public static void onceExecutedBeforeAll() {
		}

		@Before
		public void executedBeforeEach() {
			templateProcessor = new TemplateProcessorImpl();
			classLoader = getClass().getClassLoader();
		}

		@Test
		public void testNonEmptyStructuredFile() throws Exception {
			Structure structure = templateProcessor.createStructureTemplates(new File(classLoader.getResource("testmetadata.csv").getFile()));
			assertNotNull(structure);
			assertNotNull(structure.getCt());
			assertFalse(structure.getCt().isEmpty());
			assertTrue(structure.getCt().size()==4);
		}
		
		@Test
		public void testEmptyFile() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("File is empty.Please check contents");
		    templateProcessor.createStructureTemplates(new File
		    		(classLoader.getResource("metadataEmpty.csv").getFile()));
		}
		
		@Test
		public void testStructuredFileWithSpecialChars() throws Exception {
			Structure structure = templateProcessor.createStructureTemplates(new File(classLoader.getResource("metadataWithSpecialCharacters.csv").getFile()));
			assertNotNull(structure);
			assertNotNull(structure.getCt());
			assertFalse(structure.getCt().isEmpty());
			assertTrue(structure.getCt().size()==4);
		}
		
		@Test
		public void testWithNullArguments() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("Null");
			templateProcessor.createStructureTemplates(null);
		}
}
