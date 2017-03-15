package instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Course.Course;
import dataBase.CreateDataBase;
import dataBase.DBConnection;

public class Instructor {

	private int id ;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int sallary;
	private String address;
	private String Subject;
	
	public Instructor(){
		
	}
	
	
	public Instructor(int id, String firstName, String lastName, String email, String phone, int sallary,
			String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.sallary = sallary;
		this.address = address;
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
	public int getSallary() {
		return sallary;
	}
	public void setSallary(int sallary) {
		this.sallary = sallary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSubject(){
		return this.Subject;
	}
	public void settSubject(String subject){
		this.Subject=subject;
	}
	
	
	
	/**
	 * 
	 * @param subject : to filter instructor by specific subject
	 * @return list of instructor of this subject , null if not found
	 */
	public List<Instructor> filter (String subject){
		

		List<Instructor> list = new ArrayList<>();
		
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
			pst=con.prepareStatement("SELECT * FROM instructor WHERE subject=?");
			pst.setString(1, subject);
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				Instructor instructor = new Instructor();
				System.out.println(rsltSet.getInt("id"));
				instructor.setId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("subject"));
				instructor.settSubject(rsltSet.getString("subject"));
				
				System.out.println(rsltSet.getString("firstName"));
				instructor.setFirstName(rsltSet.getString("firstName"));
				
				System.out.println(rsltSet.getString("lastName"));
				instructor.setLastName(rsltSet.getString("lastName"));
				
				System.out.println(rsltSet.getString("mail"));
				instructor.setEmail(rsltSet.getString("mail"));
				
				
				
				System.out.println(rsltSet.getString("phone"));
				instructor.setPhone(rsltSet.getString("phone"));
				
				
				System.out.println(rsltSet.getInt("sallary"));
				instructor.setSallary(rsltSet.getInt("sallary"));
				
				System.out.println(rsltSet.getString("address"));
				instructor.setAddress(rsltSet.getString("address"));
				
				list.add(instructor);
			}
			return list;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
		
		
	}
	
	
	/**
	 * search for instructor in data base using id
	 *  
	 * @param id : instructor id
	 * @return instructor if found and null if not
	 */
	public Instructor search (int id){
		
		//connect to data base 
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
			pst=con.prepareStatement("SELECT * FROM instructor WHERE id=?");
			pst.setInt(1, id);
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			//create null instructor
			Instructor instructor = null;
			while (rsltSet.next()){
				
				//create new instructor to initialize returned date from rsltSet
			   instructor = new Instructor();
				System.out.println(rsltSet.getInt("id"));
				instructor.setId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("subject"));
				instructor.settSubject(rsltSet.getString("subject"));
				
				System.out.println(rsltSet.getString("firstName"));
				instructor.setFirstName(rsltSet.getString("firstName"));
				
				System.out.println(rsltSet.getString("lastName"));
				instructor.setLastName(rsltSet.getString("lastName"));
				
				System.out.println(rsltSet.getString("mail"));
				instructor.setEmail(rsltSet.getString("mail"));
				
				
				
				System.out.println(rsltSet.getString("phone"));
				instructor.setPhone(rsltSet.getString("phone"));
				
				
				System.out.println(rsltSet.getInt("sallary"));
				instructor.setSallary(rsltSet.getInt("sallary"));
				
				System.out.println(rsltSet.getString("address"));
				instructor.setAddress(rsltSet.getString("address"));
				
			}
			
			//check if id  found in database 
			if (instructor!=null){
				return instructor;
			}
			//instructor id not found
			else return null;
			
		}catch (Exception e) {
			System.err.println("error in instructor.java search method");
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	/**
	 * get all instructors in data base
	 * @return
	 */
	public List<Instructor> getAllInstructors(){
		
        List<Instructor> list = new ArrayList<>();
		
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
			pst=con.prepareStatement("SELECT * FROM instructor ");
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				//create new instructor to initialize returned date from rsltSet
				   Instructor instructor = new Instructor();
					System.out.println(rsltSet.getInt("id"));
					instructor.setId(rsltSet.getInt("id"));
					
					System.out.println(rsltSet.getString("subject"));
					instructor.settSubject(rsltSet.getString("subject"));
					
					System.out.println(rsltSet.getString("firstName"));
					instructor.setFirstName(rsltSet.getString("firstName"));
					
					System.out.println(rsltSet.getString("lastName"));
					instructor.setLastName(rsltSet.getString("lastName"));
					
					System.out.println(rsltSet.getString("mail"));
					instructor.setEmail(rsltSet.getString("mail"));
					
					
					
					System.out.println(rsltSet.getString("phone"));
					instructor.setPhone(rsltSet.getString("phone"));
					
					
					System.out.println(rsltSet.getInt("sallary"));
					instructor.setSallary(rsltSet.getInt("sallary"));
					
					System.out.println(rsltSet.getString("address"));
					instructor.setAddress(rsltSet.getString("address"));
				
				
				list.add(instructor);
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
				
	}
	
	
	public boolean delete (int id ){
		
		boolean deleted = new InsertInstructor().delete(id);
		return deleted;
	}
	
	
	
	
	
}
