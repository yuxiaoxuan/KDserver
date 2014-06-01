package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class JsServlet
 */
public class JsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsServlet() {
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
		String phone = request.getParameter("phone");
		String address = URLDecoder.decode(request.getParameter("address"),"UTF-8");
		//String address2 = URLDecoder.decode(address,"UTF-8");
		String type = URLDecoder.decode(request.getParameter("type"),"UTF-8");
		String sql1 = "SELECT gwc.goodsName,g.gprice,gwc.gcount FROM gwc gwc ,goods g WHERE gwc.goodsName=g.gname AND gwc.userid="+myid;
		
		System.out.println("address=" + address +",type=" + type);
		
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		PrintWriter out = response.getWriter();
		String result = "0";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
			double totle=0.0;
			while(rs.next()) {
				double price = Double.parseDouble(rs.getString("gprice"));
				int pcount = Integer.parseInt(rs.getString("gcount"));
				double onePrice= price*pcount;
				totle+=onePrice;
			}
				String sql2 = "insert into dingdan(myid,totle,dates,phone,address,type) values("+myid+","+totle+",now(),'"+phone+"','"+address+"','"+type+"')";
				
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql2);
				String sql3 = "select id from dingdan where myid ="+myid+" order by dates desc";
				PreparedStatement pstmt2 = conn.prepareStatement(sql3);
				ResultSet rs2 = pstmt2.executeQuery();
				int dingdanid=0;
				while(rs2.next()) {
					dingdanid=rs2.getInt("id");
					break;
				}
				PreparedStatement pstmt22 = conn.prepareStatement(sql1);
				ResultSet rs22 = pstmt22.executeQuery();
				while(rs22.next()) {
					String gname = rs22.getString("goodsName");
					String gcount = rs22.getString("gcount");

					String sql4 = "insert into dingdanmore(dingdanid,gname,count) values("+dingdanid+",'"+gname+"',"+gcount+")";
					
					Statement stmt2 = conn.createStatement();
					stmt2.executeUpdate(sql4);
				}
				 result = "1";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "0";
		}finally {
			util.closeConn(conn);
		}	
		out.print(result);
	}

}
