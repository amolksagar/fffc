package com.octo.au;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.ColumnTemplate;
import com.octo.au.domain.model.format.Structure;
import com.octo.au.domain.service.processor.contract.DataProcessor;
import com.octo.au.domain.service.processor.impl.DataProcessorImpl;
import com.octo.au.exception.CustomException;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DataProcessorTest {
	 private DataProcessor dataProcessor;
	 private ClassLoader classLoader;
	 Structure structure = null;
	 @Rule
	 public ExpectedException exceptionRule = ExpectedException.none();
		@BeforeClass
		public static void onceExecutedBeforeAll() {
		}

		@Before
		public void executedBeforeEach() {
			dataProcessor = new DataProcessorImpl();
			classLoader = getClass().getClassLoader();
			ColumnTemplate ct1 = new ColumnTemplate("Birth date",10,"date",0);
			ColumnTemplate ct2 = new ColumnTemplate("First name",15,"string",1);
			ColumnTemplate ct3 = new ColumnTemplate("Last name",15,"string",2);
			ColumnTemplate ct4 = new ColumnTemplate("Weight",6,"numeric",3);
			structure = new Structure();
			structure.getCt().addAll(Arrays.asList(ct1,ct2,ct3,ct4));
		}
		
		@Test
		public void testValidOutputOnValidInput() throws Exception {
			List<DataRow> dataRows = dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("data.txt").getFile()), structure);
			assertNotNull(dataRows);
			assertFalse(dataRows.isEmpty());
			assertTrue(dataRows.size()==3);
		}

		@Test
		public void testInputDateFormat() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("Please specify valid date in format");
			dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("dataInvalidDateFormat.txt").getFile()), structure);
		}
		
		@Test
		public void testThousandsSeperator() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("Please specify valid data in Signed Integer format");
			dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("dataWithThousandsOperator.txt").getFile()), structure);
		}
		
		@Test
		public void testOneColumnInARowMissing() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("Mismatch between the metadata information and the data provided.Please verify");
			dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("dataColumnInARowMissing.txt").getFile()), structure);
		}
		
		@Test
		public void testSpecialCharacterInColumn() throws Exception {
			List<DataRow> dataRows = dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("data.txt").getFile()), structure);
			assertNotNull(dataRows);
			assertFalse(dataRows.isEmpty());
			assertTrue(dataRows.size()==3);
		}
		
		@Test
		public void testInvalidNumber() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("Please specify valid data in Signed Integer format");
			dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("dataWithInvalidNumber.txt").getFile()), structure);
		}
		
		@Test
		public void testNegativeDecimalNumber() throws Exception {
			List<DataRow> dataRows = dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("dataNegativeNumber.txt").getFile()), structure);
			assertNotNull(dataRows);
			assertFalse(dataRows.isEmpty());
			assertTrue(dataRows.size()==3);
		}
		
		@Test
		public void testWithSpecialCharacters() throws Exception {
			List<DataRow> dataRows = dataProcessor.getColumnsFromDataFile(new File(classLoader.getResource("dataWithSpecialCharacters.txt").getFile()), structure);
			assertNotNull(dataRows);
			assertFalse(dataRows.isEmpty());
			assertTrue(dataRows.size()==3);
		}
		
		@Test
		public void testWithNullArguments() throws Exception {
			exceptionRule.expect(CustomException.class);
			exceptionRule.expectMessage("Null");
			dataProcessor.getColumnsFromDataFile(null, null);
		}
}
