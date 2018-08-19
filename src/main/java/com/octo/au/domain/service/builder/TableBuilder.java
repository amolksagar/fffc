/**
 * 
 */
package com.octo.au.domain.service.builder;

import java.util.ArrayList;
import java.util.List;

import com.octo.au.domain.model.Row;

/**
 * @author Amol Kshirsagar
 *
 */
public class TableBuilder {
	List<? super Row> rows  = new ArrayList<Row>();
	
	public TableBuilder(List<? extends Row> rows) {
		this.rows.addAll(rows);
	}

	public List<? super Row> getRows() {
		return rows;
	}

	public void setRows(List<? super Row> rows) {
		this.rows = rows;
	}
}
