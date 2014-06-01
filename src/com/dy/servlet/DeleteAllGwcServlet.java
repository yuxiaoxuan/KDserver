package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class DeleteAllGwcServlet
 */
public class DeleteAllGwcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllGwcServlet() {
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
		String myid = request.getParameter("myid");
		String sql1 = "delete from  gwc  where userid="+myid;
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		PrintWriter out = response.getWriter();
		String result = "0";
		try {
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql1);
			result = "1";
		} catch (Exception e) {
			e.printStackTrace();
			result = "0";
		}finally {
			util.closeConn(conn);
		}	
		out.print(result);
	}

}
