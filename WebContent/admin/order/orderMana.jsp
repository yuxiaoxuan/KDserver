<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="com.dy.util.DBUtil" %>
<%
String path = request.getContextPath();
String sql = "SELECT d.id,u.userName,d.dates,d.totle,d.type,d.state,d.address  FROM dingdan d, users u WHERE d.myid=u.id ";
DBUtil util = new DBUtil();
Connection conn = util.openConnection();
ResultSet rs = null;
try {
	PreparedStatement pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
}catch (SQLException e) {
	e.printStackTrace();
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function stuDel(stuId)
           {
               if(confirm('您确定发货吗？'))
               {
                   window.location.href="<%=path %>/HSendGoodsServlet?id="+stuId;
               }
           }
           
           function stuEditPre(stuId)
           {
                   window.location.href="<%=path %>/stuEditPre.action?stuId="+stuId;
           }
           
           function stuAdd()
           {
                 var url="<%=path %>/admin/goods/goodsAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/images/tbg.gif">&nbsp;订单管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="11%">客户名</td>
					<td width="11%">下单时间</td>
					<td width="11%">消费金额</td>
					<td width="11%">支付方式</td>
					<td width="11%">送货地址</td>
					<td width="11%">状态</td>
					<td width="11%">操作</td>
		        </tr>	
<% while(rs.next()) {%>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<%=rs.getString("userName")%>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<%=rs.getDate("dates") %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <%=rs.getDouble("totle") %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<%=rs.getString("type") %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<%=rs.getString("address") %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<%=rs.getString("state") %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					<%
					if(rs.getString("state").equals("未发货")){
						%>
					<a href="#" onclick="stuDel(<%=rs.getInt("id") %>)" class="pn-loperator">发货</a>
					<% }else{
					%>
					已发货
					<%} %>
						
					    <%--<a href="#" onclick="stuEditPre(<s:property value="#stu.stuId"/>)" class="pn-loperator">编辑</a>
					--%></td>
				</tr>
				<%} %>
			</table>
			
	</body>
</html>
