/**
 * 
 */
package com.octo.au.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Amol Kshirsagar
 *
 */
public class DataRow extends Row{
	private static final Logger logger = LoggerFactory.getLogger(DataRow.class);
	private List<DataColumn> columns = new ArrayList<DataColumn>();;
	/* (non-Javadoc)
	 * @see com.octo.au.domain.model.Row#rowIndex()
	 */
	
	
	   public void addColumn(DataColumn col){
		   columns.add(col);
	   }
	   
	   public void addColumns(List<DataColumn> cols){
		   columns.addAll(cols);
	   }

	   public void showItems(){
	      for (DataColumn col : columns) {
	    	  logger.debug("Index : " + col.getColumnIndex());
	    	  logger.debug(", Value : " + col.getValue());
	    	  logger.debug(", Length : " + col.getLength());
	    	  logger.debug(", Type : " + col.getType());
	      }		
	   }

	public List<DataColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<DataColumn> columns) {
		this.columns = columns;
	}	

}
