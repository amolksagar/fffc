/**
 * 
 */
package com.octo.au.domain.model.format;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amol Kshirsagar
 *
 */
public class Structure {
	List<ColumnTemplate> ct;
	/**
	 * 
	 */
	public Structure() {
		ct = new ArrayList<ColumnTemplate>();
	}
	public List<ColumnTemplate> getCt() {
		return ct;
	}
	public void setCt(List<ColumnTemplate> ct) {
		this.ct = ct;
	}
}
