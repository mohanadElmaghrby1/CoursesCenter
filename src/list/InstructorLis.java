package list;

import instructor.Instructor;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InstructorLis {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty subject;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty email;
	private SimpleStringProperty phone;
	private SimpleIntegerProperty sallary;
	private SimpleStringProperty address;
	
	
	
	
	
	
	
	public InstructorLis(Instructor instructor) {
		super();
		this.id = new SimpleIntegerProperty(instructor.getId());
		this.subject = new SimpleStringProperty(instructor.getSubject());
		this.firstName = new SimpleStringProperty(instructor.getFirstName());
		this.lastName = new SimpleStringProperty(instructor.getLastName());
		this.email = new SimpleStringProperty(instructor.getEmail());
		this.phone = new SimpleStringProperty(instructor.getPhone());
		this.sallary = new SimpleIntegerProperty(instructor.getSallary());
		this.address = new SimpleStringProperty(instructor.getAddress());
	}
	/**
	 * 
	 * setters and getters 
	 */
	public int getId() {
		return id.get();
	}
	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}
	public String getSubject() {
		return subject.get();
	}
	public void setSubject(SimpleStringProperty subject) {
		this.subject = subject;
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
	public void setLastName(SimpleStringProperty lastName) {
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
	public int getSallary() {
		return sallary.get();
	}
	public void setSallary(SimpleIntegerProperty sallary) {
		this.sallary = sallary;
	}
	public String getAddress() {
		return address.get();
	}
	public void setAddress(SimpleStringProperty address) {
		this.address = address;
	}
	
	

}
