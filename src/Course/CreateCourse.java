package Course;

/**
 * insert course data base
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import dataBase.CreateDataBase;
import dataBase.DBConnection;

/**
 * 
 * @author mohanad-elmaghrby
 *
 */
public class CreateCourse {

	
	/**
	 * free constructor
	 */
	public CreateCourse(){
		
	}
	
	

	
	/**
	 * insert new course to data base
	 * @param course : object to save into database
	 */
	public void saveCourse (Course course){
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use CoursesCenter");
			pst.executeUpdate();
				
			pst = con.prepareStatement("INSERT INTO course ( id ,instructorId , subject , capacity "
					+ ", hours, price , lap , freeSpaces) VALUES (?,?,?,?,?,?,?,?)");
			pst.setInt(1, course.getCourseId());
			pst.setString(2, course.getInstructorId());
			pst.setString(3, course.getCourseSubject());
			pst.setInt(4, course.getCourseCapacity());
			pst.setInt(5, course.getCourseHours());
			pst.setInt(6 ,course.getCoursePrice() );
			pst.setInt(7, course.getCourseLap());
			//pst.setLong(8, course.getCourseStartDate());
			pst.setInt(8, course.getCourseFreeSpaces());
			pst.executeUpdate();
			System.out.println("new course saved to data base");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			}
			
			
		}
		
	
	 
	
		
}
