<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.service.IBoardServiceImpl"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	String cpage = request.getParameter("cpage");

	IBoardService service = IBoardServiceImpl.getInstance();
	
	List<BoardVO> list = service.boardListAll();
	for(int i=0; i<list.size();i++){
		BoardVO vo = list.get(i);
		if(i>0)out.print(",");

%>
	{
		"seq" : "<%= vo.getSeq() %>",
		"subject" : "<%= vo.getSubject() %>",
		"writer" : "<%= vo.getWriter() %>",
		"mail" : "<%= vo.getMail() %>",
		"content" : "<%= vo.getContent().replaceAll("\r\n", "<br>") %>",
		"wdate" : "<%= vo.getWdate() %>",
		"hit" :"<%=vo.getHit() %>"
	
	}


<%
	}
%>
]
