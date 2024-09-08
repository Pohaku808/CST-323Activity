package com.jads.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.annotation.XmlElement;
//import jakarta.xml.bind.annotation.XmlRootElement;


//@XmlRootElement(name="products")
/**
 * This class is our product list
 */
public class ProductList 
{
	private List<ProductModel> products = new ArrayList<ProductModel>();
	
	/**
	 * Get list of products
	 * @return list of products
	 */
	@XmlElement(name="product")
	public List<ProductModel> getProducts()
	{
		return this.products;
	}
	
	/** 
	 * Set products
	 * @param products
	 */
	public void setProducts(List<ProductModel> products)
	{
		this.products = products;
	}
}
