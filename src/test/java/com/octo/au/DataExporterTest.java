package com.octo.au;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.octo.au.domain.model.DataColumn;
import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.ColumnTemplate;
import com.octo.au.domain.service.processor.contract.DataExporter;
import com.octo.au.domain.service.processor.impl.DataExporterImpl;
import com.octo.au.exception.CustomException;

public class DataExporterTest {
    private DataExporter dataExporter;
    @Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		System.out.println("@BeforeClass: onceExecutedBeforeAll");
	}
	List<ColumnTemplate> ct;
	List<DataRow> dataRows = new ArrayList<DataRow>();
	@Before
	public void executedBeforeEach() {
		dataExporter = new DataExporterImpl();
		ColumnTemplate ct1 = new ColumnTemplate("Birth date",10,"date",0);
		ColumnTemplate ct2 = new ColumnTemplate("First name",15,"string",1);
		ColumnTemplate ct3 = new ColumnTemplate("Last name",15,"string",2);
		ColumnTemplate ct4 = new ColumnTemplate("Weight",6,"numeric",3);
		ct=Arrays.asList(ct1,ct2,ct3,ct4);
		
		DataRow dr1 = new DataRow();
		DataColumn dc1 = new DataColumn();
		dc1.setColumnIndex(0);
		dc1.setLength(10);
		dc1.setType("date");
		dc1.setValue("1970-01-01");
		DataColumn dc2 = new DataColumn();
		dc2.setColumnIndex(1);
		dc2.setLength(15);
		dc2.setType("string");
		dc2.setValue("Amol");
		DataColumn dc3 = new DataColumn();
		dc3.setColumnIndex(2);
		dc3.setLength(15);
		dc3.setType("string");
		dc3.setValue("Snith");
		DataColumn dc4 = new DataColumn();
		dc4.setColumnIndex(3);
		dc4.setLength(6);
		dc4.setType("numeric");
		dc4.setValue("81.5");
		dr1.addColumns(Arrays.asList(dc1,dc2,dc3,dc4));
		DataRow dr2 = new DataRow();
		dr2.addColumns(Arrays.asList(dc1,dc2,dc3,dc4));
		dataRows.add(dr1);
		dataRows.add(dr2);
	}

	@Test
	public void testFileCreation() throws Exception {
		assertTrue(dataExporter.exportData(dataRows, "DataExporterTest.csv", ct));
	}
	
	@Test
	public void testWithNullArguments() throws Exception {
		exceptionRule.expect(CustomException.class);
		exceptionRule.expectMessage("Null");
		dataExporter.exportData(null, null, null);
	}
	
	@Test
	public void testWithEmptyArguments() throws Exception {
		exceptionRule.expect(CustomException.class);
		exceptionRule.expectMessage("Empty");
		dataExporter.exportData(new ArrayList<DataRow>(), "DataExporterTest.csv", new ArrayList<ColumnTemplate>());
	}
}