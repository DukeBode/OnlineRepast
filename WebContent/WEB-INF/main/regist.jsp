<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="regist" method="post" id="myform">
	 <table  align="center">
				<tr><td height=100></td></tr>
				<tr>
				  <td width="107" height="36">用户名：</td>
				  <td width="524"><INPUT name="uname" id="uname" type="text" maxlength="16" onkeyup="checkUname()">
					   <span style="color:red;font-size:8px" id="unameAlert"></span>
				  </td>
				</tr>
				<tr>
				  <td width="107" height="36">密码：</td>
				  <td width="524"><INPUT name="pwd" id="pwd" type="password"></td>
				</tr>
				<tr>
				  <td width="107" height="36">确认密码：</td>
				  <td width="524"><INPUT name="pwd2" id="pwd2" type="password"></td>
				</tr>
				<tr>
				<td width="107" height="36">性别：</td>
				<td width="524">
					<INPUT name="gen" type="radio"   value="男" checked>男&nbsp; 
					<INPUT name="gen" type="radio" value="女" >女
				</td>
			   </tr>
				<tr>
				<td width="107" height="36">电子邮件：</td>
				<td width="524"><INPUT name="email" type="text"></td>
			  </tr>   
				<tr>
					<td colspan=2 >
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="提交" onclick="tijiao()"> &nbsp; <a href="">返回</a>
					</td>					
				</tr>
				<tr>
					<td colspan="2" align="center">
						<span style="color:red;font-size:8px">${msg}</span>
					</td>
				</tr>
			</table>
   </form>  
</body>
</html>