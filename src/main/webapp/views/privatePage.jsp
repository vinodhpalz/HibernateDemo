<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Private Page</h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="success.jsp">Success</a>

</sec:authorize>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
<h1>User Logged in as: ${user}</h1>
</body>
</html>