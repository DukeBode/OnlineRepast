<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String host = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
  function tijiao(){
	  var r=confirm("确认是否付款？")
	  if (r==true){
		  var myform = document.getElementById("myform");
		  myform.submit();		
	  }  
  }
</script>
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
<form action="<%=host%>/user/pay" method="post" id="myform">
	<table align="center" width=90%>
      <tr>
      	<td>
      		<table border="1" width=100%> 
      			<tr><td>餐饮</td><td>分类</td><td>价格</td><td width="5%">数量</td></tr>	
      			<c:forEach items="${repasts}" var="repast">  		
       				<tr><td>${repast.name}</td><td>${repast.categoryid}</td><td>${repast.price}</td><td >${cartmap[repast.id]}件</tr>    
				</c:forEach>
				
       			
      			    <tr><td colspan=4 align=center>账户余额：￥${user.status}  &nbsp;&nbsp;&nbsp;&nbsp; 
      			         消费总额：￥   <fmt:formatNumber value="${allpay}" pattern="#.00" type="number"/> </td></tr>
      			  
      			         
    		</table>
      	</td>
      </tr>
      <tr>
     		 <td align="center">
      	    	<c:if test="${user.status>=allpay}">
      		    	<input type="button" value="付款确认" onclick="tijiao()">&nbsp;
      			</c:if> 
      			<c:if test="${user.status<allpay}">
      			    <p style="color:red;font-size:8px;">账户金额不足,请充值！</p>
      		    </c:if>       			
      		 	<a href="<%=host%>/cart/detail">返回</a>
      		 </td>        	
      </tr>
    
    </table>
	</form>
	
</div>
</body>
</html>