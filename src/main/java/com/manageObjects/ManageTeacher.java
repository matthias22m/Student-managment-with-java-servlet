package com.manageObjects;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageTeacher {
	
	public static int saveTeacher(Teacher teach) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into Teacher (Teacher_id, full_name, email, gender, phone, credit_hour_limit, address ,password) values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, teach.getTeachId());
			ps.setString(2, teach.getFullName());
			ps.setString(3, teach.getEmail());
			ps.setString(4, teach.getGender());
			ps.setString(5, teach.getPhone());
			ps.setInt(6, teach.getHourLimit());
			ps.setString(7, teach.getAddress());
			ps.setString(8, teach.getPassword());
			
			status = ps.executeUpdate();
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int updateTeacher(Teacher teach) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("update Teacher set full_name = ?, email = ?, gender = ?, phone = ? , credit_hour_limit = ?, address = ? where teacher_id = ?");
			
			ps.setString(1, teach.getFullName());
			ps.setString(2, teach.getEmail());
			ps.setString(3, teach.getGender());
			ps.setString(4, teach.getPhone());
			ps.setInt(5, teach.getHourLimit());
			ps.setString(6, teach.getAddress());
			ps.setString(7, teach.getTeachId());
			
			status = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int deleteTeacher(String teach_id) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("delete from Teacher where teacher_id = ?");
			
			ps.setString(1, teach_id);
			
			status = ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static List<Teacher> allTeachers(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Teacher");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Teacher teach = new Teacher();
				
				teach.setTeachId(rs.getString(1));
				teach.setFullName(rs.getString(2));
				teach.setEmail(rs.getString(3));
				teach.setPhone(rs.getString(4));
				teach.setGender(rs.getString(5));
				teach.setHourLimit(rs.getInt(7));
				teach.setAddress(rs.getString(8));
				
				
				teachers.add(teach);
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teachers;
	}
	
	public static Teacher teacherWithId(String teach_id){
		Teacher teach = new Teacher();
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Teacher where teacher_id = ?");
			ps.setString(1,teach_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				teach.setTeachId(rs.getString(1));
				teach.setFullName(rs.getString(2));
				teach.setEmail(rs.getString(3));
				teach.setPhone(rs.getString(4));
				teach.setGender(rs.getString(5));
				teach.setHourLimit(rs.getInt(7));
				teach.setAddress(rs.getString(8));
				teach.setPassword(rs.getString(9));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teach;
	}
}
