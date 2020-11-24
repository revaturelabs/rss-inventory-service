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
# Getting started
* If you already have Docker Desktop with Kubernetes running on your machine with the nginx-ingress service skip to the setup files portion of this walkthrough
* You need to have Docker installed on your computer. Install Docker [here](https://docs.docker.com/get-docker/).
* If you are running windows Docker Desktop is your quickest option.
* Enable Kubernetes on Docker Desktop in settings.
* Install Helm on your machine if you are using Windows. This will allow for the quick installation of the nginx-ingress. [Helm](https://helm.sh/docs/intro/install/) [nginx-ingress](https://github.com/kubernetes/ingress-nginx).
* Once you have the nginx-ingress in your Kubernetes services use `kubctl apply -f rss-inventory-setup.yaml` to deploy this service


# Viewing Changes Locally for Testing
* You must have a Dockerhub account. Use `docker build -t yourdockerhub/rss-inventory-service .` to build the Docker image and push that image to your Dockerhub.
* Change the image target in the rss-inventory-setup.yaml in the deployment section to use the image from your Dockerhub that you just pushed.
* Use `kubctl apply -f rss-inventory-setup.yaml` to redeploy your new image.
