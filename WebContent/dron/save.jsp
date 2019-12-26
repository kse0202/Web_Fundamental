<%@ page import="kr.co.acorn.dto.DronDto"%>
<%@ page import="kr.co.acorn.dao.DronDao"%>
<%@ page pageEncoding="utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String dname = request.getParameter("dname");
	String dprice = request.getParameter("dprice");
	String dland = request.getParameter("dland");
	
	DronDto dto = new DronDto(no,dname,dprice,dland);
	DronDao dao = DronDao.getInstance();
	boolean isSuccess = dao.insert(dto);
	
	if(isSuccess){
%>
<script>
	alert('드론이 등록되었습니다.');
	location.href="list.jsp?page=1";
</script>
<% }else{ %>
<script>
	alert('DB Error');
	history.back(-1);
</script>
<%} %>  
  
  