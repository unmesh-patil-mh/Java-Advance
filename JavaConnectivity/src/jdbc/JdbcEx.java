package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;  // ✅ Correct
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import com.sun.jdi.connect.spi.Connection;

public class JdbcEx {
	public static Connection createCon() throws ClassNotFoundException ,SQLException {
		java.sql.Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Unmesh");
		System.out.println("Connection Created...");
		return (Connection) con;
	}
	
	public void createTable() throws ClassNotFoundException, SQLException {
		Connection con=JdbcEx.createCon();
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
		Connection con=JdbcEx.createCon();
		Statement stmt=con.createStatement();
		boolean status=stmt.execute("insert into student(Roll,name,city) values(1,'Unmesh','Nashik'),(2,'Ayush','Pune'),(3,'Aradhya','Dhule');");
		if(status=true) {
			System.out.println("The Data Added....");
		}
		else {
			System.out.println("Unable to add Data....");
		}
	}
	
	public void updateData() throws ClassNotFoundException, SQLException {
		Connection con=JdbcEx.createCon();
		Statement stmt=con.createStatement();
		boolean status=stmt.execute("update student set name='Yash',city='Nashik' where Roll=3;");
		if(status=true) {
			System.out.println("Data Updated....");
		}
		else {
			System.out.println("Data not Upadated....");
		}
	}
	
	public void deleteData() throws ClassNotFoundException, SQLException {
		Connection con=JdbcEx.createCon();
		Statement stmt=con.createStatement();
		boolean status=stmt.execute("delete from student where Roll=3;");
		if(status=true) {
			System.out.println("Data Deleted....");
		}
		else {
			System.out.println("Data Not Deleted....");
		}
	}
	
	public void getSingleData() throws SQLException, ClassNotFoundException {
		Student s=new Student();
		Connection con=JdbcEx.createCon();
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("select * from student where Roll=1;");
		while(result.next()) {
			s.setRoll(result.getInt("Roll"));   // safer: use column name
	        s.setName(result.getString("Name"));
	        s.setCity(result.getString("City"));

		}
		System.out.println("Roll no= "+s.getRoll());
		System.out.println("Name= "+s.getName());
		System.out.println("City= "+s.getCity());
	}
	
	public void getAllData() throws ClassNotFoundException, SQLException {
		List<Student> s=new ArrayList<>();
		Connection con=JdbcEx.createCon();
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("Select * from student;");
		while(result.next()) {
			Student s1=new Student();
			s1.setName(result.getString(2));
			s1.setRoll(result.getInt(1));
			s1.setCity(result.getString(3));
//			((List<Student>) s1).add(s);
			s.add(s1);
		}
		for(Student s2 :s) {
			System.out.println("Roll No="+s2.getRoll());
			System.out.println("Name="+s2.getName());
			System.out.println("City="+s2.getCity());
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JdbcEx j=new JdbcEx();
//		j.createCon();
//		j.createTable();
//		j.saveData();
//		j.updateData();
//		j.deleteData();
//		j.getSingleData();
		j.getAllData();
	}
	
}
