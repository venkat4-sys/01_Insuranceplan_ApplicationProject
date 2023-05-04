package com.ashokit.serviceimpl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Citizen;
import com.ashokit.repo.CitizenRepo;
import com.ashokit.searchreq.SearchRequest;
import com.ashokit.servce.Reportservice;
import com.ashokit.serviceutils.Emailutils;
import com.ashokit.serviceutils.ExcelGenerator;
import com.ashokit.serviceutils.PdfGenerator;

@Service
public class ReportServiceimpl implements Reportservice {
  
	@Autowired
	public CitizenRepo repo;
	
	@Autowired
	private ExcelGenerator report;
	
	@Autowired
  private 	PdfGenerator gen;
	
	@Autowired
	private Emailutils emailutils;
	
	
	public List<String> getplannames() {
		
		return repo.getplannames();
	}

	public List<String> getplanstatus() {
		// TODO Auto-generated method stub
		return repo.getplanstatus();
	}
     
	
	public List<Citizen> search(SearchRequest request) {
		Citizen citizen = new Citizen();
		if(null !=request.getPlan_Name() && !"".equals(request.getPlan_Name())) {
			citizen.setPLAN_NAME(request.getPlan_Name());	
			
		}
		if(null !=request.getPlan_Status() && !"".equals(request.getPlan_Status())) {
			citizen.setPLAN_STATUS(request.getPlan_Status());	
			
		}
		if(null !=request.getGender() && !"".equals(request.getGender())) {
			citizen.setGENDER(request.getGender());	
			
		}
		
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// converting string to localdate
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			citizen.setPLAN_START_DATE(localDate);
		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String startDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// converting string to localdate
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			citizen.setPLAN_START_DATE(localDate);
		}

		//citizen.setPLAN_START_DATE(request.getStartDate());
		//citizen.setPLAN_END_DATE(request.getEndDate());
		
		Example<Citizen> example = Example.of(citizen);
		
		return repo.findAll(example);
	}

	public boolean excelexport(HttpServletResponse response) throws Exception{
		
		List<Citizen> plans = repo.findAll();
		File f=new File("plans.xls");
		
		
		report.excelexport(response, plans,f);
		
		String subject="mail report";
		String body="<h2>mail body</h2>";
		String to="venkatkilari5@gmail.com";
		
			emailutils.sendEmail(subject, body, to,f);
			f.delete();
		
		return true;
	}

	public boolean pdfexport(HttpServletResponse response) throws Exception {
		
		
		
		List<Citizen> plans = repo.findAll();
		File f=new File("plans.pdf");

		gen.generate(response, plans,f);
		String subject="mail report";
		String body="<h2>mail body</h2>";
		String to="venkatkilari5@gmail.com";
		
	  emailutils.sendEmail(subject, body, to,f);
		
			f.delete();
			
			

		
		return true;

	 
		
		
		
	}

}
