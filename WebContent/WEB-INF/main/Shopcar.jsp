<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
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
     
<form action="<%=host%>/cart/checkout" method="post">
<table align="center" width=90%>
      <tr>
      	<td>
      		<table border="1" width=100%> 
      			<tr><td>餐饮</td><td>分类</td><td>价格</td><td width="5%">数量</td><td>操作</td></tr>	
      			<c:forEach var="repast" items="${repasts}">
      			    <tr><td>${repast.name}</td><td>${repast.categoryid}</td>
      			        <td>${repast.price}</td>
      			        <td ><input type="number"  name="bk${repast.id}" value="${cartmap[repast.id]}" pattern="[0-9]*" onchange="$.get('<%=host%>/cart/num?id=${repast.id}&num='+this.value);"/></td>
      			        <td><a href="<%=host%>/cart/num?num=del&id=${repast.id}">移除</a></td></tr>
      			</c:forEach>  	
    		</table>
      	</td>
      </tr>
      <tr>
           <td align="center">
           <c:if test="${shopCars.size()<1}">
  <span style="color: #FF5500;font-size: 28px">亲，你的购物车还没有商品哦！</span>
  </c:if>
      	   		<c:if test="${repasts.size() > 0 }">
      	     		<input type="submit" value="结算"> &nbsp;
      	   		</c:if>
      		<a href="<%=host%>">返回</a></td>
        	
      </tr>    
    </table>
    </form>
     </div>
 
</body>
</html>