package com.manageObjects;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageStudent {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root","passwordisproblem");		
		} catch(Exception e) {
			e.getMessage();
		}
		return con;	
	}
	
	public static int saveStudent(Student stud) {
		int status = 0;
		
		Connection con = getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into Student (student_id, full_name, email, gender, phone, address, password) values (?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, stud.getStudId());
			ps.setString(2, stud.getFullName());
			ps.setString(3, stud.getEmail());
			ps.setString(4, stud.getGender());
			ps.setString(5, stud.getPhone());
			ps.setString(6, stud.getAddress());
			ps.setString(7, stud.getPassword());
			
			status = ps.executeUpdate();
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int updateStudent(Student stud) {
		int status = 0;
		
		Connection con = getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("update Student set full_name = ?, email = ?, gender = ?, phone = ? , year = ?, address = ? where student_id = ?");
			
			ps.setString(1, stud.getFullName());
			ps.setString(2, stud.getEmail());
			ps.setString(3, stud.getGender());
			ps.setString(4, stud.getPhone());
			ps.setInt(5, stud.getYear());
			ps.setString(6, stud.getAddress());
			ps.setString(7, stud.getStudId());
			
			status = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int deleteStudent(String stud_id) {
		int status = 0;
		
		Connection con = getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("delete from Student where student_id = ?");
			
			ps.setString(1, stud_id);
			
			status = ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static List<Student> allStudents(){
		List<Student> Students = new ArrayList<Student>();
		
		
		try {
			Connection con = (Connection) getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from Student");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student stud = new Student();
				
				stud.setStudId(rs.getString(1));
				stud.setFullName(rs.getString(2));
				stud.setGender(rs.getString(3));
				stud.setEmail(rs.getString(4));
				stud.setPhone(rs.getString(5));
				stud.setYear(rs.getInt(7));
				stud.setAddress(rs.getString(9));
				
				Students.add(stud);
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Students;
	}

	
	public static Student studentWithId(String stud_id){
		
		Student stud = new Student();
		Connection con = getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Student where student_id = ?");
			ps.setString(1,stud_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.print(rs.getString(4));
				stud.setStudId(rs.getString(1));
				stud.setFullName(rs.getString(2));
				stud.setGender(rs.getString(3));
				stud.setEmail(rs.getString(4));
				stud.setPhone(rs.getString(5));
				stud.setYear(rs.getInt(7));
				stud.setAddress(rs.getString(9));
				stud.setPassword(rs.getString(10));
				
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stud;
	}
}
