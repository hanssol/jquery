<%@page import="kr.or.ddit.board.service.IBoardServiceImpl"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	BoardVO vo = new BoardVO();
	BeanUtils.populate(vo, request.getParameterMap());
	
	vo.setWip(request.getRemoteAddr());
	
	IBoardService service = IBoardServiceImpl.getInstance();
	
	int seq = service.insertBoard(vo);
	
	if(seq > 0){
%>
	{
		"sw" : "저장성공"
		
	}
<%
}else{
%>
{
		"sw" : "저장실패"
		
	}
	
<%	
	}
	
%>