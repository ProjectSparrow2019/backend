package br.com.sparrow.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Base {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Float price;
	private Float percentual;
	private String author;
	private String description;
	private String predict;
	private String link;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getPercentual() {
		return percentual;
	}
	public void setPercentual(Float percentual) {
		this.percentual = percentual;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPredict() {
		return predict;
	}
	public void setPredict(String predict) {
		this.predict = predict;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Base() {
	}
	
	public Base(Produto produto) {
		this.title = produto.getTitle();
		this.price = produto.getPrice();
		this.percentual = produto.getPercentual();
		this.author = produto.getAuthor();
		this.description = produto.getDescription();
		this.predict = produto.getPredict();
		this.link = produto.getLink();
	}
	
	public Base(String title, Float price, Float percentual, String author, String description,
			String predict, String link) {
		this.title = title;
		this.price = price;
		this.percentual = percentual;
		this.author = author;
		this.description = description;
		this.predict = predict;
		this.link = link;
	}
	
}
