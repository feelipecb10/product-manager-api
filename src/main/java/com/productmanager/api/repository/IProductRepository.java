package com.productmanager.api.repository;

import com.productmanager.api.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
