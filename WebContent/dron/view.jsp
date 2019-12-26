<%@ page import="kr.co.acorn.dto.DronDto"%>
<%@ page import="kr.co.acorn.dao.DronDao"%>
<%@ page pageEncoding="utf-8" %>
<%@ include file="../inc/header.jsp" %>  
<%
	String tempPage = request.getParameter("page");
	String tempNo = request.getParameter("no");
	if(tempPage == null || tempPage.length()==0){
		tempPage = "1";
	}
	if(tempNo == null || tempNo.length()==0){
		response.sendRedirect("list.jsp?page="+tempPage);
		return;
	}
	int cPage = 0;
	int no = 0;
	try{
		cPage = Integer.parseInt(tempPage);
	}catch(NumberFormatException e){
		cPage = 1;
	}
	try{
		no = Integer.parseInt(tempNo);
	}catch(NumberFormatException e){
		response.sendRedirect("list.jsp?page="+cPage);
		return;
	}
	
	DronDao dao = DronDao.getInstance();
	DronDto dto = dao.select(no);
	if(dto == null){
		response.sendRedirect("list.jsp?page="+cPage);
		return;		
	}
	String dname = dto.getDname();
	String dprice = dto.getDprice();
	String dland = dto.getDland();
%>
  <!-- breadcrumb start-->
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="/main/index.jsp">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">Dron</li>
    </ol>
  </nav>
  <!-- breadcrumb end-->

  <!-- main start-->
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h3>
		  드론 상세보기
		</h3>
		<form name="f" method="post">
		  <div class="form-group row">
		    <label for="no" class="col-sm-2 col-form-label">번호</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="no" name="no" readonly="readonly" value="<%=no%>">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="name" class="col-sm-2 col-form-label">제품명</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dname" name="dname" value="<%=dname%>">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="name" class="col-sm-2 col-form-label">가격</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dprice" name="dprice" value="<%=dprice%>">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="loc" class="col-sm-2 col-form-label">지역</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dland" name="dland" value="<%=dland%>">
		    </div>
		  </div>
		  <input type="hidden" name="page" value="<%=cPage %>"/>
		</form>
		<div class="text-right">
			<button type="button" id="prevPage" class="btn btn-outline-secondary">이전</button>
			<button type="button" id="updateDron" class="btn btn-outline-success">수정</button>
			<button type="button" id="deleteDron" class="btn btn-outline-danger">삭제</button>
        </div>
      </div>
    </div>
  </div>
  <!-- main end-->
  <%@ include file="../inc/footer.jsp" %> 
  <script>
  $(function(){
	  $("#no").focus();
	  $("#prevPage").click(function(){
		  history.back(-1);
	  });
	  $("#updateDron").click(function(){
		  //자바스크립트 유효성 검사
		  f.action="update.jsp";
		  f.submit();
	  });
	  $("#deleteDron").click(function(){
		  f.action="delete.jsp";
		  f.submit();
	  });
	  
	  
  });
  </script>