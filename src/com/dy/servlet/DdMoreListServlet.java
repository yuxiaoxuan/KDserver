package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class DdMoreListServlet
 */
public class DdMoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DdMoreListServlet() {
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
   		String sql = "SELECT * from dingdanmore where dingdanid="+ddid;
   		DBUtil util = new DBUtil();
   		Connection conn = util.openConnection();
   		String result = "";
   		try {
   			PreparedStatement pstmt = conn.prepareStatement(sql);
   			ResultSet rs = pstmt.executeQuery();
   			int i = 0;
   			while(rs.next()) {
   				String gname = rs.getString("gname");
   				String gcount = rs.getString("count");
   				if(i!=0){
   					result+="@";
   				}
   				result+=gname;
   				result+=",";
   				result+=gcount;
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
