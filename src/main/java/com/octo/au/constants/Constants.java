/**
 * 
 */
package com.octo.au.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Amol Kshirsagar
 *
 */
public class Constants {
	public static String STR="String";
	public final static Charset ENCODING = StandardCharsets.UTF_8;
	public static final String STR_DELIMITER_METADATA_FILE = ",";  
	public static final String STR_CUSTOM_COMMENT_IDENTIFIER="######";
	public static final String STR_METADATA_FILE = "Metadata File";
	public static final String STR_DATA_FILE = "Data File";
	public static final String STR_USER_MESSAGE_FILENAME_INVALID = "Please check the input files for valid names";
	public static final String STR_USER_MESSAGE_NO_NEXTLINE_INPUTFILE = "Empty or invalid line in %s. Unable to process.";
	public static final String STR_METADATA_FILE_READ_COMPLETED = "Meta data file Read Completed";
	public static final String STR_METADATA_FILE_READ_INITIATED = "Meta data file Read Initiated";
	public static final String STR_DATA_FILE_READ_COMPLETED = "Data file Read Completed";
	public static final String STR_CSV_NAME = "OctoData.csv";
	public static final String STR_DATA_INCOMPLETE = "Mismatch between the metadata information and the data provided.Please verify";
	public static final String STR_EXCEPTION_WITH_INPUT_FILE = "Exception Occurred while reading %s named %s";
	public static final String STR_EXCEPTION_WITH_OUTPUT_FILE = "Exception Occurred while writing to csv file";
	public static final String STR_NO_FILE_FOUND = "No %s was found at the given location";
	public static final String STR_EMPTY_FILE = "File is empty.Please check contents";
	public static final String STR_DEFAULT_TARGET_DATEFORMAT = "dd/MM/YYYY";
	public static final String STR_DEFAULT_SOURCE_DATEFORMAT = "YYYY-MM-dd";
	public static final String STR_EMPTY = "";
	public static final String STR_NUMERIC = "numeric";
	public static final String STR_DATE = "date";
	public static final String STR_NULL_FILE = "Null file being sent";
	public static final String STR_NULL_METADATA_FILE = "Structure Obtained from metadata File is Null";
}
