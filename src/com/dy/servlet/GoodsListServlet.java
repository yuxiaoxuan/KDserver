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
 * Servlet implementation class GoodsServlet
 */
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=GBK");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sql = "select * from goods ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		String result = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				
				String pname=rs.getString("gname");
//				System.out.println(pname);
				String purl = rs.getString("gurl");
				String pprice = rs.getString("gprice");
				String pcount = rs.getString("gcount");
				String ptext = rs.getString("gtext");
//				System.out.println(purl);
//				System.out.println(pprice);
//				System.out.println(pcount);
//				System.out.println(ptext);
				if(i!=0){
					result+="@";
				}
				result+=pname;
				result+=",";
				result+=purl;
				result+=",";
				result+=pprice;
				result+=",";
				result+=pcount;
				result+=",";
				result+=ptext;
				i++;
			}
		}catch (SQLException e) {
			result = "0";
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
