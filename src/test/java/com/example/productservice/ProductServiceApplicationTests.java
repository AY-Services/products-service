package com.example.productservice;

import com.example.productservice.domain.dto.ProductDetails;
import com.example.productservice.domain.dto.ProductModel;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@RequiredArgsConstructor
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	/*
	this ObjectMapper is used to transform the object to JSON File @JsonIgnore, @JsonFormat, @JsonProperties
	 */
	private final ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	/* Why setProperties method ?
	Because we're using the mongoDb container we need to specify the mongoDb container url dynamically while running the
	test instead of using the url in the application.properties which's a local db now we're using the docker container url
	 */
	/*@DynamicPropertySource
	static void setProperties(@NotNull DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}*/




	@Test
	void shouldCreateProduct() throws Exception {
		ProductModel productModel = ProductModel.builder()
				.description("product 1 from Test")
				.price(BigDecimal.valueOf(12.33))
				.build();

		String productDetailsString = objectMapper.writeValueAsString(productModel);

		mockMvc.perform(MockMvcRequestBuilders
				.post("api/product/save")
				.contentType(MediaType.APPLICATION_JSON)
				.contentType(productDetailsString))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
