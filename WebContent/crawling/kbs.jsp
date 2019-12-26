<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>


<%@ page pageEncoding="utf-8" %>
<%@ include file="../crawling_temp/header.jsp" %>  

	  <!-- main start-->
	  
	  <%
	  
	  String url = "https://recruit.kbs.co.kr/main.do";
	    System.out.println(url);
	    Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements kbsList = doc.select("#info_a");
		for(int i=0;i<kbsList.size();i++){
			Element list = kbsList.get(i);
			out.print(list);
		
		}
	  %>
	  <!-- main end-->
  <%@ include file="../crawling_temp/footer.jsp" %> 