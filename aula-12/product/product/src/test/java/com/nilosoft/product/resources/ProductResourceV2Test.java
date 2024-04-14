package com.nilosoft.product.resources;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nilosoft.product.model.Product;
import com.nilosoft.product.servives.ProductServiceV2;

class ProductResourceTestV2 {

    @Mock
    private ProductServiceV2 productService;

    @InjectMocks
    private ProductResourceV1 productResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", "Description 1", 10.0, "img1.jpg"));
        productList.add(new Product(2L, "Product 2", "Description 2", 20.0, "img2.jpg"));

        Mockito.when(productService.findAll()).thenReturn(productList);

        ResponseEntity<List<Product>> response = productResource.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }

    @Test
    void testFindById() {
        Product product = new Product(1L, "Product 1", "Description 1", 10.0, "img1.jpg");

        Mockito.when(productService.findById(1L)).thenReturn(product);

        ResponseEntity<Product> response = productResource.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void testCreate() {
        Product product = new Product(1L, "Product 1", "Description 1", 10.0, "img1.jpg");

        Mockito.when(productService.save(product)).thenReturn(product);

        ResponseEntity<Product> response = productResource.create(product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void testUpdate() {
        Product existingProduct = new Product(1L, "Existing Product", "Existing Description", 50.0, "existing.jpg");
        Product updatedProduct = new Product(1L, "Updated Product", "Updated Description", 100.0, "updated.jpg");

        Mockito.when(productService.update(1L, updatedProduct)).thenReturn(updatedProduct);
        Mockito.when(productService.findById(1L)).thenReturn(existingProduct);

        ResponseEntity<Product> response = productResource.update(1L, updatedProduct);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
    }

    @Test
    void testDelete() {
        Mockito.doNothing().when(productService).delete(1L);

        productResource.delete(1L);

        Mockito.verify(productService, Mockito.times(1)).delete(1L);
    }

    @Test
    void testHandleNoSuchElementException() {
        NoSuchElementException exception = new NoSuchElementException("Produto não encontrado");

        ResponseEntity<String> response = productResource.handleNoSuchElementException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Produto não encontrado", response.getBody());
    }
}
