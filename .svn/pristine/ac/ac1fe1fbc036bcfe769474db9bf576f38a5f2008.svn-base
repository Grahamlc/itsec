package cn.edu.ustc.ttcn.itsec.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;



import cn.edu.ustc.ttcn.itsec.service.InvestInforService;

import com.opensymphony.xwork2.ActionContext;

public class RoleFileUpload implements ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private File upFile;
	private String upFileFileName;
	private String picContentType;  
    private InputStream inputStream;
    private InvestInforService investInforService;
    private int proId;
    
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public InvestInforService getInvestInforService() {
		return investInforService;
	}
	public void setInvestInforService(InvestInforService investInforService) {
		this.investInforService = investInforService;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public File getUpFile() {
		return upFile;
	}
	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}
		
	public String getUpFileFileName() {
		return upFileFileName;
	}
	public void setUpFileFileName(String upFileFileName) {
		this.upFileFileName = upFileFileName;
	}


	
	public String PoiServlet() throws Exception{
		proId = Integer.valueOf(request.getParameter("proId"));
		try {  
            //服务器的路径  
            String realpath = ServletActionContext.getServletContext().getRealPath("/inFile");          
            //例如-------D:\apache-tomcat-6.0.18\webapps\struts2_upload\images       
            System.out.println("上传到服务器的地址realpath: "+realpath);   
            //具体地址+文件名  
            String lj = realpath+"\\"+upFileFileName;  
            System.out.println("具体的地址lujing"+lj);  
            //列如------  D:\apache-tomcat-7.0.47\webapps\dyda\shuju\15636139999[通话详单]查询_1_1.xls    
            if (upFile != null) {              
                File savefile = new File(new File(realpath), upFileFileName);              
                if (!savefile.getParentFile().exists())   
                    savefile.getParentFile().mkdirs();    
                FileUtils.copyFile(upFile, savefile);              
                ActionContext.getContext().put("message", "文件上传成功");          
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
		readExcel(upFile);
        return "success";     
    }  
	
	public void readExcel(File file)throws IOException{
		Map<String , List<List<Object>>> maps = new LinkedHashMap();
		int s;
		  
		 // 构造 XSSFWorkbook 对象，strPath 传入文件路径  
		   XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));  
		   // 读取多个sheets表格内容  
		   for(s=0;s<8;s++){
			   List<List<Object>> list = new LinkedList<List<Object>>();
			   XSSFSheet sheet = xwb.getSheetAt(s);
			   Object value = null;
			   XSSFRow row = null;
			   XSSFCell cell = null;
			   
			   //从第一行到最后一行数据
			   for(int i= 1;i<=sheet.getPhysicalNumberOfRows();i++){
				   row = sheet.getRow(i);
				   if(row == null){
					   continue;
				   }
				   List<Object> linked = new LinkedList<Object>();
				   
				   //从第一列到最后一列数据
				   for(int j=row.getFirstCellNum();j<=row.getPhysicalNumberOfCells();j++){
					   cell = row.getCell(j);
					   if(cell ==null){
						   continue;
						   
					   }
					   DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
					   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串  
					   DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字  
					   
					   switch(cell.getCellType()){
					   
						   case XSSFCell.CELL_TYPE_STRING://字符串  
				                value = cell.getRichStringCellValue().getString();  
				                break;  
				            case XSSFCell.CELL_TYPE_NUMERIC://数字  
				                long dd = (long)cell.getNumericCellValue();  
				                value = dd+"";  
				                break;  
				            case XSSFCell.CELL_TYPE_BLANK:  
				                value = "";  
				                break;     
				            case XSSFCell.CELL_TYPE_FORMULA:  
				                value = String.valueOf(cell.getCellFormula());  
				                break;  
				            case XSSFCell.CELL_TYPE_BOOLEAN://boolean型值  
				                value = String.valueOf(cell.getBooleanCellValue());  
				                break;  
				            case XSSFCell.CELL_TYPE_ERROR:  
				                value = String.valueOf(cell.getErrorCellValue());  
				                break; 
				            default: 
				            	value = cell.toString();
				                break;  
					   }
					   linked.add(value);
					   
				   }//for j 列
//				   System.out.println(linked.size());
				   list.add(linked);
				   
				   /**
				    *分别将各个表单存入不同的数据库表中
				  switch(s){
				  	case 0:
				  		
				  		break;
				  	case 1:
				  		investInforService.saveMainData( proId, linked.get(0).toString(), linked.get(1).toString(), linked.get(2).toString(), linked.get(3).toString());
				  		break;
				  	case 2:
				  		investInforService.saveAppSoft(proId, linked.get(0).toString(), linked.get(1).toString(), linked.get(2).toString());
				  		break;
				  	case 3:
				  		investInforService.saveHostMemory(proId, linked.get(0).toString(), linked.get(1).toString(), linked.get(2).toString());
				  		break;
				  	
				  	case 4:
				  		investInforService.saveNetDevice(proId, linked.get(0).toString(), linked.get(1).toString(), linked.get(2).toString());
				  		break;
				  	case 5:
				  		investInforService.saveSecDevice(proId, linked.get(0).toString(), linked.get(1).toString(), linked.get(2).toString());
				  		break;
				  	case 6:
				  		investInforService.saveRelaPeople(proId, linked.get(0).toString(), linked.get(1).toString(), linked.get(2).toString());
				  		break;
				  	case 7:
				  		investInforService.saveManageFile(proId, linked.get(0).toString(),"");
				  		break;
				  	default:
				  		break;

				  }
				  */
			   }//for i 行
//			   System.out.println(list.size());
//			   System.out.println("hello");
			   maps.put(String.valueOf(s), list);
		   }//for sheets
		   investInforService.saveWholePackage(proId, maps);
	}

 }
