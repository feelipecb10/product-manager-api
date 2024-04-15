package com.productmanager.api.model.dto;

import com.productmanager.api.model.dto.defaultdto.DefaultDTO;
import com.productmanager.api.model.entities.Product;
import com.productmanager.api.model.entities.Stock;

import java.math.BigDecimal;

public class StockDTO extends DefaultDTO {

    private long idStock;

    private Product product;

    private BigDecimal quantity;

    public StockDTO() {
    }

    public StockDTO(Stock entity) {
        super(entity);
        this.idStock = entity.getIdStock();
        this.product = entity.getProduct();
        this.quantity = entity.getQuantity();
    }

    public long getIdStock() {
        return idStock;
    }

    public void setIdStock(long idStock) {
        this.idStock = idStock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
