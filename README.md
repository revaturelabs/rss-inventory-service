# rss-inventory-service
Revature Swag Shop Inventory Service
___________________________
Endpoints:

Post:
http://localhost:8989/product

Get By Id:
http://localhost:8989/product/id

Get All:
http://localhost:8989/product

Put:
http://localhost:8989/product

Delete:
http://localhost:8989/product/id

___________________________
Product POJO fields:

- private Long id;
- private String category;
- private String brand;	
- private String name;
- private String description;
- private String model;
- private String image;
- private Integer quantity;
- private BigDecimal unitPrice ;
- private String color;
