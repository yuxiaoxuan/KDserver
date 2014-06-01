package com.dy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class HLoginServlet
 */
public class HLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		HttpSession session = request.getSession();
		String sql = "select * from admins where userName= '"+userName +"' and password='"+userPw+"'";
		System.out.println(sql);
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int index=0;
			while(rs.next()) {
				session.setAttribute("id", rs.getInt("id"));
				session.setAttribute("name", rs.getString("userName"));
				//session.setAttribute("id", rs.getInt("id"));
				index++;
				break;
			}
			if(index>0)
			{
				response.sendRedirect("loginSuccess.jsp");
			}else{
				//response.sendRedirect("loginSuccess.jsp");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}	
	}

}
