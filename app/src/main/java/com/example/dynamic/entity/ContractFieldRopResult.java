package com.example.dynamic.entity;

import java.io.Serializable;
import java.util.List;



    public class ContractFieldRopResult implements Serializable{

   
    private static final long serialVersionUID = 5059211459073343828L;

	private long id;
	
	private String field_value;
	
	private String name;
	
	private String field_type;
	
	private int orderby;
	
	private String result;
	
	private List<ContractFieldRopChild> children;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getField_value() {
		return field_value;
	}

	public void setField_value(String field_value) {
		this.field_value = field_value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField_type() {
		return field_type;
	}

	public void setField_type(String field_type) {
		this.field_type = field_type;
	}

	public int getOrderby() {
		return orderby;
	}

	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<ContractFieldRopChild> getChildren() {
		return children;
	}

	public void setChildren(List<ContractFieldRopChild> children) {
		this.children = children;
	}
	
	

	
	
}
