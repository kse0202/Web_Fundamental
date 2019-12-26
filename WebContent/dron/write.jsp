<%@ page pageEncoding="utf-8" %>
<%@ include file="../inc/header.jsp" %>  
  <!-- breadcrumb start-->
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="/main/index.jsp">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">DRON</li>
    </ol>
  </nav>
  <!-- breadcrumb end-->
  <%
  int cPage = 0;
  String tempPage = request.getParameter("page");
  if(tempPage == null || tempPage.length() ==0){
  	cPage = 1;
  } try {
	  cPage = Integer.parseInt(tempPage);
  } catch(NumberFormatException e) {
	  cPage = 1;
  }
  %>
  <!-- main start-->
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h3>
		  드론 등록하기
		</h3>
		<form name="f" method="post" action="save.jsp">
		<div class="form-group row">
		    <label for="no" class="col-sm-2 col-form-label">번호</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="no" name="no">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="no" class="col-sm-2 col-form-label">제품명</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dname" name="dname">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="name" class="col-sm-2 col-form-label">가격</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dprice" name="dprice">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="loc" class="col-sm-2 col-form-label">지역</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dland" name="dland">
		    </div>
		  </div>
		</form>
		<div class="text-right">
			<a href="list.jsp?page=<%=cPage %>" class="btn btn-outline-secondary">목록</a>
			<button type="button" id="saveDron" class="btn btn-outline-success">저장</button>
        </div>
        <input type="hidden" name="regdate" id="regdate" />
      </div>
    </div>
  </div>
  <!-- main end-->
  <%@ include file="../inc/footer.jsp" %> 
  
  <script>
  $(function(){
	  $("#dname").focus();
	  $("#saveDron").click(function(){
		  //자바스크립트 유효성 검사
		  if($("#dname").val().length==0){
			  alert("부서번호를 입력하세요.");
			  $("#dname").focus();
			  return;
		  }
		  if($("#dprice").val().length==0){
			  alert("부서명을 입력하세요.");
			  $("#dprice").focus();
			  return;
		  }
		  if($("#dland").val().length==0){
			  alert("부서위치를 입력하세요.");
			  $("#dland").focus();
			  return;
		  }
		  f.submit();
	  });
  });
  </script>
  
  
  
 
 
 
 
 
 
 
  
  