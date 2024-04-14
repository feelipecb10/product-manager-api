package com.productmanager.api.model.entities;

import com.productmanager.api.model.entities.defaultentity.DefaultEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class Stock extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstock")
    private long idStock;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

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
