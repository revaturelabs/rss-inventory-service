package com.revature.inventory.controller;

import com.revature.inventory.model.Product;
import com.revature.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/main")
    @ResponseStatus(value = HttpStatus.OK)
	public void getProductById() {
		// Creates test products
		productService.createProduct(new Product(123L, "Clothing", "Nike", "Hat", "A hat", "12x", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/A_fedora_hat%2C_made_by_Borsalino.jpg/1200px-A_fedora_hat%2C_made_by_Borsalino.jpg", 15, 200, "Black"));
		productService.createProduct(new Product(143L, "Clothing", "Nike", "Hoodie", "A hoodie", "12x", "https://s7d5.scene7.com/is/image/UrbanOutfitters/51246528_023_b?$xlarge$&fit=constrain&qlt=80&wid=683", 15, 200, "Black"));
		productService.createProduct(new Product(173L, "Clothing", "Nike", "Scarf", "A scarf", "12x", "https://agnesb-agnesb-com-storage.omn.proximis.com/Imagestorage/imagesSynchro/0/0/18b1cb5b02580c42e5e843801fa7cb272f984cac_1977AH91_460_1.jpeg", 15, 200, "Black"));
		productService.createProduct(new Product(153L, "Clothing", "Nike", "Headband", "A headband", "12x", "https://images.ulta.com/is/image/Ulta/2305485", 15, 200, "Black"));
		productService.createProduct(new Product(113L, "Electronics", "Sony", "TV", "A TV", "12x", "tv-pic.jpg", 15, 200, "Red"));
		productService.createProduct(new Product(113L, "Electronics", "Sony", "PS5", "A PS5", "12x", "shorts-pic.jpg", 15, 200, "Black"));
		productService.createProduct(new Product(113L, "Electronics", "Sony", "Headphones", "Some headphones", "12x", "shorts-pic.jpg", 15, 200, "Black"));
		productService.createProduct(new Product(113L, "Electronics", "Sony", "Gym Shorts", "Some gym shorts", "12x", "shorts-pic.jpg", 15, 200, "Black"));
	}
	

	@GetMapping("/product/{id}")
    @ResponseStatus(value = HttpStatus.OK)
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	@GetMapping("/product")
	public List<Product> getAllProduct() {
		return productService.findAllProducts();
	}

	@PostMapping("/product")
    @ResponseStatus(value = HttpStatus.CREATED)
	public Product createProductById(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/product")
    @ResponseStatus(value = HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/product/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
	}

}
