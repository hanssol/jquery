
<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="kr.or.ddit.lprod.service.LprodServiceImpl"%>
<%@page import="kr.or.ddit.lprod.service.ILprodService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    [
    <% 
    
       ILprodService service = LprodServiceImpl.getInstance();
    
       List<LprodVO> list = service.getAllLprod();
       
       for(int i=0; i<list.size(); i++){
          
          LprodVO vo = list.get(i);
          if(i>0) out.print(",");
          
       %>
       
          {
             "id" : "<%= vo.getLprod_id() %>",
             "gu" : "<%= vo.getLprod_gu() %>",
             "nm" : "<%= vo.getLprod_nm() %>"
       
       
          }
       
       
       <%
       }
    
    
    
    %>
    ]
    