package com.octo.au.domain.service;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.octo.au.constants.Constants;
import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.Structure;
import com.octo.au.domain.service.processor.contract.DataExporter;
import com.octo.au.domain.service.processor.contract.DataProcessor;
import com.octo.au.domain.service.processor.contract.TemplateProcessor;
import com.octo.au.domain.service.processor.impl.DataExporterImpl;
import com.octo.au.domain.service.processor.impl.DataProcessorImpl;
import com.octo.au.domain.service.processor.impl.TemplateProcessorImpl;
import com.octo.au.exception.CustomException;

public class FileFormatConverterServiceImpl implements FileFormatConverterService {
	private static final Logger logger = LoggerFactory.getLogger(FileFormatConverterServiceImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.octo.au.service.FileFormatConverterService#writeCsvFile(java.lang.
	 * String)
	 */
	@Override
	public void writeCsvFile(String metadataFile, String dataFile) throws Exception {
		
		if(StringUtils.isEmpty(metadataFile) || StringUtils.isEmpty(dataFile)){
			throw new CustomException(StringUtils.isEmpty(metadataFile)?Constants.STR_METADATA_FILE:Constants.STR_DATA_FILE+" is Empty");
		}
			File file = new File(metadataFile);
			logger.info(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+Constants.STR_METADATA_FILE_READ_INITIATED);
			TemplateProcessor templateProcessor = new TemplateProcessorImpl();
			Structure metadataStructure = null;
			metadataStructure = templateProcessor.createStructureTemplates(file);
			logger.info(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+Constants.STR_METADATA_FILE_READ_COMPLETED);
			File dataFileObj = new File(dataFile);
			logger.info(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+"Reading Data Lines Initiated");
			DataProcessor DataProcessor = new DataProcessorImpl();
			List<DataRow> dataRows = DataProcessor.getColumnsFromDataFile(dataFileObj,metadataStructure);
			dataRows.stream().forEach(dr -> dr.showItems());
			logger.info(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+Constants.STR_DATA_FILE_READ_COMPLETED);
		
			DataExporter dataExporter = new DataExporterImpl();
			dataExporter.exportData(dataRows,Constants.STR_CSV_NAME,metadataStructure.getCt());
	}
}
