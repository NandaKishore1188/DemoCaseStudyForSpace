package com.capg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capg.dto.ProductDTO;
import com.capg.entity.Product;
import com.capg.repository.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @MockBean
    private ProductsRepository productsRepository;

    /**
     * Method under test: {@link ProductServiceImpl#addProducts(ProductDTO)}
     */
    @Test
    void testAddProducts() {
        Product product = new Product();
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        product.setProductQuantity(1);
        when(productsRepository.save((Product) any())).thenReturn(product);
        ProductDTO actualAddProductsResult = productServiceImpl.addProducts(new ProductDTO());
        assertEquals(123, actualAddProductsResult.getProductId().intValue());
        assertEquals(1, actualAddProductsResult.getProductQuantity());
        assertEquals(10.0d, actualAddProductsResult.getProductPrice());
        assertEquals("Product Name", actualAddProductsResult.getProductName());
        verify(productsRepository).save((Product) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#addProducts(ProductDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddProducts2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.capg.dto.ProductDTO.getProductId()" because "productDTO" is null
        //       at com.capg.entity.Product.<init>(Product.java:44)
        //       at com.capg.service.ProductServiceImpl.addProducts(ProductServiceImpl.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        Product product = new Product();
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        product.setProductQuantity(1);
        when(productsRepository.save((Product) any())).thenReturn(product);
        productServiceImpl.addProducts(null);
    }

    /**
     * Method under test: {@link ProductServiceImpl#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        when(productsRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(productServiceImpl.getAllProducts().isEmpty());
        verify(productsRepository).findAll();
    }

    /**
     * Method under test: {@link ProductServiceImpl#getAllProducts()}
     */
    @Test
    void testGetAllProducts2() {
        Product product = new Product();
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        product.setProductQuantity(1);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productsRepository.findAll()).thenReturn(productList);
        List<ProductDTO> actualAllProducts = productServiceImpl.getAllProducts();
        assertEquals(1, actualAllProducts.size());
        ProductDTO getResult = actualAllProducts.get(0);
        assertEquals(123, getResult.getProductId().intValue());
        assertEquals(1, getResult.getProductQuantity());
        assertEquals(10.0d, getResult.getProductPrice());
        assertEquals("Product Name", getResult.getProductName());
        verify(productsRepository).findAll();
    }

    /**
     * Method under test: {@link ProductServiceImpl#getAllProducts()}
     */
    @Test
    void testGetAllProducts3() {
        Product product = new Product();
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        product.setProductQuantity(1);

        Product product1 = new Product();
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductPrice(10.0d);
        product1.setProductQuantity(1);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(productsRepository.findAll()).thenReturn(productList);
        List<ProductDTO> actualAllProducts = productServiceImpl.getAllProducts();
        assertEquals(2, actualAllProducts.size());
        ProductDTO getResult = actualAllProducts.get(0);
        assertEquals(1, getResult.getProductQuantity());
        ProductDTO getResult1 = actualAllProducts.get(1);
        assertEquals(1, getResult1.getProductQuantity());
        assertEquals(10.0d, getResult1.getProductPrice());
        assertEquals("Product Name", getResult1.getProductName());
        assertEquals(123, getResult1.getProductId().intValue());
        assertEquals(10.0d, getResult.getProductPrice());
        assertEquals("Product Name", getResult.getProductName());
        assertEquals(123, getResult.getProductId().intValue());
        verify(productsRepository).findAll();
    }

    /**
     * Method under test: {@link ProductServiceImpl#deleteProductById(Integer)}
     */
    @Test
    void testDeleteProductById() {
        Product product = new Product();
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        product.setProductQuantity(1);
        Optional<Product> ofResult = Optional.of(product);
        doNothing().when(productsRepository).delete((Product) any());
        when(productsRepository.findById((Integer) any())).thenReturn(ofResult);
        productServiceImpl.deleteProductById(123);
        verify(productsRepository).findById((Integer) any());
        verify(productsRepository).delete((Product) any());
        assertTrue(productServiceImpl.getAllProducts().isEmpty());
    }

    /**
     * Method under test: {@link ProductServiceImpl#deleteProductById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteProductById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.uti`l.Optional.orElseThrow(Optional.java:377)
        //       at com.capg.service.ProductServiceImpl.deleteProductById(ProductServiceImpl.java:76)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(productsRepository).delete((Product) any());
        when(productsRepository.findById((Integer) any())).thenReturn(Optional.empty());
        productServiceImpl.deleteProductById(123);
    }
}

