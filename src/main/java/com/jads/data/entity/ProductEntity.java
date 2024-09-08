package com.jads.data.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * This class is our product entity class
 */
@Table("products")
public class ProductEntity {

    @Id
    Long id;

    @Column("OrderNo")
    String orderNo;

    @Column("ProductName")
    String productName;

    @Column("Price")
    double price;

    @Column("Quantity")
    int quantity;

    /**
     * ProductEntity default constructor
     */
    public ProductEntity() 
    {
        // default constructor
    }

    /**
     * ProductEntity Non default constructor
     * @param id
     * @param orderNo
     * @param productName
     * @param price
     * @param quantity
     */
    public ProductEntity(Long id, String orderNo, String productName, double price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters

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
