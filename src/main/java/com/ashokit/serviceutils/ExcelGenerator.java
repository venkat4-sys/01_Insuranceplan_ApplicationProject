package com.ashokit.serviceutils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.entity.Citizen;
import com.ashokit.repo.CitizenRepo;


@Component
public class ExcelGenerator {
	
	
	
	
	
	public void excelexport(HttpServletResponse response,List<Citizen> records,File f) throws Exception{
	Workbook workbook=new HSSFWorkbook();
	
	//creating new worksheet
	Sheet createSheet = workbook.createSheet("insurance");
	
	//creating a header row
	Row headerrow = createSheet.createRow(0);
	//setting the values for the headerRow
	headerrow.createCell(0).setCellValue("Id");
	headerrow.createCell(1).setCellValue("Citizen name");
	headerrow.createCell(2).setCellValue("Plan Name");
	headerrow.createCell(3).setCellValue("plan status");
	headerrow.createCell(4).setCellValue("StartDate");
	headerrow.createCell(5).setCellValue("EndDate");
	
	headerrow.createCell(6).setCellValue("BenfitAmount");
	
	//headerrow.createCell(6).setCellValue("BenfitAmount");
	
	
	
	
	
	int DatarowIndex=1;
	for(Citizen plan:records) {
		
		  Row datarow= createSheet.createRow(DatarowIndex);
		  
		  datarow.createCell(0).setCellValue(plan.getCITIZEN_ID());
		  datarow.createCell(1).setCellValue(plan.getCITIZEN_NAME());
		  datarow.createCell(2).setCellValue(plan.getPLAN_NAME());
		  datarow.createCell(3).setCellValue(plan.getPLAN_STATUS());
		  datarow.createCell(4).setCellValue(plan.getPLAN_START_DATE()+"");
		  datarow.createCell(5).setCellValue(plan.getPLAN_END_DATE()+"");
		  
		  if(null !=plan.getBENEFIT_AMOUNT()) {
			  datarow.createCell(6).setCellValue(plan.getBENEFIT_AMOUNT()); 
		  }else {
			  datarow.createCell(6).setCellValue("N/A");
		  }
		  
		  DatarowIndex++;
		
	}
	
	FileOutputStream fs=new FileOutputStream(new File("plans.xls"));
	workbook.write(fs);
	fs.close();

	
	ServletOutputStream outputStream = response.getOutputStream();
	
	workbook.write(outputStream);
	workbook.close();
	
	

	
	
	
	
	
	
	 
	}	    

}
