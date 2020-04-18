<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
<jsp:include page="sub/account.css.jsp"></jsp:include>
</style>
<script type="text/javascript" src="<%=host%>/js/jquery.min.js"></script>
<jsp:include page="sub/account.js.jsp"></jsp:include>
</head>

<body>
<jsp:include page="sub/account.jsp"></jsp:include>
 <div class="wrapper">
   <header>
     <jsp:include page="sub/topnav.jsp"></jsp:include>
     </header>
     </div>
</body>
</html>