/**
 * 
 */
package com.octo.au.domain.service.processor.contract;

import java.io.File;
import java.io.IOException;

import com.octo.au.domain.model.format.Structure;

/**
 * @author Amol Kshirsagar
 *
 */
public interface TemplateProcessor {
  public Structure createStructureTemplates(File file) throws IOException;
}
