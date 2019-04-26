package org.gareth.webapp.beans;

public class ProductReview {
	
	String user;
	String code;
	String message;
	String star;
	String manufacturer;
	String name;
	
	public ProductReview() {
		super();
	}

	public ProductReview(String user, String code, String message, String star) {
		super();
		this.user = user;
		this.code = code;
		this.message = message;
		this.star = star;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
