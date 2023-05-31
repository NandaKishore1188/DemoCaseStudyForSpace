package com.capg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dto.ProductDTO;
import com.capg.entity.Product;
import com.capg.repository.ProductsRepository;
import com.capg.service.ProductServiceImpl;

@SpringBootTest
class ShoppingCartProductServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	 @Mock
	    private ProductsRepository productsRepository;

	    @InjectMocks
	    ProductServiceImpl productServiceImpl;

//	    @Before
//	    public void init() {
//	        MockitoAnnotations.initMocks(this);
//	    }

	    @Test
	    void isProductExistsById() {

	        Product product = new Product(300,"Test",20,5);
	        productsRepository.save(product);
	        Optional<Product> product1 =productsRepository.findById(300);
	        if(!product1.isEmpty()) {
	            Boolean actualResult = true;
	                    assertThat(actualResult).isTrue();
	        }
	    }

	    @Test
	    void getProductsDataByProductName(){
	        Product product = new Product(200,"Test",230,5);

	            productsRepository.save(product);
	            Optional<Product> actualResult = productsRepository.findByproductName("Test");
	            Boolean ac = actualResult.isEmpty();
	            assertThat(ac).isTrue();
	        }

	            @Test
	            public void getAllProductsDataTest()
	            {
	                List<Product> list = new ArrayList<Product>();
	                Product product1 = new Product(300,"Test300",300,25);
	                Product product2 = new Product(400,"Test400",200,35);
	                Product product3 =new Product(400,"Test400",100,35);


	                list.add(product1);
	                list.add(product2);
	                list.add(product3);

	                when(productsRepository.findAll()).thenReturn(list);

	                //test
	                List<ProductDTO> productsDataList = productServiceImpl.getAllProducts();

	                assertEquals(3, productsDataList.size());
	                verify(productsRepository, times(1)).findAll();
	            }
	
	    @Test
	    public void saveProductsTest()
	    {

	        Product product = new Product(200,"Test200",300,5);
	        productsRepository.save(product);
	        verify(productsRepository, times(1)).save(product);
	    }
	    @Test
	    public void deleteProductsTest()
	    {

	        Product product = new Product(200,"Test200",300,5);
	        productsRepository.deleteById(200);
	        verify(productsRepository, times(1)).deleteById(200);
	    }
	}


