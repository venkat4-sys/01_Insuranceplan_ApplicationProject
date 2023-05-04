package com.ashokit.servce;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

import com.ashokit.entity.Citizen;
import com.ashokit.searchreq.SearchRequest;

public interface Reportservice {

	public List<String> getplannames();

	public List<String> getplanstatus();

	public List<Citizen> search(SearchRequest request);

	public boolean excelexport(HttpServletResponse response) throws Exception;

	public boolean pdfexport(HttpServletResponse response) throws Exception ;







}
