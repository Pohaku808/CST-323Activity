package com.jads.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * This class is our product model
 */
public class ProductModel {
	
    private Long id;
    
	@NotNull(message = "OrderNo is required")
	@Size(min = 1, max = 10, message = "Order Number must be between 1 and 10 characters")
    private String orderNo;
    
	@NotNull(message = "Product Name is required")
	@Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String productName;
    
	@NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    @DecimalMax(value = "9999.99", message = "Price must be less than or equal to 9999.99")
    private double price;
    
	@NotNull(message = "Quanity is required")
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    @Max(value = 1000, message = "Quantity must be less than or equal to 100")
    private int quantity;

    /**
     * ProductModel non-default constructor
     */
    public ProductModel(Long id, String orderNo, String productName, double price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    //getters and setters
    
    /**
     * Get Id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set Id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get order Number
     * @return order number
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * Set order number
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * get product name
     * @return product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set product name
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get Quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
