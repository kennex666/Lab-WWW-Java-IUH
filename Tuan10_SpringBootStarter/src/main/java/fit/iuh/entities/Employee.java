package fit.iuh.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotNull(message = "First name cannot be NULL")
	@NotEmpty(message = "First name cannot be EMPTY")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "Last name cannot be NULL")
	@NotEmpty(message = "Last name cannot be EMPTY")
	private String lastName;
	
	private String gender;

	@Column(name = "email")
	@NotNull(message = "Email cannot be NULL")
	@NotEmpty(message = "Email cannot be EMPTY")
	private String emailAddress;

	@Column(name = "phone_number")
	@Pattern(regexp = "\\^(0[\\d]{9})$", message = "Phone number need to valid with format 0xxxxxxxxx (10 digits include 0)")
	private String phoneNumber;
	
	@Past(message="DOB need to be lesser than today")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="address_id", referencedColumnName = "id")
	@JsonIgnore
	private Address address;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id,
			@NotNull(message = "First name cannot be NULL") @NotEmpty(message = "First name cannot be EMPTY") String firstName,
			@NotNull(message = "Last name cannot be NULL") @NotEmpty(message = "Last name cannot be EMPTY") String lastName,
			String gender,
			@NotNull(message = "Email cannot be NULL") @NotEmpty(message = "Email cannot be EMPTY") String emailAddress,
			@Pattern(regexp = "\\^(0[\\d]{9})$", message = "Phone number need to valid with format 0xxxxxxxxx (10 digits include 0)") String phoneNumber,
			@Past(message = "DOB need to be lesser than today") Date dob, Date createdDate, Date modifiedDate,
			Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", address=" + address + "]";
	}
	
	
	
	
}
