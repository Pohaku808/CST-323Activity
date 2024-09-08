package com.jads.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jads.business.ProductBusinessService;
import com.jads.model.ProductModel;

import jakarta.validation.Valid;

/**
 * Controller for our stores products page
 */
@Controller
@RequestMapping("/products")
public class ProductsController 
{
	@Autowired
	private ProductBusinessService service;
	public List<ProductModel> productsInv = new ArrayList<ProductModel>();

	/**
	 * This displays all your products on the products page
	 * @param model
	 * @return Display products page
	 */
	@GetMapping("/display")
	public String showProductsForm(Model model) 
	{
		productsInv = service.getAllProducts();

		model.addAttribute("productInv", productsInv);
		
		model.addAttribute("title", "Product Inventory");
		

		return "products";
	}
	
	
    /**
     * This redirects to the new product page to add a new product
     * @param model
     * @return Display new product form page
     */
    @GetMapping("/newproduct")
    public String showNewProductForm(Model model) 
    {
        model.addAttribute("productModel", new ProductModel(0L, null, null, 0, 0));
        return "newproduct";
    }

    /**
     * When the user submits the form to create a new product this method is called 
     * and the new product is added to the sql database.
     * @param productModel The new product the user created
     * @param result
     * @param model
     * @return Display the products page
     */
    @PostMapping("/doProduct")
    public String addNewProduct(@Valid @ModelAttribute("productModel") ProductModel productModel, BindingResult result, Model model) 
    {
        if (result.hasErrors()) 
        {
            return "newproduct";
        }

        boolean check = service.createProduct(productModel);
        
        if(check == true)
        {
    		System.out.println("Add a product worked");
            // Display products page
    		return "redirect:/products/display";
        }
        else
        {
    		System.out.println("Something went wrong when adding a new product");
            return "newproduct";

        }
    }
    
    /**
     * This method deletes a product by id. The user can delete a selected product.
     * @param id The id of the product to delete
     * @return Redirect back to the products page
     */
    @PostMapping("/delete/{id}")
    //@PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) 
    {
        boolean check = service.deleteProductById(id);;
        
        if(check == true)
        {
    		System.out.println("Delete a product worked");

        }
        else
        {
    		System.out.println("Something went wrong when deleting a product");

        }
        
        return "redirect:/products/display";
    }
    
    
    /**
     * This method displays the update a product form.
     * @param id The id of the product the user wants to update
     * @param model
     * @return Display the update a product form.
     */
    @GetMapping("/update/{id}")
   // @GetMapping("/products/update/{id}")
    public String showUpdateProductForm(@PathVariable Long id, Model model) 
    {
        ProductModel product = service.getProductById(id);
        product.setId(id);
        model.addAttribute("product", product);
        return "updateProduct";
    }
    
    
    /**
     * This method updates the existing product with whatever changes the user made.
     * @param id
     * @param updatedProduct The product to be updated
     * @param result
     * @return If product was successfully updated redirect back to the products page, if not stay on update product form to fix errors or try again
     */
    @PostMapping("/update/{id}")
    //@PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute("product") ProductModel updatedProduct, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "updateProduct";
        }
        
    	updatedProduct.setId(id);
    	boolean check = service.updateProduct(updatedProduct);
    	
        if(check == true)
        {
    		System.out.println("Update a product worked");
            return "redirect:/products/display";
        }
        else
        {
    		System.out.println("Something went wrong when updating a product");
            return "updateProduct";

        }
  
    }

	
  
}
