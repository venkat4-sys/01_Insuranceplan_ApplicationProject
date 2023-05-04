package com.ashokit.serviceutils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.ashokit.entity.Citizen;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse response,List<Citizen> plans,File f) throws Exception {
		

		Document document = new Document(PageSize.A4);
		// the document is attaching to the response object
		PdfWriter pdfWriter =PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Paragraph p = new Paragraph("Citizen Plans Info");
		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");

		for (Citizen plan : plans) {
			table.addCell(String.valueOf(plan.getCITIZEN_ID()));
			table.addCell(plan.getCITIZEN_NAME());
			table.addCell(plan.getPLAN_NAME());
			table.addCell(plan.getPLAN_STATUS());
			table.addCell(plan.getPLAN_START_DATE() + "");
			table.addCell(plan.getPLAN_END_DATE() + "");

		}

		document.add(table);
		document.close();

		
	}

	
	

	

}
