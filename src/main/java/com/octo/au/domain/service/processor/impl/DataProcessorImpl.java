/**
 * 
 */
package com.octo.au.domain.service.processor.impl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.octo.au.constants.Constants;
import com.octo.au.domain.model.DataColumn;
import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.ColumnTemplate;
import com.octo.au.domain.model.format.Structure;
import com.octo.au.domain.service.builder.RowBuilder;
import com.octo.au.domain.service.processor.contract.DataProcessor;
import com.octo.au.domain.validation.FieldValidator;
import com.octo.au.exception.CustomException;

/**
 * @author Amol Kshirsagar
 *
 */
public class DataProcessorImpl implements DataProcessor{
	 public List<DataRow> getColumnsFromDataFile(File file,Structure metadataStructure) throws FileNotFoundException {
		 if(file == null || metadataStructure==null){
			 throw new CustomException(file==null?Constants.STR_NULL_FILE:Constants.STR_NULL_METADATA_FILE);
		 }
		  List<DataRow> dataRows = new ArrayList<DataRow>();
			try(Scanner scanner = new Scanner(file)){ 
				int lineNumber=0;
				while (scanner.hasNextLine()) {
					List<DataColumn> dataColumns = new ArrayList<DataColumn>();
					int beginIndex = 0;
					String dataLine = scanner.nextLine();
					//TODO:Identify here if dataline.length<metadata columns length.If yes then search for CRLF
					int columnIndex = 0;
					for(ColumnTemplate ct : metadataStructure.getCt()){
						DataColumn dc = new DataColumn();
						dc.setColumnIndex(columnIndex);
						try {
							dc.setValue(dataLine.substring(beginIndex, beginIndex+ct.getLength()).trim());
						} catch (IndexOutOfBoundsException e) {
							throw new CustomException(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+String.format(Constants.STR_EXCEPTION_WITH_INPUT_FILE, Constants.STR_DATA_FILE,file.getName())+"."+Constants.STR_DATA_INCOMPLETE+" on line no. "+(lineNumber+1),e);
						}
						dc.setLength(ct.getLength());
						dc.setType((String)ct.getType());
						beginIndex=beginIndex+ct.getLength();
						dataColumns.add(dc);
						columnIndex++;
					}
					RowBuilder rb = new RowBuilder();
					dataRows.add(rb.buildDataRow(dataColumns));
					lineNumber++;
				}
				if(lineNumber==0){
					throw new CustomException(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+String.format(Constants.STR_EXCEPTION_WITH_INPUT_FILE, Constants.STR_DATA_FILE,file.getName())+" : "+String.format(Constants.STR_EMPTY_FILE));
				}
			}
			FieldValidator fv = new FieldValidator();
			fv.validate(dataRows,metadataStructure);
			return dataRows;
		}
}
