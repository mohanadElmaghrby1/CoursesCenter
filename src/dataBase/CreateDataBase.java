/**
 * create data base and tables  if not exist  
 */
package dataBase;

import java.sql.*;

/**
 * create data bases for courses center
 * 
 * @author
 *
 */
public class CreateDataBase {

	private PreparedStatement pst;
	private Connection con;
	
	
	
	public void createDataBase (){
	
		
		//connect to data base
		DBConnection dbcon=new DBConnection();
		
		
		
		try {
			con=dbcon.mkConnection();
			//create connection and prepareStatment CREATE DATABASE IF NOT EXISTS courses_center
			pst =con.prepareStatement("CREATE DATABASE IF NOT EXISTS CoursesCenter");
			pst.executeUpdate();
			
			//use data base
			pst= con.prepareStatement("USE CoursesCenter");
			pst.executeUpdate();
			
			//create table course
			pst =con.prepareStatement(" CREATE TABLE if not exists course ("

					
					+" id INT  PRIMARY KEY ,"
					+" instructorId char(14) NOT Null ,"
					+" subject varchar(20) NOT NULL ,"
					+" capacity int not null ,"
					+" hours int not null ,"
					+" price int not null ,"
					+" lap int not null ,"
					+" freeSpaces int not null "
					+" )");
			pst.executeUpdate();
			
//			//CREAT TABLE INSTRUCTOR
			pst=con.prepareStatement("CREATE TABLE if not exists instructor ("

    				+" id char(14) PRIMARY KEY ,"
    				+" subject varchar(20)  not null , "
    				+" firstName varchar(50)  not null ,"
    				+" lastName varchar(50)  not null ,"
    				+" mail varchar(50)  not null ,"
    				+" phone varchar(11)  not null ,"
    				+" sallary int  not null ,"
    				+" address varchar(100)  not null "
    				
    				
					+")");
			pst.executeUpdate();
			
			
			//create table student
			
			pst = con.prepareStatement("CREATE TABLE  if not exists student ("

   				+" id int PRIMARY KEY ,"
   				+" firstName varchar(50) not null ,"
   				+" lastName varchar(50) not null ,"
   				+" email varchar(50) UNIQUE ,"
   				+" phone char(11) UNIQUE ,"
   				+" payments int not null ,"
   				+" address varchar(100) not null"
					+")");
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
