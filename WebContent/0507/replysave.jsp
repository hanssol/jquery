<%@page import="kr.or.ddit.board.service.IBoardServiceImpl"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	ReplyVO vo = new ReplyVO();
	
	BeanUtils.populate(vo, request.getParameterMap());
	
	IBoardService service = IBoardServiceImpl.getInstance();
	
	int renum = service.insertReply(vo);
	if(renum >0){
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