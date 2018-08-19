/**
 * 
 */
package com.octo.au.domain.service.processor.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.octo.au.constants.Constants;
import com.octo.au.domain.model.format.ColumnTemplate;
import com.octo.au.domain.model.format.Structure;
import com.octo.au.domain.service.processor.contract.TemplateProcessor;
import com.octo.au.exception.CustomException;

/**
 * @author Amol Kshirsagar
 *
 */
public class TemplateProcessorImpl implements TemplateProcessor{
	
  public Structure createStructureTemplates(File file) throws FileNotFoundException{
	  if(file == null){
			 throw new CustomException(Constants.STR_NULL_FILE);
	   }
	  Structure structure = new Structure();
		try (Scanner scanner = new Scanner(file)) {
			int lineNumber = 0;
			while (scanner.hasNextLine()) {
				structure.getCt().add(processLine(scanner.nextLine(), lineNumber));
				lineNumber++;
			}
			if(lineNumber==0){
				throw new CustomException(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+String.format(Constants.STR_EXCEPTION_WITH_INPUT_FILE, Constants.STR_METADATA_FILE,file.getName())+" : "+String.format(Constants.STR_EMPTY_FILE));
			}
		}
		return structure;
	}

	private ColumnTemplate processLine(String aLine, int lineNumber) {
		ColumnTemplate columnTemplate = new ColumnTemplate();
		try (Scanner scanner = new Scanner(aLine)) {
			scanner.useDelimiter(Constants.STR_DELIMITER_METADATA_FILE);
			if (scanner.hasNext()) {
				String name = scanner.next();
				String length = scanner.next();
				String type = scanner.next();
				columnTemplate.setIndex(lineNumber);
				columnTemplate.setLength(Integer.valueOf(length));
				columnTemplate.setName(name);
				columnTemplate.setType(type);
			} 
		}
		return columnTemplate;
	}
}
