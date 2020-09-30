package com.revature.inventory.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "product_seq", initialValue = 1101)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private Long id;
	private String category;
	private String brand;
	private String name;
	private String description;
	private String model;
	private String image;
	private Integer quantity;
	@Column(name = "unit_price")
	private Integer unitPrice;
	private String color;
	private boolean discounted;
	@Column(name = "discounted_amount")
	private Integer discountedAmount;
	
	

	public Product() {
	}

	
	public Product(Long id, String category, String brand, String name, String description, String model, String image,
			Integer quantity, Integer unitPrice, String color) {
		super();
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.model = model;
		this.image = image;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.color = color;
	}


	public Product(Long id, String category, String brand, String name, String description, String model, String image,
			Integer quantity, Integer unitPrice, String color, boolean discounted, Integer discountedAmount) {
		super();
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.model = model;
		this.image = image;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.color = color;
		this.discounted = discounted;
		this.discountedAmount = discountedAmount;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitPrice() {
		if(this.discounted) {			
			return unitPrice - this.discountedAmount;
		}
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public boolean isDiscounted() {
		return discounted;
	}


	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}


	public Integer getDiscountedAmount() {
		return discountedAmount;
	}


	public void setDiscountedAmount(Integer discountedAmount) {
		this.discountedAmount = discountedAmount;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", brand=" + brand + ", name=" + name + ", description="
				+ description + ", model=" + model + ", image=" + image + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", color=" + color + ", discounted=" + discounted + ", discountedAmount="
				+ discountedAmount + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (discounted ? 1231 : 1237);
		result = prime * result + ((discountedAmount == null) ? 0 : discountedAmount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discounted != other.discounted)
			return false;
		if (discountedAmount == null) {
			if (other.discountedAmount != null)
				return false;
		} else if (!discountedAmount.equals(other.discountedAmount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

	
}


