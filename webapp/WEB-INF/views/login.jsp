<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("euc-kr");
   String name = request.getParameter("name");
%>
<% out.print(name); 
System.out.println("login.jsp 호출됨");%>