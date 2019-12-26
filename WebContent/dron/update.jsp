<%@ page import="kr.co.acorn.dto.DronDto"%>
<%@ page import="kr.co.acorn.dao.DronDao"%>
<%@ page pageEncoding="utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String dname = request.getParameter("dname");
	String dprice = request.getParameter("dprice");
	String dland = request.getParameter("dland");
	String tempPage = request.getParameter("page");
	
	DronDao dao = DronDao.getInstance();
	DronDto dto = new DronDto(no,dname,dprice,dland);
	boolean isSuccess = dao.update(dto);
	if(isSuccess){
%>
<script>
	alert('드론정보가 수정되었습니다');
	location.href = "view.jsp?page=<%=tempPage%>&no=<%=no%>";
</script>
<%	} else {%>
<script>
	alert('DB Error');
	history.back(-1);
</script>
<% } %>
	
