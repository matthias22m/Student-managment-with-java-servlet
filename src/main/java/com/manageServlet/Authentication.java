package com.manageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;

import com.manageObjects.ManageStudent;
import com.manageObjects.Student;

import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class Authentication extends HttpServlet{
	public static boolean isAuthenticated(String username,String password) throws SQLException {
		boolean auth = false;
		
		Connection con = (Connection) ManageStudent.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Admin where username = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) if(rs.getString(2).equals(password)) auth = true;
		
		return auth;
	}
	public static ArrayList<Integer> getNumbers(){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		Connection con = ManageStudent.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Course");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) nums.add(0,rs.getInt(1));
			
			PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) FROM Class");
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) nums.add(1,rs1.getInt(1));
			
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Teacher");
			ResultSet rs2 = ps2.executeQuery();
			if(rs2.next()) nums.add(2,rs2.getInt(1));
			
			PreparedStatement ps3 = con.prepareStatement("SELECT COUNT(*) FROM Student");
			ResultSet rs3 = ps3.executeQuery();
			if(rs3.next()) nums.add(3,rs3.getInt(1));
			
		}catch(SQLException e){e.printStackTrace();}
		
		return nums;
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws  ServletException, IOException{
		String user = (String) req.getParameter("username");
		String pass = (String) req.getParameter("password");
		ArrayList arr = getNumbers();
		
		try {
			if(isAuthenticated(user,pass)) {
				HttpSession session= req.getSession();
				session.setAttribute("arr", arr);
				session.setAttribute("user", user);
				res.sendRedirect("./Admin_home.jsp");
			}else {
				res.sendRedirect("login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
