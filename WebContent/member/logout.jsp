<%@ page pageEncoding="utf-8" %>

<%
	/*
	HttpSession 객체를 종료하는 방법
	1. 브라우저를 종료했을 경우.
	2. 해당페이지의 시간이 세션 만료 시간을 경과했을 경우.
	3. invalidate()메서드를 호출하는 경우.
	*/
	session.removeAttribute("member"); //세션에 멤버만 지우는 것. 1개만. 장바구니 비우기 같은거 할 때. 
	session.invalidate(); //이건 세션을 통으로 날리는 거. 로그아웃할때, 전부 날린다.
	response.sendRedirect("/index.jsp");
%>