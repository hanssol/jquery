<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP</h1>
	<p> 클라이언트에서 요청시 데이터를 전달 받아서 처리하고 
	결과를 생성한다. </p>
	
	<p>생성된 결과를 요청한 클라이언트의 응답으로 보낸다</p>
	<p>응답시 새로운페이지를 만들지 않는다</p>
	<p>자바코드를 이용해서 데이터 가져오기 : request.getParameter("name")</p>
	<%
	//요청시 가져오는 데이터
		String userName = request.getParameter("name");
	%>
	<!-- 응답할 데이터 생성 -->
	환영합니다 <%=userName %>님<br>
	좋은하루 되세요~~
	
		
</body>
</html>