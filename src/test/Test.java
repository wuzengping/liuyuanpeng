package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) {
	
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd hhmmss");
		
		 Workbook wb = new XSSFWorkbook();
		 
		 
		 
		 //标题行抽出字段
		    String[] title = {"序号","学号", "姓名"};
		    
		    //设置sheet名称，并创建新的sheet对象
		    String sheetName = "学生信息一览";
		    
		    
		    Sheet stuSheet = wb.createSheet(sheetName); //代表整个 表数据 
		    
		    
		    Row titleRow = stuSheet.createRow(0);
		    //创建单元格，设置style居中，字体，单元格大小等
		    CellStyle style = wb.createCellStyle();
		    Cell cell = null;
		    
		    //把已经写好的标题行写入excel文件中
		    for (int i = 0; i < title.length; i++) {
		        cell = titleRow.createCell(i);
		        cell.setCellValue(title[i]);
		        cell.setCellStyle(style);
		    }
		    
		    
		    
		    //把从数据库中取得的数据一一写入excel文件中
		    Row row = null;
		    List stuList=new ArrayList();
		    Student stu=new Student(1,"liu",1);
		    Student stu1=new Student(2,"liu",2);
		    Student stu2=new Student(3,"liu",3);
		     stuList.add(stu);
		     stuList.add(stu1);
		     stuList.add(stu2);
		    for (int i = 0; i < stuList.size(); i++) {
		        
		        row = stuSheet.createRow(i + 1);//创建行数  有条数据 就有 几行
		        //把值一一写进单元格里
		        //设置第一列为自动递增的序号
		        
		        row.createCell(0).setCellValue(i + 1);
		        row.createCell(1).setCellValue("刘");
		        row.createCell(2).setCellValue(1);
		        
		        //把时间转换为指定格式的字符串再写入excel文件中
		       

		    }
		    //设置单元格宽度自适应，在此基础上把宽度调至1.5倍
		    for (int i = 0; i < title.length; i++) {
		        stuSheet.autoSizeColumn(i, true);
		        stuSheet.setColumnWidth(i, stuSheet.getColumnWidth(i) * 15 / 10);
		    }
		    
		    
		    
		    
		    //获取配置文件中保存对应excel文件的路径，本地也可以直接写成F：excel/stuInfoExcel路径
		    String folderPath = "D:/ce";
		    //创建上传文件目录
		    File folder = new File(folderPath);
		    //如果文件夹不存在创建对应的文件夹
		    if (!folder.exists()) {
		        folder.mkdirs();
		    }
		    //设置文件名
		    String fileName = sdf1.format(new Date()) + sheetName + ".xlsx";
		    String savePath = folderPath + File.separator+ fileName;
		     System.out.println("---"+savePath);

		    OutputStream fileOut=null;
			try {
				fileOut = new FileOutputStream(savePath);
				wb.write(fileOut);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
		   
		    //返回文件保存全路径
		   System.out.println(savePath); 
		}
	}

