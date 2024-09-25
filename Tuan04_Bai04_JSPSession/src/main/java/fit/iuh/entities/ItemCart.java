package fit.iuh.entities;

public class ItemCart {
	
	private Product product;
	
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemCart(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public ItemCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ItemCart [product=" + product + ", quantity=" + quantity + "]";
	}
	
	public double total() {
		return quantity * product.getPrice();
	}
}
