# Revature Swagg Shop
This repository holds the inventory microservice which handles:

- product creation*
- product retrieval
- product updates
- product deletion

*creates test products as well as adds new products

These requests are handled by a single **ProductController.**

Endpoints and methods are mapped out below.

#### Endpoints
VERB | URL | USE
--- | --- | ---
GET | /inventory/main | creates test products
GET | /inventory/product/{id} | gets product by id
GET | /inventory/product | gets a list of all the products
POST | /inventory/product | creates a new product
PUT | /inventory/product | updates a product
DELETE | /inventory/product/{id} | deletes a product by their id

#### Methods

``` java
public void getProductById()
```

> Creates test products.

``` java
public Product getProductById(@PathVariable Long id)
```

> Will return the product based on the given ID.

``` java
public List<Product> getAllProduct()
```

> Will return a list of all products.

``` java
public Product createProductById(@RequestBody Product product)
```

> Will create a new product.

``` java
public Product updateProduct(@RequestBody Product product)
```

> Will update a product.

``` java
public void deleteProductById(@PathVariable Long id)
```

> Will delete a product.

#### Product (model)

``` java
    private Long id;
    private String category;
    private String brand;
    private String name;
    private String description;
    private String model;
    private String image;
    private Integer quantity;
    private Integer unitPrice;
    private String color;

```
