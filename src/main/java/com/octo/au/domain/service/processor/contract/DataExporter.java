package com.octo.au.domain.service.processor.contract;

import java.io.IOException;
import java.util.List;

import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.ColumnTemplate;

public interface DataExporter {
	public boolean exportData(List<DataRow> dataRows, String targetFileName, List<ColumnTemplate> columnTemplates) throws IOException;
}