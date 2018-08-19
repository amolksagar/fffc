package com.octo.au.domain.validation;

import java.util.List;

import com.octo.au.domain.model.DataRow;
import com.octo.au.domain.model.format.Structure;
import com.octo.au.exception.CustomException;

/**
 * @author Amol Kshirsagar
 *
 */
public interface DataValidator {
  public void validate(List<DataRow> dataRows,Structure metadataStructure) throws CustomException;
}