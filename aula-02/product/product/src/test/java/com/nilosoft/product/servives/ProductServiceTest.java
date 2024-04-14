package com.nilosoft.product.servives;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nilosoft.product.model.Product;
import com.nilosoft.product.repository.ProductRepository;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", "Description 1", 10.0, "img1.jpg"));
        productList.add(new Product(2L, "Product 2", "Description 2", 20.0, "img2.jpg"));

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.findAll();

        assertEquals(productList.size(), result.size());
        assertTrue(result.containsAll(productList));
    }

    @Test
    void testFindById() {
        Product product = new Product(1L, "Product 1", "Description 1", 10.0, "img1.jpg");

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.findById(1L);

        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    void testFindByIdNotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> productService.findById(1L));
    }

    @Test
    void testSave() {
        Product product = new Product(1L, "Product 1", "Description 1", 10.0, "img1.jpg");

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    void testDelete() {
        Long productId = 1L;

        doNothing().when(productRepository).deleteById(productId);

        productService.delete(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void testUpdate() {
        Product existingProduct = new Product(1L, "Existing Product", "Existing Description", 50.0, "existing.jpg");
        Product updatedProduct = new Product(1L, "Updated Product", "Updated Description", 100.0, "updated.jpg");

        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        Product result = productService.update(1L, updatedProduct);

        assertNotNull(result);
        assertEquals(updatedProduct, result);
    }

    @Test
    void testUpdateNotFound() {
        Product updatedProduct = new Product(1L, "Updated Product", "Updated Description", 100.0, "updated.jpg");

        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> productService.update(1L, updatedProduct));
    }
}
