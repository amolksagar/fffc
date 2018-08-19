/**
 * 
 */
package com.octo.au.domain.model;

/**
 * @author Amol Kshirsagar
 *
 */
public class Column {
	int columnIndex;
	Object value;
	int length;
	public int getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
