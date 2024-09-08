package com.jads.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jads.business.ProductBusinessService;
import com.jads.model.ProductModel;

/**
 * This controller handles our REST API Services
 */
@RestController
@RequestMapping("/service")
public class ProductRestController 
{
	@Autowired
	private ProductBusinessService service;
	
	/**
	 * Returns products as JSON
	 * @return List of products
	 */
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductsAsJson()
	{
		return service.getAllProducts();
	}
	
	/**
	 * Returns products as XML
	 * @return List of products
	 */
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public List<ProductModel> getProductsAsXml()
	{

		return service.getAllProducts();
	}
	
	/**
	 * Returns products as XML
	 * @return List of products
	 */
	@GetMapping(value="/products", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<ProductModel> getProducts()
	{
		return service.getAllProducts();
	}
	
	
	/**
	 * Returns a single product by ID as JSON
	 * @param id The id of the single product to retrieve
	 * @return List of products
	 */
	@GetMapping(path="/getproduct/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getProduct(@PathVariable("id") Long id)
	{
		try
		{ 
			ProductModel product = service.getProductById(id);
			if(product == null)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else
			{
				return new ResponseEntity<>(product, HttpStatus.OK);

			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
