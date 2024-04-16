package com.productmanager.api.controller;

import com.productmanager.api.model.dto.ProductDTO;
import com.productmanager.api.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mock;
    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;

    @Test
    @WithMockUser
    public void testGetAllProducts() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/api/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @WithMockUser
    public void testGetProductById_WithValidId() throws Exception {
        Long id = 1L;
        mock.perform(MockMvcRequestBuilders.get("/api/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idProduct").value(id));
    }

    @Test
    @WithMockUser
    public void testGetProductById_WithInvalidId() throws Exception {
        Long id = -1L;
        mock.perform(MockMvcRequestBuilders.get("/api/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testSaveProduct() {
        ProductDTO productDTO = createProductDTO();
        ProductDTO savedProductDTO = createProductDTO();

        Mockito.when(productService.saveProduct(any(ProductDTO.class))).thenReturn(savedProductDTO);

        ResponseEntity<ProductDTO> response = productController.saveProduct(productDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedProductDTO, response.getBody());
    }

    @Test
    public void testUpdateProduct_ValidId() {
        Long productId = 1L;
        ProductDTO productDTO = createProductDTO();
        ProductDTO updatedProductDTO = createProductDTO();

        Mockito.when(productService.updateProduct(productId, productDTO)).thenReturn(updatedProductDTO);

        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, productDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProductDTO, response.getBody());
    }

    @Test
    public void testUpdateProduct_InvalidId() {
        Long productId = -1L;
        ProductDTO productDTO = createProductDTO();

        Mockito.when(productService.updateProduct(productId, productDTO)).thenReturn(null);

        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, productDTO);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    private ProductDTO createProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(1l);
        productDTO.setSku("SKU TEST");
        productDTO.setName("NAME TEST");
        productDTO.setDescription("DESCRIPTION TEST");
        productDTO.setPrice(BigDecimal.TEN);
        productDTO.setAvailableStock(BigDecimal.TEN);
        return productDTO;
    }

}
