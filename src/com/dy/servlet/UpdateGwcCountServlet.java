package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class UpdateGwcCountServlet
 */
public class UpdateGwcCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateGwcCountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String myid = request.getParameter("myid");
		String name = URLDecoder.decode(request.getParameter("name"),"UTF-8");
		String count = request.getParameter("count");
		
		String sql = "update gwc set gcount=" + count + " where userid=" + myid
				+ " and goodsName ='" + name + "'";
		
		String sql2 = "UPDATE goods SET gcount=gcount-"+count+" WHERE gname='"+name+"'";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		PrintWriter out = response.getWriter();
		String result = "0";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			Statement stmt2 = conn.createStatement();
			stmt2.executeUpdate(sql2);
			
			result = "1";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "2";
		} finally {
			util.closeConn(conn);
		}
		out.print(result);
	}
}
