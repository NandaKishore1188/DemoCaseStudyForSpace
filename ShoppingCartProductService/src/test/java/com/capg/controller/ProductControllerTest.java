package com.capg.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.capg.dto.ProductDTO;
import com.capg.service.ProductService;
import com.capg.service.SequenceGeneratorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @MockBean
    private SequenceGeneratorService sequenceGeneratorService;

    /**
     * Method under test: {@link ProductController#save(ProductDTO)}
     */
    @Test
    void testSave() throws Exception {
        when(productService.addProducts((ProductDTO) any())).thenReturn(new ProductDTO());
        when(sequenceGeneratorService.getSequenceNumber((String) any())).thenReturn(10);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(123);
        productDTO.setProductName("Product Name");
        productDTO.setProductPrice(10.0d);
        productDTO.setProductQuantity(1);
        String content = (new ObjectMapper()).writeValueAsString(productDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"productId\":null,\"productName\":null,\"productPrice\":0.0,\"productQuantity\":0}"));
    }
}

