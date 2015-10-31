<%@page import="com.alibaba.fastjson.JSON"%>

<<jsp:include page="login.jsp"></jsp:include>

 Welcome ${user.email} !!!
 <br>
 <%=
 JSON.toJSONString(pageContext.getRequest().getAttribute("exams"))
 %>
</body>
</html>