package entities;

public class Product {
	private String id, name, imgPath;
	private int quantity;
	private double price;

	public String getId() {
		return id;
	}

	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(String id, String name, String imgPath, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.imgPath = imgPath;
		this.quantity = quantity;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", imgPath=" + imgPath + ", price=" + price + "]";
	}

}
