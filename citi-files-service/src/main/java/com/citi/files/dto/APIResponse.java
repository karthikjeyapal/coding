/**
 * copyright
 */
package com.citi.files.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {

	private String linesCount;
	private String columnCount;
	private String message;

	public String getLinesCount() {
		return linesCount;
	}

	public void setLinesCount(String linesCount) {
		this.linesCount = linesCount;
	}

	public String getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(String columnCount) {
		this.columnCount = columnCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
