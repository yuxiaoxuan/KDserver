package com.dy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class HDeleteUserServlet
 */
public class HDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HDeleteUserServlet() {
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
		
		String id = request.getParameter("id");
		String sql1 = "delete from  users  where id="+id;
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			util.closeConn(conn);
		}	
		
		response.sendRedirect("admin/stu/stuMana.jsp");
	}
}
