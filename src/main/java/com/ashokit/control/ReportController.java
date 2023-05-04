package com.ashokit.control;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.Citizen;
import com.ashokit.searchreq.SearchRequest;
import com.ashokit.servce.Reportservice;



@Controller
public class ReportController {
	
	@Autowired
	private Reportservice repo;
	
	
	@GetMapping("/key")
	public void pdfExport (HttpServletResponse response) throws Exception{
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
	     repo.pdfexport(response);
	
	}
	
	
	@GetMapping("/excel")
	public void excelexport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		
		response.addHeader("Content-Disposition", "attachment; filename=plans.xls");
		repo.excelexport(response);
		
	}
	
	@GetMapping("/")
	public String loadpage(Model model) {
		
		//SearchRequest r=new SearchRequest();
		
		//model.addAttribute("book", r);
		model.addAttribute("request", new SearchRequest());

		init(model);
		
		
		return "index";
	}
		
		
	
	private void init(Model model) {
		SearchRequest searchObj = new SearchRequest();

		//model.addAttribute("request", new SearchRequest());
		model.addAttribute("plannames", repo.getplannames());
		model.addAttribute("planstatus", repo.getplanstatus());
	}
	@PostMapping("/search")
	public String handleSearchRequest(@ModelAttribute("request") SearchRequest request, Model model) {
		System.out.println(request);
		List<Citizen> listPlans = repo.search(request);
		model.addAttribute("plans", listPlans);
		
		init(model);
		return "index";

	}
	

	

}

