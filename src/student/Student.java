package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Course.Course;
import dataBase.CreateDataBase;
import dataBase.DBConnection;
import instructor.Instructor;

public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int payments;
	private String address;
	
	
	public Student(int id, String firstName, String lastName, String email, String phone, int payments,
			String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.payments = payments;
		this.address = address;
	}
	
	public Student() {
		super();
	}
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPayments() {
		return payments;
	}
	public void setPayments(int payments) {
		this.payments = payments;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	/**
	 * 
	 * @param id : student id to search
	 * @return : student if found , null if not
	 */
	
	public Student search (int id){
		
		
		
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		ResultSet rsltSet ;
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use CoursesCenter");
			pst.executeUpdate();
			
			//select course from data base
			pst=con.prepareStatement("SELECT * FROM student WHERE id=?");
			pst.setInt(1, id);
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				Student student = new Student();
				System.out.println(rsltSet.getInt("id"));
				student.setId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("firstName"));
				student.setFirstName(rsltSet.getString("firstName"));
				
				System.out.println(rsltSet.getString("lastName"));
				student.setLastName(rsltSet.getString("lastName"));
				
				System.out.println(rsltSet.getString("email"));
				student.setEmail(rsltSet.getString("email"));
				
				System.out.println(rsltSet.getString("phone"));
				student.setPhone(rsltSet.getString("phone"));
				
				
				System.out.println(rsltSet.getInt("payments"));
				student.setPayments(rsltSet.getInt("payments"));
				
				System.out.println(rsltSet.getString("address"));
				student.setAddress(rsltSet.getString("address"));

				return student;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

public List<Student> getAllStudents(){
		
        List<Student> list = new ArrayList<>();
		
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		ResultSet rsltSet ;
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use CoursesCenter");
			pst.executeUpdate();
			
			//select course from data base
			pst=con.prepareStatement("SELECT * FROM student ");
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				//create new Student to initialize returned date from rsltSet
				   Student student = new Student();
					System.out.println(rsltSet.getInt("id"));
					student.setId(rsltSet.getInt("id"));
					
					System.out.println(rsltSet.getString("firstName"));
					student.setFirstName(rsltSet.getString("firstName"));
					
					System.out.println(rsltSet.getString("lastName"));
					student.setLastName(rsltSet.getString("lastName"));
					
					System.out.println(rsltSet.getString("email"));
					student.setEmail(rsltSet.getString("email"));
					
					
					
					System.out.println(rsltSet.getString("phone"));
					student.setPhone(rsltSet.getString("phone"));
					
					
					System.out.println(rsltSet.getInt("payments"));
					student.setPayments(rsltSet.getInt("payments"));
					
					System.out.println(rsltSet.getString("address"));
					student.setAddress(rsltSet.getString("address"));
				
				list.add(student);
				System.out.println("list size = " + list.size());
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
				
	}
	
	
	
	
}
