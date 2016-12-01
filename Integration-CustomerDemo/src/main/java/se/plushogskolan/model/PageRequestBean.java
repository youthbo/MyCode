package se.plushogskolan.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PageRequestBean {
	
	@QueryParam(value = "page")
	private int page;
	
	@QueryParam(value = "size")
	@DefaultValue("5")
	private int size;
	
	@QueryParam(value = "sort")
	@DefaultValue("asc")
	private String sort;

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public String getSort() {
		return sort;
	}
	
	

}
