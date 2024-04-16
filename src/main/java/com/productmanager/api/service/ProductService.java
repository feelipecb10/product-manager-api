package com.productmanager.api.service;

import com.productmanager.api.model.dto.ProductDTO;
import com.productmanager.api.model.entities.Product;
import com.productmanager.api.model.entities.Stock;
import com.productmanager.api.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<ProductDTO> findAllProducts() {
        return toDTO(productRepository.findAll());
    }

    public ProductDTO findProductById(Long idProduct) {
        return toDTO(productRepository.findById(idProduct)
                .orElse(null));
    }

    public ProductDTO saveProduct(ProductDTO product) {
        Product entity = toEntity(product);
        if (entity.getIdProduct() != 0l) {
            Optional<Product> productOptional = productRepository.findById(entity.getIdProduct());
            if (productOptional.isPresent()) {
                entity = productOptional.get();
                List<Stock> stockList = entity.getStockList();
                Stock stock = new Stock();
                stock.setProduct(entity);
                stock.setQuantity(product.getAvailableStock());
                stockList.add(stock);
                entity.setStockList(stockList);
            }
        }
        return toDTO(productRepository.save(entity));
    }

    public ProductDTO updateProduct(Long idProduct, ProductDTO product) {
        Optional<Product> productOptional = productRepository.findById(idProduct);
        if (productOptional.isPresent()) {
            Product entity = toEntity(product);
            return toDTO(productRepository.save(entity));
        }
        return null;
    }

    public void deleteProduct(Long idProduct) {
        productRepository.deleteById(idProduct);
    }

    public Product toEntity(ProductDTO dto) {
        return toEntity(new Product(), dto);
    }

    public Product toEntity(Product entity, ProductDTO dto) {
        entity.setIdProduct(dto.getIdProduct());
        entity.setSku(dto.getSku());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        Stock stock = new Stock();
        stock.setQuantity(dto.getAvailableStock());
        stock.setProduct(entity);
        entity.setStockList(List.of(stock));
        return entity;
    }

    public List<ProductDTO> toDTO(List<Product> entityList) {
        return entityList.stream().collect(Collectors.mapping(ProductDTO::new, Collectors.toList()));
    }

    public ProductDTO toDTO(Product entity) {
        return entity == null ? null : new ProductDTO(entity);
    }

}
