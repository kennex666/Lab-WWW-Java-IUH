package entities;

public class Employee {
	private int id;
	
	private String name;
	
	private Address address;

	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void show() {
		System.out.println("Employee " + id + ", name=" + name + ", address=" + address + "]");
		System.out.println("Address" + getAddress().toString());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
