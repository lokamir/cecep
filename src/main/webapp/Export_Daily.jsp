<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.bstek.ureport.export.html.HtmlReport"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.bstek.ureport.export.ExportManager"%>
<%@page import="com.bstek.ureport.Utils"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报表导出</title>
</head>
<body>
<%
SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
Date filedate=sdf.parse(request.getParameter("date"));
SimpleDateFormat fd =   new SimpleDateFormat( "yyyy年MM月dd日" );
String filename = fd.format(filedate)+"惠山水务洛社污水厂运营日志.xlsx";
%>
<!-- 通过一个HTML链接来导出目标报表模版的excel格式报表 -->
<a href="<%=request.getContextPath() %>/ureport/excel?_n=<%=filename%>&_u=file:Daily.ureport.xml&deptid=<%=request.getParameter("deptid")%>&date=<%=request.getParameter("date")%>">导出excel格式报表</a>
<p></p>
<%
ExportManager  exportManager=(ExportManager)Utils.getApplicationContext().getBean(ExportManager.BEAN_ID);
Map<String,Object> parameters=new HashMap<String,Object>();
System.out.println(request.getParameter("deptid"));
System.out.println(request.getParameter("date"));
parameters.put("deptid",request.getParameter("deptid"));
parameters.put("date",request.getParameter("date"));
HtmlReport htmlReport = exportManager.exportHtml("file:Daily.ureport.xml",request.getContextPath(),parameters);
//输出Css样式
out.println("<style type=\"text/css\">");
out.println(htmlReport.getStyle());
out.println("</style>");
//输出报表内容
out.println(htmlReport.getContent());
%>
</body>
</html>