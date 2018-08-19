package com.octo.au;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.octo.au.constants.Constants;
import com.octo.au.domain.service.FileFormatConverterService;
import com.octo.au.domain.service.FileFormatConverterServiceImpl;

public class FixedFileFormatter{
	private static final Logger logger = LoggerFactory.getLogger(FixedFileFormatter.class);
    public static void main(String[] args) throws Exception {
    	FileFormatConverterService fffcService = new FileFormatConverterServiceImpl();
        logger.info(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+"File Writing Initiated");
        fffcService.writeCsvFile(args[0],args[1]);
        logger.info(Constants.STR_CUSTOM_COMMENT_IDENTIFIER+"File Writing Successful");
    }
}