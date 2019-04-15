package org.gareth.webapp.beans;

public class Product {

	private String code;
	private String name;
	private String manufacturer;
	private String category;
	private float price;

	public Product() {

	}
	

	public Product(String code, String name,float price, String manufacturer, String category) {		
		this.code = code;
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
		this.category = category;
		
	}

//	public Product(String code, String name, float price) {
//		this.code = code;
//		this.name = name;
//		this.price = price;
//	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
