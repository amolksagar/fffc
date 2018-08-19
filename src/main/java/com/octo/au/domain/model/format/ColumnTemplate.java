/**
 * 
 */
package com.octo.au.domain.model.format;

/**
 * @author Amol Kshirsagar
 *
 */
public class ColumnTemplate {
	/**
	 * @param name
	 * @param length
	 * @param type
	 * @param index
	 */
	public ColumnTemplate(String name, int length, Object type, int index) {
		super();
		this.name = name;
		this.length = length;
		this.type = type;
		this.index = index;
	}

	public ColumnTemplate() {
	}

	private String name;
	private int length;
	private Object type;
	private int index;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
