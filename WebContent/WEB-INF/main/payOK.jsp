<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <table align="center" width=60%> 
      <tr>
      	<td height="180"></td>    
      	<td style="color:black;font-size:18px">      	
      	      	   
      	           付款成功！ 付款人:${user.name} <br>
      	           付款金额： ￥${allpay}       
      	   <p style="color:red;font-size:30px">
      	          我们会尽快为您进行配送
      	   </p>      	             	  
      		
      	</td>
      </tr>  
      <tr><td height="80"></td></tr>    
      <tr>      	
      		<td colspan="2" align="center"> <a href="<%=host%>">返回主页</a></td>        	
      </tr>    
    </table>

</body>
</html>