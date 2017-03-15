package instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dataBase.CreateDataBase;
import dataBase.DBConnection;

public class InsertInstructor {

	
	/**
	 * 
	 * @param instructor : to save to data base
	 */
	public void saveInstructor( Instructor instructor , boolean old ){
		
		
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connections
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use CoursesCenter");
			pst.executeUpdate();
			
			if (old){
				delete(instructor.getId());
			}
				
			pst = con.prepareStatement("INSERT INTO instructor  VALUES (?,?,?,?,?,?,?,?)");
			pst.setInt(1, instructor.getId());
			pst.setString(2, instructor.getSubject());
			pst.setString(3, instructor.getFirstName());
			pst.setString(4, instructor.getLastName());
			pst.setString(5, instructor.getEmail());
			pst.setString(6 ,instructor.getPhone() );
			pst.setInt(7, instructor.getSallary());
			pst.setString(8, instructor.getAddress());
			pst.executeUpdate();
			System.out.println("new instructor saved to data base");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			}
		
	}
	
	
	/**
	 * delete an instructor from data base
	 * @param id : instructor id to delete
	 * @return true if deleted , false if not
	 */
	public boolean delete (int id){
		
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
		
		try {
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use CoursesCenter");
			pst.executeUpdate();
			pst=con.prepareStatement("delete from instructor where id =?");
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
