package entities;

public class Bill {
	private int id;
	private String fullname, address, payment;
	private double totalPrice;
	public Bill(int id, String fullname, String address, double totalPrice, String payment) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.totalPrice = totalPrice;
		this.payment = payment;
	}
	

	public Bill(String fullname, String address, double totalPrice, String payment) {
		super();
		this.fullname = fullname;
		this.address = address;
		this.totalPrice = totalPrice;
		this.payment = payment;
	}
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", fullname=" + fullname + ", address=" + address + ", totalPrice=" + totalPrice
				+ ", payment=" + payment + "]";
	}
	
	
}
