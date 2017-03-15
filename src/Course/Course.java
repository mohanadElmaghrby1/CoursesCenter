package Course;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataBase.CreateDataBase;
import dataBase.DBConnection;
import instructor.Instructor;

public class Course {

	
	
	

	//course id 
	private int courseId;
	
	//instructor identity id
	private String instructorId;
	
	// course maximum number of student
	private int courseCapacity;
	
	//course teach hours
	private int courseHours;
	
	//course enroll price
	private int coursePrice;
	
	//course start date
	private Date courseStartDate;
	
	//course laporatory 
	private int courseLap;
	
	//course subject 
	private String courseSubject;
	
	//course free spaces 
	private int courseFreeSpaces;

	
	
	/**
	 * free constructor
	 */
	public Course(){
		
	}
	
	

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public int getCourseCapacity() {
		return courseCapacity;
	}

	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}

	public int getCourseHours() {
		return courseHours;
	}

	public void setCourseHours(int courseHours) {
		this.courseHours = courseHours;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public int getCourseLap() {
		return courseLap;
	}

	public void setCourseLap(int courseLap) {
		this.courseLap = courseLap;
	}

	public String getCourseSubject() {
		return courseSubject;
	}

	public void setCourseSubject(String courseSubject) {
		this.courseSubject = courseSubject;
	}

	public int getCourseFreeSpaces() {
		return courseFreeSpaces;
	}

	public void setCourseFreeSpaces(int courseFreeSpaces) {
		this.courseFreeSpaces = courseFreeSpaces;
	}

	/**
	 * 
	 * @param id : course id to search
	 * @return : Course if found , null if not
	 */
	
	public Course search (int id){
		
		
		
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
			pst=con.prepareStatement("SELECT * FROM course WHERE id=?");
			pst.setInt(1, id);
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				Course course = new Course();
				System.out.println(rsltSet.getInt("id"));
				course.setCourseId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("subject"));
				course.setCourseSubject(rsltSet.getString("subject"));
				
				System.out.println(rsltSet.getInt("instructorId"));
				course.setInstructorId(rsltSet.getString("instructorId"));
				
				System.out.println(rsltSet.getInt("price"));
				course.setCoursePrice(rsltSet.getInt("price"));
				
				System.out.println(rsltSet.getInt("capacity"));
				course.setCourseCapacity(rsltSet.getInt("capacity"));
				
				
				System.out.println(rsltSet.getInt("hours"));
				course.setCourseHours(rsltSet.getInt("hours"));
				
				System.out.println(rsltSet.getInt("lap"));
				course.setCourseLap(rsltSet.getInt("lap"));
				
				System.out.println(rsltSet.getInt("freeSpaces"));
				course.setCourseFreeSpaces(rsltSet.getInt("freeSpaces"));
				
				
				return course;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Course> getAllCourses(){
		
		List<Course> list = new ArrayList<>();
		
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
			pst=con.prepareStatement("SELECT * FROM course ");
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				Course course = new Course();
				System.out.println(rsltSet.getInt("id"));
				course.setCourseId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("subject"));
				course.setCourseSubject(rsltSet.getString("subject"));
				
				System.out.println(rsltSet.getInt("instructorId"));
				course.setInstructorId(rsltSet.getString("instructorId"));
				
				System.out.println(rsltSet.getInt("price"));
				course.setCoursePrice(rsltSet.getInt("price"));
				
				System.out.println(rsltSet.getInt("capacity"));
				course.setCourseCapacity(rsltSet.getInt("capacity"));
				
				
				System.out.println(rsltSet.getInt("hours"));
				course.setCourseHours(rsltSet.getInt("hours"));
				
				System.out.println(rsltSet.getInt("lap"));
				course.setCourseLap(rsltSet.getInt("lap"));
				
				System.out.println(rsltSet.getInt("freeSpaces"));
				course.setCourseFreeSpaces(rsltSet.getInt("freeSpaces"));
				
				
				
				list.add(course);
			}
			return list;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}
	
}
