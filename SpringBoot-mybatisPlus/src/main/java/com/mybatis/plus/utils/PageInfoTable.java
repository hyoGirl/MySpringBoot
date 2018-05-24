package com.mybatis.plus.utils;

import java.util.List;

public class PageInfoTable<T> {
	
	private List<T> rows;
	
	private long total;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageInfoTable [rows=" + rows + ", total=" + total + "]";
	}
	
	
	
}
