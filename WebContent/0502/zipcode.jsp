<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
    <%
       request.setCharacterEncoding("UTF-8");
       
       String dongs = request.getParameter("dong1");
      IMemberService service = MemberServiceImpl.getInstance();
      List<ZipVO> list = service.getZipcode(dongs);
       
      for(int i = 0; i < list.size(); i++){
         ZipVO vo = list.get(i);
         if(i > 0){
            out.print(",");
         }
         String bun = vo.getBUNJI();
         if(bun == null){
            bun = "";
         }
         %>
         
         {
            "sido" : "<%= vo.getSIDO() %>",
            "gugun" : "<%= vo.getGUGUN() %>",
            "dong" : "<%= vo.getDONG() %>",
            "code" : "<%= vo.getZIPCODE() %>",
            "bunji" : "<%=bun%>",
            
            "addr" : "<%=vo.getSIDO()%><%=vo.getGUGUN()%><%=vo.getDONG()%>"
            
         }
         
         
         
         <%
         
      }
         
         %>
         
]
