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
 * Servlet implementation class AddGoodsServlet
 */
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGoodsServlet() {
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
		String goodsName = URLDecoder.decode(request.getParameter("goodsName"),
				"UTF-8");
		String[] goodNames = goodsName.split(",");
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		PrintWriter out = response.getWriter();
		String result = "0";
		for (int i = 0; i < goodNames.length; i++) {
			String sql1 = "select id from gwc where userid =" + myid
					+ " and goodsName = '" + goodNames[i] + "'";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql1);
				ResultSet rs = pstmt.executeQuery();
				int id = 0;
				while (rs.next()) {
					id = rs.getInt("id");
					break;
				}
				if (id == 0) {// 购物车没有此商品
					String sql2 = "insert into  gwc(userid,goodsName,gcount) values("
							+ myid + ",'" + goodNames[i] + "',0)";
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql2);
					result = "1";
				} else {
					result = "2";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "0";
			} finally {
				util.closeConn(conn);
			}
		}
		out.print(result);
	}

}
