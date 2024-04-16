package com.productmanager.api.model.dto;

import com.productmanager.api.model.dto.defaultdto.DefaultDTO;
import com.productmanager.api.model.entities.Product;
import com.productmanager.api.model.entities.Stock;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public class ProductDTO extends DefaultDTO {

    private long idProduct;

    @NotEmpty
    private String sku;

    @NotEmpty
    private String name;

    private String description;

    private BigDecimal price;

    private BigDecimal availableStock;

    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
        super(entity);
        this.idProduct = entity.getIdProduct();
        this.sku = entity.getSku();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        if (!entity.getStockList().isEmpty()) {
            this.availableStock = entity.getStockList()
                    .stream()
                    .map(Stock::getQuantity)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(BigDecimal availableStock) {
        this.availableStock = availableStock;
    }
}
