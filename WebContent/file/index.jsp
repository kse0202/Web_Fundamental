<%@ page pageEncoding="utf-8"%>
<%@ include file="../inc/header.jsp"%>
<!-- breadcrumb start-->
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="/index.jsp">Home</a></li>
		<li class="breadcrumb-item active" aria-current="page">DEPT</li>
	</ol>
</nav>
<!-- breadcrumb end-->
<%
	int cPage = 0;
	String tempPage = request.getParameter("page");
	if (tempPage == null || tempPage.length() == 0) {
		cPage = 1;
	}
	try {
		cPage = Integer.parseInt(tempPage);
	} catch (NumberFormatException e) {
		cPage = 1;
	}
%>
<!-- main start-->
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h3>파일 업로드</h3>
			<!-- 파일 업로드는 이거 꼭 추가해줘야 한다. enctype="multipart/form-data" -->
			<form name="f" method="post" enctype="multipart/form-data"
				action="upload.jsp">
				
				<div class="custom-file">
					<input type="file" class="custom-file-input"
						id="validatedCustomFile" name = "file" required> <label
						class="custom-file-label" for="validatedCustomFile">파일을 선택하세요</label>
					<div class="invalid-feedback">Example invalid custom file
						feedback</div>
				</div>
			</form>+-
			<div class="text-right">
				
				<button type="button" id="uploadFile" class="btn btn-outline-success">저장</button>
				
			</div>
		</div>
	</div>
</div>
<!-- main end-->
<%@ include file="../inc/footer.jsp"%>

<script>
	$(function(){
		$("#uploadFile").click(function(){
			f.submit();
		});
	});
</script>











