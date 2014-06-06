package com.dy.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dy.util.DBUtil;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class HaddGoodsServlet
 */
public class HaddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String path="goods";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaddGoodsServlet() {
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
		
		String gurl="http://192.168.0.102:8080/ShopServer/goods/";
//		String gurl="http://localhost:8080/ShopServer/goods/";
		String loadpath=this.getServletConfig().getServletContext().getRealPath("/");
		String fullPath=loadpath+path;  
        File fullDir=new File(fullPath);  
        if(!fullDir.exists()){  
            fullDir.mkdirs();  
        }  
        SmartUpload smartUpload=new SmartUpload();  
      
        long maxSize=10*1024*1024;//ÿ���ļ������ϴ��Ĵ�С  
        String allowFileExtList="jar,exe,doc,docx,txt,html,xml,xls,pdf,jpg,png,gif";  
        smartUpload.initialize(getServletConfig(), request, response);  
        smartUpload.setMaxFileSize(maxSize);  
        smartUpload.setAllowedFilesList(allowFileExtList);  
        String name="";
        String price = "";
        String count = "";
        String text = "";
        try {  
            smartUpload.upload();  
            name =smartUpload.getRequest().getParameter("name");
    	    price = smartUpload.getRequest().getParameter("price");
    		count = smartUpload.getRequest().getParameter("count");
    		text = smartUpload.getRequest().getParameter("text");
    		Files allFiles=smartUpload.getFiles();  
            Enumeration fileEnum=allFiles.getEnumeration();  
            while(fileEnum.hasMoreElements()){  
                com.jspsmart.upload.File smartFile=(com.jspsmart.upload.File) fileEnum.nextElement();  
                if(!smartFile.isMissing()){  
                    String fileName=smartFile.getFileName();  
                    response.setContentType("text/html;charset=gbk");//���������������,ҳ����ҲҪΪgbk  
                    smartFile.saveAs(fullPath+"//"+fileName, com.jspsmart.upload.File.SAVEAS_PHYSICAL); 
                    gurl+=fileName;
                }  
                break;
            }  
              
        } catch (SmartUploadException e) {  
            e.printStackTrace();  
        }  
		
        DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
				String sql = "insert into goods(gname,gurl,gprice,gcount,gtext,gtype) values('"+name+"','"+gurl+"',"+price+","+count+",'"+text+"','1')";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		response.sendRedirect("admin/goods/goodsMana.jsp");
	}

}
