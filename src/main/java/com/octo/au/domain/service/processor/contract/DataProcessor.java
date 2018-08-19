/**
 * 
 */
package com.octo.au.domain.service.processor.contract;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.List;

import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.Structure;

/**
 * @author Amol Kshirsagar
 *
 */
public interface DataProcessor {
  public List<DataRow> getColumnsFromDataFile(File file,Structure metadataStructure) throws FileNotFoundException;
}
