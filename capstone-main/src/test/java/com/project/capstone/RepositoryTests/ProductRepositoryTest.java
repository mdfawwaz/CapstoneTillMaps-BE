package com.project.capstone.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.capstone.Entity.Product;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.service.ProductManagementService;

@SpringBootTest
public class ProductRepositoryTest {

    @InjectMocks
    private ProductManagementService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductById() {
        // Create a sample product
        Product sampleProduct = new Product();
        sampleProduct.setId(1L);
        sampleProduct.setName("Sample Product");

        // Define the behavior of the mock repository
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(sampleProduct));

        // Perform the test
        Product result = productService.getProduct(1L);

        // Assertions
        assertEquals(1L, result.getId());
        assertEquals("Sample Product", result.getName());
    }
}
