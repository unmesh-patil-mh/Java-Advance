package prepareStmt;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.Connection;


//import com.sun.jdi.connect.spi.Connection;

public class PrepareEx {
	Scanner sc=new Scanner(System.in);
	public static Connection createCon() throws ClassNotFoundException, SQLException {
		java.sql.Connection con= null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/preparestmt","root","Unmesh");
		System.out.println("Connection Created....");
		return con;
	}
	
	public void createTable() throws ClassNotFoundException, SQLException {
		Connection con=PrepareEx.createCon();
		Statement stmt=con.createStatement();
		boolean status=stmt.execute("create table student(Roll int,name varchar(20),city varchar(20))");
		if(status==false) {
			System.out.println("Table created....");
		}
		else {
			System.out.println("Table not created....");
		}
		con.close();
	}
	
	public void saveData() throws ClassNotFoundException, SQLException {
		int Roll;
		String name,city;
		System.out.println("Enter the Roll Number: ");
		Roll=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Name: ");
		name=sc.nextLine();
		System.out.println("Enter the City: ");
		city=sc.nextLine();
		Connection con=PrepareEx.createCon();
		PreparedStatement p=con.prepareStatement("insert into student(Roll,name,city) values(?,?,?)");
		p.setInt(1, Roll);
		p.setString(2, name);
		p.setString(3, city);
		int status=p.executeUpdate();
		if(status==1) {
			System.out.println("Data Added Succesfully....");
		}
		else {
			System.out.println("Data Addition Failed....");
		}
	}
	
	public void upadteData() throws ClassNotFoundException, SQLException {
		Connection con=PrepareEx.createCon();
		int Roll;
//		String name,city;
		System.out.println("Enter the Roll Number: ");
		Roll=sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter the Name: ");
//		name=sc.nextLine();
//		System.out.println("Enter the City: ");
//		city=sc.nextLine();
		PreparedStatement stmt=con.prepareStatement("update student set name='Aradhya',city='Dhule' where Roll=?;");
		stmt.setInt(1, Roll);
//		stmt.setString(2, name);
//		stmt.setString(3, city);
		int status=stmt.executeUpdate();
		if(status==1) {
			System.out.println("Data Updated....");
		}
		else {
			System.out.println("Unable to Update Data....");
		}
	}
	
	public void deleteData() throws ClassNotFoundException, SQLException {
		Connection con=PrepareEx.createCon();
		int Roll;
		System.out.println("Enter the Roll Number: ");
		Roll=sc.nextInt();
		PreparedStatement p=con.prepareStatement("delete from student where Roll=?;");
		p.setInt(1, Roll);
		int status=p.executeUpdate();
		if(status==1) {
			System.out.println("Data Deleted Successfully....");
		}
		else {
			System.out.println("Data Deletion Failed....");
		}
	}
	
	public void findOneData() throws ClassNotFoundException, SQLException {
		Connection con=PrepareEx.createCon();
		Student s=new Student();
		int Roll;
		System.out.println("Enter Roll no you want to find: ");
		Roll=sc.nextInt();
		PreparedStatement p=con.prepareStatement("Select * from student where Roll=?");
		p.setInt(1, Roll);
		ResultSet result=p.executeQuery();
		while(result.next()) {
			s.setRoll(result.getInt(1));
			s.setName(result.getString(2));
			s.setCity(result.getString(3));
		}
		System.out.println("Roll= "+s.getRoll());
		System.out.println("Name= "+s.getName());
		System.out.println("City= "+s.getCity());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PrepareEx e=new PrepareEx();
//		e.createCon();
//		e.createTable();
//		e.saveData();
//		e.upadteData();
//		e.deleteData();
		e.findOneData();
	}
	
//	TO GET MANY AT ONCE USE SAME METHOD AS WRITTEN IN JAVA CONNECTIVITY OR USE BOVE JUST REMOVE WHERE CLAUSE
}
