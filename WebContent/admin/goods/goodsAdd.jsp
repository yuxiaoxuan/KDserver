<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page isELIgnored="false"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />

<script language="javascript">
	
</script>
</head>

<body leftmargin="2" topmargin="9"
	background='<%=path%>/images/allbg.gif'>
	<form action="<%=path%>/HaddGoodsServlet" name="formAdd" method="post"
		enctype="multipart/form-data">
		<table width="98%" align="center" border="0" cellpadding="4"
			cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
			<tr bgcolor="#EEF4EA">
				<td colspan="3" background="<%=path%>/images/wbg.gif" class='title'><span>商品录入</span></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">商品名：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="name" size="20" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">图片：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="file" name="pwd" size="20" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">价格：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="price" size="20" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">库存数量：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="count" size="20" /></td>
			</tr>



			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">商品描述：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left">
				<textarea name="text" size="20" rows="5" cols="30"></textarea></td>
			</tr>




			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;</td>


				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="submit" value="提交" />&nbsp; <input type="reset" value="重置" />&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
