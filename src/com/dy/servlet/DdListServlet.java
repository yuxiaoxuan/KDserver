package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class DdListServlet
 */
public class DdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DdListServlet() {
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
		String sql = "SELECT * from dingdan where myid="+myid;
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		String result = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				int ddid = rs.getInt("id");
				Date ddtime = rs.getDate("dates");
				if(i!=0){
					result+="@";
				}
				result+=ddid;
				result+=",";
				result+=ddtime;
				i++;
			}
		}catch (SQLException e) {
			result = "0";
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}	
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}
}
