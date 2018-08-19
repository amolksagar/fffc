package com.octo.au.domain.service;

import java.io.IOException;

import com.octo.au.exception.CustomException;


public interface FileFormatConverterService {
	/**
	 * @param metadataFile
	 * @param datafile
	 * @throws IOException
	 * @throws CustomException 
	 * @throws Exception 
	 */
	void writeCsvFile(String metadataFile, String datafile) throws Exception;
}
