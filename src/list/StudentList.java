package list;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import student.Student;

public class StudentList {


	
	private SimpleIntegerProperty id;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty email;
	private SimpleStringProperty phone;
	private SimpleIntegerProperty payments;
	private SimpleStringProperty address;
	
	public StudentList( Student student){
		this.id = new SimpleIntegerProperty(student.getId());
		this.firstName = new SimpleStringProperty(student.getFirstName());
		this.lastName = new SimpleStringProperty(student.getLastName());
		this.email = new SimpleStringProperty(student.getEmail());
		this.phone = new SimpleStringProperty(student.getPhone());
		this.payments = new SimpleIntegerProperty(student.getPayments());
		this.address = new SimpleStringProperty(student.getAddress());
	}
	
	
	
	
	//setter and getter
	public int getId() {
		return id.get();
	}
	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName.get();
	}
	public void setLastNAme(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email.get();
	}
	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(SimpleStringProperty phone) {
		this.phone = phone;
	}
	public int getPayments() {
		return payments.get();
	}
	public void setPayments(SimpleIntegerProperty payments) {
		this.payments = payments;
	}
	public String getAddress() {
		return address.get();
	}
	public void setAddress(SimpleStringProperty address) {
		this.address = address;
	}
	
	
}
