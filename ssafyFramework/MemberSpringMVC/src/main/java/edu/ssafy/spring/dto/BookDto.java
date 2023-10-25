package edu.ssafy.spring.dto;

public class BookDto {
	private String isbn,author,title,price,upfile;
	
	
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDto(String isbn, String author, String title, String price, String upfile) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.upfile = upfile;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUpfile() {
		return upfile;
	}

	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}

	@Override
	public String toString() {
		return "BookDto [isbn=" + isbn + ", author=" + author + ", title=" + title + ", price=" + price + ", upfile="
				+ upfile + "]";
	}
	
	
	
}
