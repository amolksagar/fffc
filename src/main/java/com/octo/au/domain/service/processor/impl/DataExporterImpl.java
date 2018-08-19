package com.octo.au.domain.service.processor.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.octo.au.constants.Constants;
import com.octo.au.domain.model.DataColumn;
import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.ColumnTemplate;
import com.octo.au.domain.service.processor.contract.DataExporter;
import com.octo.au.exception.CustomException;
import com.octo.au.util.CSVUtils;
import com.octo.au.util.CommonUtility;

public class DataExporterImpl implements DataExporter {
	public boolean exportData(List<DataRow> dataRows, String targetFileName, List<ColumnTemplate> columnTemplates)
			throws IOException {
		if(dataRows ==null || targetFileName==null || columnTemplates==null){
			throw new CustomException(dataRows ==null?"Null rows obtained from data file":(targetFileName==null?"Invalid or Null File Name":(columnTemplates==null?"Column Metadata is Null":"")));
		}
		
		if(dataRows.isEmpty() ||columnTemplates.isEmpty()){
			throw new CustomException(dataRows.isEmpty()?"Empty rows obtained from data file":"Column Metadata is Empty");
		}
		FileWriter writer = new FileWriter(targetFileName);
		List<String> headers = new ArrayList<String>();
		for (ColumnTemplate ct : columnTemplates) {
			headers.add(ct.getName());
		}
		CSVUtils.writeLine(writer, headers);

		for (DataRow d : dataRows) {
			List<String> csvData = new ArrayList<>();
			for (DataColumn dc : d.getColumns()) {
				String formattedDate = Constants.STR_EMPTY;
				if (dc.getType() != null && dc.getType().equalsIgnoreCase("date")) {
					formattedDate = CommonUtility.dateFormatConverter((String) dc.getValue(),Constants.STR_DEFAULT_TARGET_DATEFORMAT);
					csvData.add(formattedDate);
				} else {
					csvData.add((String) dc.getValue());
				}
			}
			// CSVUtils.writeLine(writer, list);
			CSVUtils.writeLine(writer, csvData, ',', '\"');
		}
		writer.flush();
		writer.close();
		return true;
	}
}