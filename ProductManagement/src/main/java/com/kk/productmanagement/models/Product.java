package com.kk.productmanagement.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String category;
    private Date create_date;
    private String description;
    private String image_filename;
    private String name;
    private double price;

    @Transient
    private MultipartFile imageFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_filename() {
		return image_filename;
	}

	public void setImage_filename(String image_filename) {
		this.image_filename = image_filename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public Product(int id, String brand, String category, Date create_date, String description, String image_filename,
			String name, double price, MultipartFile imageFile) {
		super();
		this.id = id;
		this.brand = brand;
		this.category = category;
		this.create_date = create_date;
		this.description = description;
		this.image_filename = image_filename;
		this.name = name;
		this.price = price;
		this.imageFile = imageFile;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", category=" + category + ", create_date=" + create_date
				+ ", description=" + description + ", image_filename=" + image_filename + ", name=" + name + ", price="
				+ price + ", imageFile=" + imageFile + ", getId()=" + getId() + ", getBrand()=" + getBrand()
				+ ", getCategory()=" + getCategory() + ", getCreate_date()=" + getCreate_date() + ", getDescription()="
				+ getDescription() + ", getImage_filename()=" + getImage_filename() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + ", getImageFile()=" + getImageFile() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

    // Getters and setters
    
}
