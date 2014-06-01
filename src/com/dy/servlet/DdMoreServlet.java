package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;
import com.sun.xml.internal.fastinfoset.Encoder;

/**
 * Servlet implementation class DdMoreServlet
 */
public class DdMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DdMoreServlet() {
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
   		String ddid = request.getParameter("ddid");
   		String sql = "SELECT * from dingdan where id="+ddid;
   		DBUtil util = new DBUtil();
   		Connection conn = util.openConnection();
   		String result = "";
   		try {
   			PreparedStatement pstmt = conn.prepareStatement(sql);
   			ResultSet rs = pstmt.executeQuery();
   			while(rs.next()) {
   				int ddid2 = rs.getInt("id");
   				String phone = rs.getString("phone");
   				String address = URLEncoder.encode(rs.getString("address"));
   				String totle = rs.getString("totle");
   				result+=ddid2;
   				result+=",";
   				result+=phone;
   				result+=",";
   				result+=address;
   				result+=",";
   				result+=totle;
   			}
   		}catch (SQLException e) {
   			result = "0";
   			e.printStackTrace();
   		} finally {
   			util.closeConn(conn);
   		}	
   		System.out.println(result);
   		PrintWriter out = response.getWriter();
   		out.print(result);
   	}
   }
