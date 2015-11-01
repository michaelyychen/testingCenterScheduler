<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="tsc.web.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<ExamBean> examList = (List<ExamBean>)request.getAttribute("exams"); %>

<select>
<%for(int i=0;i<examList.size();i++){ %>
<option><%=examList.get(i).getClassName() %></option>
<%}%>
</select>

</body>
</html>