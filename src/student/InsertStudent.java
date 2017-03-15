package student;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dataBase.CreateDataBase;
import dataBase.DBConnection;
import instructor.Instructor;

public class InsertStudent {

	
	public void saveStudent( Student student , boolean old ){
		
		
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
		
		
		System.out.println(student.getId()+" " + student.getFirstName() + " "+ student.getPayments());
		
		try {
			//create connections
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use CoursesCenter");
			pst.executeUpdate();
			
			if (old){
				delete(student.getId());
			}
				
			pst = con.prepareStatement("INSERT INTO student  VALUES (?,?,?,?,?,?,?)");
			pst.setInt(1, student.getId());
			pst.setString(2, student.getFirstName());
			pst.setString(3, student.getLastName());
			pst.setString(4, student.getEmail());
			pst.setString(5 ,student.getPhone() );
			pst.setInt(6, student.getPayments());
			pst.setString(7, student.getAddress());
			pst.executeUpdate();
			System.out.println("new student saved to data base");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			}
		
	}	
	
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
			pst=con.prepareStatement("delete from student where id =?");
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
