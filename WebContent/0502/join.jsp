<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");

/*
   String  idval = request.getParameter("id");
   String  nameval = request.getParameter("name");
   String  passval = request.getParameter("pass");
   String  mailval = request.getParameter("mail");
   String  zipval = request.getParameter("zip");
   String  add1val = request.getParameter("add1");
   String  add2val = request.getParameter("add2");
   
   MemberVO  vo = new MemberVO();
   vo.setMem_id(idval);
   vo.setMem_name(nameval);
   vo.setMem_pass(passval);
   vo.setMem_mail(mailval);
   vo.setMem_zip(zipval);
   vo.setMem_add1(add1val);
   vo.setMem_add2(add2val);
   */
   
   MemberVO  vo = new MemberVO();
   BeanUtils.populate(vo, request.getParameterMap());
   
   IMemberService  service = MemberServiceImpl.getInstance();
   String resid = service.insertMember(vo);
  
   //결과 resid를 가지고 json데이타 생성 
   if(resid != null){
       //가입성공 
%>       
   
   {
      "sw" : "OK",
      "id" : "<%= vo.getMem_id() %>"
   }
       
<%   }else {
      //가입실패
%>      
   {
      "sw" : "NO",
      "id" : "<%= vo.getMem_id() %>"
   }   
<%      
   }
 %>







