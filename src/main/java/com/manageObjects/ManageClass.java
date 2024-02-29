package com.manageObjects;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageClass {
	public static int createClass(Class_room c_room) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("CALL Assign_Teacher_to_Class(?,?,?,?,?)");
			
			ps.setString(1, c_room.getClassId());
			ps.setString(2, c_room.getClassName());
			ps.setString(3, c_room.getTeacherId());
			ps.setString(4, c_room.getCourseId());
			ps.setString(5, c_room.getClassRoom());
			
			status = ps.executeUpdate();
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int updateClass(Class_room c_room) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("update Class set class_name = ?, class_room = ?, set room_limit = ? where class_id = ?");
			
			ps.setString(1, c_room.getClassName());
			ps.setString(2, c_room.getClassRoom());
			ps.setInt(3, c_room.getRoomLimit());
			ps.setString(4, c_room.getClassId());
			
			status = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int deleteClass(Class_room c_room) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("CALL Dismiss_Teacher_from_Class(?,?)");
			
			ps.setString(1, c_room.getClassId());
			ps.setString(2, c_room.getTeacherId());
			System.out.println(c_room.getClassId()+" "+c_room.getTeacherId());
			status = ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
//	public static void main(String [] args) {
//		String class_id = "Geo1";
//		Class_room c_room = ManageClass.classRoomWithId(class_id); 
//		
//		int stat = ManageClass.deleteClass(c_room);
//		System.out.print(c_room.getClassId()+" "+c_room.getTeacherId());
//	}
	public static int enrollStudent(Class_room c_room , Student stud) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("CALL Enroll_Student_to_Class(?,?)");
			
			ps.setString(1, c_room.getClassId());
			ps.setString(2, stud.getStudId());
			
			status = ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	public static int dismissClass(Class_room c_room , Student stud) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("CALL Dismiss_Student_from_Class(?,?)");
			
			ps.setString(1, c_room.getClassId());
			ps.setString(2, stud.getStudId());
			
			status = ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	
	
	public static List<Class_room> allClasses(){
		List<Class_room> c_rooms = new ArrayList<Class_room>();
		
		
		try {
			Connection con = ManageStudent.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from Class");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Class_room c_room = new Class_room();
				
				c_room.setClassId(rs.getString(1));
				c_room.setClassName(rs.getString(2));
				c_room.setTeacherId(rs.getString(3));
				c_room.setCourseId(rs.getString(4));
				c_room.setClassRoom(rs.getString(5));
				c_room.setRoomLimit(rs.getInt(6));
				c_room.setRegisteredStudent(rs.getInt(7));
				
				
				c_rooms.add(c_room);
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c_rooms;
	}

	
	public static Class_room classRoomWithId(String class_id){
		Class_room c_room = new Class_room();
		
		
		try {
			Connection con = ManageStudent.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from Class where class_id = ?");
			ps.setString(1, class_id);
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {				
				c_room.setClassId(rs.getString(1));
				c_room.setClassName(rs.getString(2));
				c_room.setTeacherId(rs.getString(3));
				c_room.setCourseId(rs.getString(4));
				c_room.setClassRoom(rs.getString(5));
				c_room.setRoomLimit(rs.getInt(6));
				c_room.setRegisteredStudent(rs.getInt(7));
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c_room;
	}
}

